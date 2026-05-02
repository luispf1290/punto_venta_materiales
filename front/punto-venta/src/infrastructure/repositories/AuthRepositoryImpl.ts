import { AuthRepository } from "@/domain/repositories";
import { authMapper } from "../adapters/mappers";
import { authApi } from "../api";

export class AuthRepositoryImpl implements AuthRepository {
    async login(username:string, password:string){
        const response = await authApi.login({ username, password });
        return authMapper.toDomain(response.data);
    }

    async logout(){
        //TOD: await authApi.logout();
    }
}