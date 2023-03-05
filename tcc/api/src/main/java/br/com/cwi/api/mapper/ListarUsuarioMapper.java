package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.ListarUsuarioResponse;
import br.com.cwi.api.security.domain.Usuario;

public class ListarUsuarioMapper {
    public static ListarUsuarioResponse toResponse(Usuario entity) {
        return ListarUsuarioResponse.builder()
                .nome(entity.getNome())
                .email(entity.getEmail())
                .build();
    }
}
