import { AuthResponse } from "@/domain/DTO";
import { TOKEN_KEY,USER_KEY, REFRESH_TOKEN_KEY } from "@/types/jwt";



export const tokenService = {
    setSession(user:AuthResponse){
        if(user?.jwToken){
            localStorage.setItem(TOKEN_KEY, user.jwToken);
            localStorage.setItem(REFRESH_TOKEN_KEY, user.refreshToken);
            localStorage.setItem(USER_KEY, JSON.stringify(user));
        }
    },

    getToken(){
        return localStorage.getItem(TOKEN_KEY);
    },

    getRefreshToken(){
        return localStorage.getItem(REFRESH_TOKEN_KEY);
    },

    getUser(){
        const data = localStorage.getItem(USER_KEY);
        return data ? JSON.parse(data) : null;
    },

    clearSession(){
        localStorage.removeItem(TOKEN_KEY);
        localStorage.removeItem(REFRESH_TOKEN_KEY);
        localStorage.removeItem(USER_KEY);
    }
}