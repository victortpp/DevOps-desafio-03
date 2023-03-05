package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.SolicitacaoAmizadeResponse;
import br.com.cwi.api.security.domain.Usuario;

public class SolicitacaoAmizadeMapper {
    public static SolicitacaoAmizadeResponse toResponse(Usuario usuario) {
        return SolicitacaoAmizadeResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .apelido(usuario.getApelido())
                .urlImagem(usuario.getUrlImagem())
                .build();
    }
}
