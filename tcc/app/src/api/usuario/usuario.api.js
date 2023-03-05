import { axiosInstance } from "../base/axios-instance";
export function useUsuario() {

    async function dadosUsuario() {
        const response = await axiosInstance.get(
            "/usuarios/me"
        )
        return response.data.data;
    }

    return { dadosUsuario }
}