import { AuthRepositoryImpl } from "@/infrastructure/repositories/AuthRepositoryImpl";

export const login  = async  (username: string, password: string, repo:AuthRepositoryImpl) => {
    if (!username || !password) {
        throw new Error('Credenciales requeridas');
    }

    return await repo.login(username, password);
}