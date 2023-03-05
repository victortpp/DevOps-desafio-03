import "./index.css"
import { useEffect, useState } from "react";
import { useGlobalUser } from "../../../contexts/user/user.contexts";
import{ useAmigos } from "../../../api"
import { AmigosComponent } from "../../components";

export function AmigosScreen(){
    const [user] = useGlobalUser()
    const [amigos, setAmigos ] = useState()
    const {getAmigos} = useAmigos()
   
    useEffect(() => {

        async function listarAmigos() {
            const lista = await getAmigos()
            setAmigos(lista)
        }
        listarAmigos()
    }, [])
    
    console.log(amigos)
    return(
       <div className="lista-amigos-container">
        <AmigosComponent listaAmigos={amigos}/>
       </div>
    )
}