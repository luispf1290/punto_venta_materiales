export interface AuthUser {
  id: number;
  username: string;
  roles: 'ADMIN' | 'CASHIER' | 'MANAGER';
  token: string;
}

export interface AuthState {
  user: AuthUser | null;
  token: string | null;
  refreshToken: string | null;
  isAuthenticated: boolean;
}