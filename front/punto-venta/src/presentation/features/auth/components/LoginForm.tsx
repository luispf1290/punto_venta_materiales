import { useFormik } from "formik";
import { useAuthStore } from "../hooks/useAuthStore";
import { Avatar, Box, Button, Grid, styled, TextField, } from '@mui/material';
import MuiCard from '@mui/material/Card';
import { LockClockOutlined } from "@mui/icons-material";
import { Link } from "react-router";
import * as Yup from 'yup';

interface InitialValuesLogin {
    username: string,
    password: string
}

const Card = styled(MuiCard)(({ theme }) => ({
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    width: '100%',
    padding: theme.spacing(4),
    gap: theme.spacing(2),
    margin: 'auto',
    [theme.breakpoints.up('sm')]: {
        maxWidth: '450px',
    },
    boxShadow:
        'hsla(220, 30%, 5%, 0.05) 0px 5px 15px 0px, hsla(220, 25%, 10%, 0.05) 0px 15px 35px -5px',
    ...theme.applyStyles('dark', {
        boxShadow:
            'hsla(220, 30%, 5%, 0.5) 0px 5px 15px 0px, hsla(220, 25%, 10%, 0.08) 0px 15px 35px -5px',
    }),

}));

export const LoginForm = () => {
    const { startLogin } = useAuthStore();

    const { handleSubmit, errors, touched, getFieldProps } = useFormik<InitialValuesLogin>({
        initialValues: {
            username: '',
            password: ''
        },

        onSubmit: values => {
            startLogin(values);
        },

        validationSchema: Yup.object({
            username: Yup.string().required('Es requerido'),
            password: Yup.string().min(6, 'El minimo son 6 caracteres').required('Es requerido')
        })
    })

    return <Card variant="outlined">
        <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
            <LockClockOutlined />
        </Avatar>

        <Box
            component="form"
            noValidate
            onSubmit={handleSubmit} sx={{ display: 'flex', flexDirection: 'column', width: '100%', gap: 2 }}
        >
            <TextField
                margin="normal"
                fullWidth
                id='username'
                label="Username"
                autoComplete="username"
                autoFocus
                {...getFieldProps('username')}
            />
            {touched.username && errors.username && <span className="error-message">{errors.username}</span>}
            <TextField
                margin="normal"
                fullWidth
                label="Password"
                type="password"
                id="password"
                autoComplete="current-password"
                {...getFieldProps('password')}
            />
            {touched.password && errors.password && <span style={{ marginBottom: 20 }} className="error-message">{errors.password}</span>}

            {/* <FormControlLabel
                            control={<Checkbox value="remember" color="primary" />}
                            label="Remember me"
                        /> */}

            <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
            >
                Sign In
            </Button>
            <Grid container>
                <Grid>
                    <Link to='#' >
                        Forgot password?
                    </Link>
                </Grid>
                <Grid>
                    <Link to="/register" replace={true}>
                        {"Don't have an account? Sign Up"}
                    </Link>
                </Grid>
            </Grid>
        </Box>
    </Card>
        ;
};