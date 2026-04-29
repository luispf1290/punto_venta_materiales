import { JSX } from "react";
import { Navigate } from "react-router";
import { useAppSelector } from "../store/hooks/useApp";

interface ProtectedRoutesProps {
    children: JSX.Element | JSX.Element[];
    roles: string[];
}

export const ProtectedRoutes = ({ children, roles }: ProtectedRoutesProps) => {
    const {isAuthneticated, user} = useAppSelector(state => state.auth);

    if(!isAuthneticated){
        return <Navigate to="/login" replace />
    }

    if(roles && !roles.some((role:string) => user.roles.includes(role))){
        return <Navigate to="/unauthorized"/>
    }

    return children
};
