import { axiosInstance } from "../base/axios-instance"

export const useAuth = () => {
    async function login({ username, password }) {
      const response = await axiosInstance.post(
        "/login",
        {},
        {
          auth: {
            username,
            password,
          },
        }
      );
  
      return response.data;
    }
  
    async function register(body) {
      const response = await axiosInstance.post("/usuarios", body);
  
      return response.data;
    }
  
    async function logout() {
      const response = await axiosInstance.post("/logout");
  
      return response.data;
    }
  
    async function userMe() {
      const response = await axiosInstance.get("/perfis/me");
  
      return response.data;
    }
  
    return { login, register, logout, userMe };
  };