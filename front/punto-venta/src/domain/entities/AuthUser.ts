export interface AuthUser {
  id: number;
  username: string;
  roles: 'ADMIN' | 'ANALISTA' | 'CAJERO' | 'SUPERVISOR';
}

export interface AuthState {
  jwToken: string | null;
  refreshToken: string;
  usuarior: AuthUser | null;
  isAuthenticated: boolean;
}