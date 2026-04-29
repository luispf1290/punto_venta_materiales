import { useAppDispatch, useAppSelector } from "@/presentation/store/hooks/useApp"
import { loginThunk } from "../Slices";
import { LoginRequest } from "@/domain/DTO/auth.dto";


export const useAuthStore = () => {

    const dispatch  = useAppDispatch(); 
    const { user, error,loading } = useAppSelector((state) => state.auth);

    const startLogin = (user: LoginRequest) =>{
        dispatch(loginThunk(user))
    }

    return {
        startLogin,
        user,
        error,
        loading
    }
}