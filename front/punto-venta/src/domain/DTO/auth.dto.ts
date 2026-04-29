export interface LoginResponse {
    // id: string;
    // email: string;
    // fullName: string;
    // role: 'ADMIN' | 'CASHIER' | 'MANAGER';
    jwToken: string;
    refreshToken: string;
  };


export interface LoginRequest {
  username: string;
  password: string;
}
