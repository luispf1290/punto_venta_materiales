import { instance } from "@/infrastructure/api";
import { tokenService } from "./tokenService";

let isRefreshing = false;
let failedQueue: any[] = [];

const processQueue = (error: any, token: string | null = null) => {
  failedQueue.forEach((prom) => {
    if (error) {
      prom.reject(error);
    } else {
      prom.resolve(token);
    }
  });
  failedQueue = [];
};

export const refreshService = {
  async refreshToken() {
    tokenService.getRefreshToken();

    return instance.post("/auth/refresh", {
      refreshToken: tokenService.getRefreshToken(),
    });
  },

  async handleRefresh(error: any, originalRequest: any) {
    if (isRefreshing) {
      return new Promise((resolve, reject) => {
        failedQueue.push({ resolve, reject });
      })
        .then((token) => {
          originalRequest.headers["Authorization"] = "Bearer " + token;
          return instance(originalRequest);
        })
        .catch((err) => Promise.reject(err));
    }

    isRefreshing = true;

    try {
      const response = await this.refreshToken();
      const newToken = response.data.jwToken;
      
      tokenService.setSession(response.data);

      processQueue(null, newToken);

      originalRequest.headers["Authorization"] = "Bearer " + newToken;

      return instance(originalRequest);
    } catch (err) {
      processQueue(err, null);
      tokenService.clearSession();
      window.location.href = "/login";
      return Promise.reject(err);
    } finally {
      isRefreshing = false;
    }
  },
};
