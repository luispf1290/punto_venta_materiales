import { AuthRequest } from "@/domain/DTO";
import { instance } from "./axiosInstance";
import { AuthState } from "@/domain/entities/AuthUser";

export const authApi = {
    login: (data:AuthRequest) => {
        const resp = instance.post<AuthState>('/auth/login', data)
        return resp;
    },
};