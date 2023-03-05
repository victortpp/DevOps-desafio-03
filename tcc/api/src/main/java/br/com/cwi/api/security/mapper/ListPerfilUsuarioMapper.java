package br.com.cwi.api.security.mapper;

import br.com.cwi.api.security.controller.response.ListarPerfilUsuarioResponse;
import br.com.cwi.api.security.domain.Usuario;

public class ListPerfilUsuarioMapper {
    public static ListarPerfilUsuarioResponse toResponse(Usuario usuario) {

        return ListarPerfilUsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .apelido(usuario.getApelido())
                .dataNascimento(usuario.getDataNascimento())
                .urlImagem(usuario.getUrlImagem())
                .build();
    }
}
