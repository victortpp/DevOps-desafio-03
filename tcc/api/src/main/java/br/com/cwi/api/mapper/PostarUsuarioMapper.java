package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.request.PostarUsuarioRequest;
import br.com.cwi.api.controller.response.PostarUsuarioResponse;
import br.com.cwi.api.domain.Post;

public class PostarUsuarioMapper {
    public static Post toEntity(PostarUsuarioRequest request) {
        return Post.builder()
                .urlPostagem(request.getUrlPostagem())
                .build();
    }

    public static PostarUsuarioResponse toResponse(Post postagem) {
        return PostarUsuarioResponse.builder()
                .id(postagem.getId())
                .build();
    }
}
