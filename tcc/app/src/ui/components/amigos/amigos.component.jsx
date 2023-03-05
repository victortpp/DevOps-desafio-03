import { useNavigate } from "react-router-dom"
import "./index.css"

export function AmigosComponent({listaAmigos}){
    const navigate = useNavigate()

    return(
        <>
        {listaAmigos?.map((amigo) => (
            <div key={amigo.id} className="card-amigo">
                <img className="imagem-post" src={amigo.urlImagem} alt = "imagem post"/>
                <p>Nome: {amigo.nome}</p>
                <button onClick={(()=>  navigate("/perfil"))} className="botao-desfazer-amizade"> Desfazer Amizade </button>
            </div>
        ))}
    </>
    )
}