import { axiosInstance } from "../base/axios-instance"

export function useDesfazerAmizade() {
    async function desfazerAmizade(id) {
        const response = await axiosInstance.put(
            `perfis/desfazer-amizade/${id}`
        )

        return response.data;
    }

    return { desfazerAmizade }
}