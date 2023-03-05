import "./index.css"
import { useEffect, useState } from "react"
import { useAuth, usePosts } from "../../../api"
import { useGlobalUser } from "../../../contexts/user/user.contexts"
import { useNavigate } from "react-router-dom";
import { PostagensLista } from "../../components";


function getAge(dateString) {
    const today = new Date();
    const birthDate = new Date(dateString);
    let age = today.getFullYear() - birthDate.getFullYear();
    const m = today.getMonth() - birthDate.getMonth();

    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }

    return age;
}

export function PerfilScreen() {
    const [user] = useGlobalUser()
    const [listaPosts, setListaPosts] = useState()
    const auth = useAuth()
    const { getPosts } = usePosts()
    const navigate = useNavigate()

    useEffect(() => {

        async function postagens() {
            const list = await getPosts()
            setListaPosts(list)
        }
        postagens()
    }, [])

    async function handleClick(event) {
        event.preventDefault();
        try {
            const user = await auth.logout()
            navigate("/")
        } catch (error) {
            console.log("erro")
        }
    }

    return (
        <main className="container-perfil-screen">
            <div className="perfil-usuario">
                <div>
                    <img className="imagem-perfil" src={user?.urlImagem} alt="imagem perfil" />
                    <div className="dados-usuario">
                        <p>Nome: {user?.nome}</p>
                        <p>Apelido: {user?.apelido}</p>
                        <p>Idade: {getAge(user?.dataNascimento)}</p>
                        <p>Email de contato: {user?.email} </p>
                    </div>
                </div>
                <div className="boteos-perfil">
                    <button className="botao-logout" onClick={handleClick}> Sair </button>
                    <button  className="botao-logout" onClick={(()=> navigate('/amigos'))}>Amigos</button>
                    <button  className="botao-logout" onClick={(()=> navigate('/postar'))}>Postar</button>
                </div>
            </div>
            <div className="postagens-usuarios">
                <PostagensLista listaPosts={listaPosts} />
            </div>
        </main>
    )
}