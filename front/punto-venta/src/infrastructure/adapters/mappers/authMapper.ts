import { AuthResponse } from "@/domain/DTO";
import { AuthState } from "@/domain/entities/AuthUser";

export const authMapper = {
    toDomain(data:AuthState):AuthResponse{
        return {
                jwToken: data.jwToken,
                refreshToken: data.refreshToken,
                usuario: {
                    username: data.usuarior?.username || '',
                    roles: data.usuarior?.roles || 'ANALISTA'
                }
        }
    }
}