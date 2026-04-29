import { createTheme, CssBaseline, Grid, Stack, styled } from "@mui/material";
import { useEffect } from "react";
import { useAuthStore } from "../hooks/useAuthStore";
import { ThemeProvider } from "@emotion/react";
import { LoginForm } from "../components/LoginForm";

const defaulTheme = createTheme();


export const LoginPage = () => {
  const { error } = useAuthStore();

  useEffect(() => {
    if (error !== undefined) {
      //TODO: Mostrar error en pantalla
      // console.error('Error en la autenticacion', error);
    }
  }, [error]);


  return <ThemeProvider theme={defaulTheme}>
    <Grid container component="main"></Grid>
      <CssBaseline />
      <LoginForm />
  </ThemeProvider>;
};
