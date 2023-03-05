import { axiosInstance } from "../base/axios-instance"

export function usePosts(){
    
    async function getPosts() {
        const response = await axiosInstance.get(
          "/perfis/postagens"
        )
    
        return response.data;
    }

    return { getPosts } 
}