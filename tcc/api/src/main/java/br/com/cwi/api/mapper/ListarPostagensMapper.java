package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.ListarPostagensResponse;
import br.com.cwi.api.domain.Post;

public class ListarPostagensMapper {
    public static ListarPostagensResponse toResponse(Post entity) {
        return ListarPostagensResponse.builder()
                .id(entity.getId())
                .urlImagem(entity.getUrlPostagem())
                .datPostagem(entity.getDataPostagem())
                .build();
    }
}
