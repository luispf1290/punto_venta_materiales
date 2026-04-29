import { LoginResponse } from "@/domain/DTO";

export const authMapper = {
    toDomain(data:LoginResponse){
        return {
                jwToken: data.jwToken,
                refreshToken: data.refreshToken,
        }
    }
}