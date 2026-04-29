import { LoginResponse } from '../DTO/auth.dto';
export interface AuthRepository {
    login(username: string, password: string): Promise<LoginResponse>;
    logout(): Promise<void>;
    isAuthenticated(): Promise<boolean>;
}