import { AuthResponse } from "../DTO";
export interface AuthRepository {
    login(username: string, password: string): Promise<AuthResponse>;
    logout(): Promise<void>;
    // isAuthenticated(): Promise<boolean>;
}