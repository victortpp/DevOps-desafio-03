import "./index.css"

import { useState } from "react"
import { useNavigate } from "react-router-dom";
import { useAuth } from "../../../api/login/login.api";
import { useGlobalUser } from "../../../contexts/user/user.contexts";

const DADOS_INICIAIS = { username: "", password: "" };

export function LoginScreen() {
    const [usuario, setUsuario] = useState(DADOS_INICIAIS)

    const [user, setUser] = useGlobalUser();
    const auth = useAuth()
    const navigate = useNavigate()


    function handleChange({ target }) {
        const { name, value } = target;

        setUsuario((oldUserInfo) => ({ ...oldUserInfo, [name]: value }));
    }

    async function handleSubmit(event) {
        event.preventDefault();
        try {
            const user = await auth.login({
                username: usuario.username,
                password: usuario.password,
            });
            setUser(user)
            navigate("/perfil")
        } catch (error) {
            console.log("erro")
        }
    }
    return (
        <div className="login-screen__container">
            <form onSubmit={handleSubmit} className="login-screen__form">
                <label>Usuario</label>
                <input className="form-input"
                    type="text"
                    placeholder="Email"
                    name="username"
                    onChange={handleChange}
                    value={usuario.username}
                />
                <label>Senha</label>
                <input className="form-input"
                    type="password"
                    placeholder="Senha"
                    name="password"
                    onChange={handleChange}
                    value={usuario.password}
                />
                <button className="botao-login"> Entrar </button>
                <button className="botao-login" onClick={(() => navigate("/cadastro"))}>Cadastar</button>
            </form>
        </div>
    )
}