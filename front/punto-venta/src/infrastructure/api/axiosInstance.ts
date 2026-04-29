import { TOKEN_KEY } from "@/types/jwt";
import { getEnvVaribles } from "@/utils/getEnvVariables";
import axios from "axios";

const { VITE_API_URL } = getEnvVaribles();

export const instance = axios.create({
  baseURL: VITE_API_URL,
  headers: {
    "Content-Type": "application/json",
  },
});

instance.interceptors.request.use((config) => {

   const url = config.url || '';
  if (url.includes('/auth/login') || url.includes('/auth/register') || url.includes('/auth/refresh')) {
    return config;
  }

  let token = localStorage.getItem(TOKEN_KEY);
  if (!token) return config;
  token = token.trim().replace(/^"|"$/g, "");
  token = decodeURIComponent(token);
  token = token.replace(/\s+/g, "");
  
  if (!/^[A-Za-z0-9\-_]+\.[A-Za-z0-9\-_]+\.[A-Za-z0-9\-_]+$/.test(token)) {
    console.warn("Token no tiene formato JWT Base64URL válido:", token);
    return config;
  }

  if (token) config.headers["Authorization"] = `Bearer ${token}`;
  return config;
});

//interceptor para refresh token
instance.interceptors.response.use(
  (response) => response,
  async (error) => {
    const originalRequest = error.config;
    if (error.response.status === 401 && !originalRequest._retry) {
      originalRequest._retry = true;
    }
    return Promise.reject(error);
  },
);
