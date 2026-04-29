import { authMapper } from "../adapters/mappers";
import { authApi } from "../api";

export class AuthRepositoryImpl {
    async login(username:string, password:string){
        const response = await authApi.login({ username, password });
        return authMapper.toDomain(response.data);
    }
}