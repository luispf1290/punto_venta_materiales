import { LoginRequest, LoginResponse } from "@/domain/DTO";
import { instance } from "./axiosInstance";

export const authApi = {
    login: (data:LoginRequest) => {
        const resp = instance.post<LoginResponse>('/auth/login', data)
        return resp;
    },
};