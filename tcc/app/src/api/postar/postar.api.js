import { axiosInstance } from "../base/axios-instance"

export function usePostar(){
       
    async function getPostar({ urlPostagem}) {
        const response = await axiosInstance.post(
            "perfis/postar",
            {urlPostagem})
    
        return response.data;
    }

    return { getPostar } 
}