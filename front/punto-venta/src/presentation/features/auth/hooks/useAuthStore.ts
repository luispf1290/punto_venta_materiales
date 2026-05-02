import { useAppDispatch, useAppSelector } from "@/presentation/store/hooks/useApp"
import { loginThunk } from "../Slices";
import { AuthRequest } from "@/domain/DTO/auth.dto";


export const useAuthStore = () => {

    const dispatch  = useAppDispatch(); 
    const { user, error,loading } = useAppSelector((state) => state.auth);

    const startLogin = (user: AuthRequest) =>{
        dispatch(loginThunk(user))
    }

    return {
        startLogin,
        user,
        error,
        loading
    }
}