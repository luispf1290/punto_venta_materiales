import { createAsyncThunk } from "@reduxjs/toolkit";
import { AuthRepositoryImpl } from "@/infrastructure/repositories/AuthRepositoryImpl";
import { login } from "@/aplication/auth";

import { tokenService } from "@/services/tokenService";
import { LoginRequest, LoginResponse } from "@/domain/DTO";


const repo = new AuthRepositoryImpl();

export const loginThunk = createAsyncThunk(
    "auth/login",
    async ({username,password}:LoginRequest, { rejectWithValue }) => {
        try{
            const user:LoginResponse = await login(username, password, repo);
            tokenService.setSession(user);
            return user;
        }catch(error:any){
            console.error('Error status:', error.response?.status);
            console.error('Error data:', error.response?.data);
            console.error('Error headers:', error.response?.headers);
            return rejectWithValue(error.message);
        }
    }
);