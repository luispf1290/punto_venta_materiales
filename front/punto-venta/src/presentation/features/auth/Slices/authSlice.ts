import { tokenService } from "@/services/tokenService";
import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { loginThunk } from "./authThunks";
import { LoginResponse } from "@/domain/DTO";

const initialState = {
    user: tokenService.getUser(),
    isAuthneticated: !!tokenService.getToken(),
    loading: false,
    error: null as string | null
}

export const authSlice = createSlice({
    name: "auth",
    initialState,
    reducers: {
        logout(state){
            state.user = null;
            state.isAuthneticated = false;
            tokenService.clearSession();
        }
    },

    extraReducers: (builder) => {
        builder.addCase(loginThunk.pending, (state) => {
            state.loading = true;
        })
        .addCase(loginThunk.fulfilled, (state, { payload }:PayloadAction<LoginResponse>) => {
            state.loading = false;
            state.user = payload;
            state.isAuthneticated = true;
        })
        .addCase(loginThunk.rejected, (state, action) => {
            state.loading = false;
            state.error = action.payload as string | null;
        });
    }
});

export const { logout } = authSlice.actions;
export default authSlice.reducer;