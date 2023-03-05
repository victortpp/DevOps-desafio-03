import "./index.css"

export function PostagensLista({ listaPosts }) {
    return (
        <>
            {listaPosts?.map(post => (
                <div key={post.id} className="postagem">
                    <img className="imagem-post" src={post.urlImagem} alt = "imagem post"/>
                    <button className="botao-postagem"> curtir </button>
                    <button className="botao-postagem"> comentar </button>
                </div>
            ))}
        </>
    )
}