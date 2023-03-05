import { createBrowserRouter } from "react-router-dom";
import { LoginScreen, CadastroScreen, PerfilScreen, AmigosScreen, PostarScreen} from "../ui/screens";

export const router = createBrowserRouter([
    {
        path: "/",
        element: <LoginScreen />
    },
    {
        path: "/cadastro",
        element: <CadastroScreen />
    },
    {
        path: "/perfil",
        element: <PerfilScreen />
    },
    {
        path: "/amigos",
        element: <AmigosScreen />
    },
    {
        path: "/postar",
        element: <PostarScreen />
    }
])