export interface AuthRequest {
  username: string;
  password: string;
}

export interface AuthResponse {
  jwToken: string | null;
  refreshToken: string;
  usuario: AuthDetails;
}

interface AuthDetails {
   username: string;
   roles: 'ADMIN' | 'ANALISTA' | 'CAJERO' | 'SUPERVISOR';
}