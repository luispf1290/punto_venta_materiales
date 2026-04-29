import { Route, Routes } from "react-router";
import { LoginPage } from "../features/auth/pages";
import { ProtectedRoutes } from "./ProtectedRoutes";

export const AppRoutes = () => {
  return <Routes>
    <Route path="/login" element={<LoginPage />} />
    <Route
      path="/dashboard"
      element={
        <ProtectedRoutes roles={["admin", "user"]}>
          <>
          </>
        </ProtectedRoutes>
      }
    />

    <Route
      path="/admin"
      element={
        <ProtectedRoutes roles={["ADMIN"]}>
          <>
          </>
        </ProtectedRoutes>
      }
    />

  </Routes>
};


