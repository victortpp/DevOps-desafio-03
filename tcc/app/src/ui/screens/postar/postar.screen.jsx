import "./index.css"
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { usePostar } from "../../../api";

export function PostarScreen() {
    const [formulario, setFormulario] = useState({ urlPostagem: "" })
    const { getPostar } = usePostar()
    const navigate = useNavigate()

    function handleChange({ target }) {
        const { name, value } = target;

        setFormulario((oldUserInfo) => ({ ...oldUserInfo, [name]: value }));
    }


    async function handleSubmit(event) {
        event.preventDefault();
        try {
            await getPostar({
                urlPostagem: formulario.urlPostagem
            });
            navigate("/perfil")
        } catch (error) {
            console.log("erro")
        }
    }

    return (
        <div className="formulario-container">
                <form onSubmit={handleSubmit} className="formulario" >
                    <label>Postar Imagem</label>
                    <input className="form-input"
                        type="text"
                        placeholder="postar"
                        name="urlPostagem"
                        onChange={handleChange}
                    />
                    <button className="botao-login"> postar </button>
                </form>
        </div>
    )
}