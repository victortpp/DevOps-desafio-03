import { axiosInstance } from "../base/axios-instance"

export function useAmigos() {
    async function getAmigos() {
        const response = await axiosInstance.get(
            "/perfis/amigos"
        )

        return response.data;
    }

    return { getAmigos }
}