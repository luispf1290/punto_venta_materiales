import { LoginResponse } from "@/domain/DTO";
import { TOKEN_KEY } from "@/types/jwt";
import { USER_KEY } from '../types/jwt';



export const tokenService = {
    setSession(user:LoginResponse){
        if(user?.jwToken){
            localStorage.setItem(TOKEN_KEY, user.jwToken);
            localStorage.setItem(USER_KEY, JSON.stringify(user));
        }
    },

    getToken(){
        return localStorage.getItem(TOKEN_KEY);
    },

    getUser(){
        const data = localStorage.getItem(USER_KEY);
        return data ? JSON.parse(data) : null;
    },

    clearSession(){
        localStorage.removeItem(TOKEN_KEY);
        localStorage.removeItem(USER_KEY);
    }
}