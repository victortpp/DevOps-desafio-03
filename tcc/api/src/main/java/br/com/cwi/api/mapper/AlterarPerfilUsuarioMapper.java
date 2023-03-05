package br.com.cwi.api.mapper;

import br.com.cwi.api.controller.response.AlterarPerfilUsuarioResponse;
import br.com.cwi.api.security.domain.Usuario;

public class AlterarPerfilUsuarioMapper {
    public static AlterarPerfilUsuarioResponse toResponse(Usuario usuarioAutentificado) {
        return AlterarPerfilUsuarioResponse.builder()
                .nome(usuarioAutentificado.getNome())
                .apelido(usuarioAutentificado.getApelido())
                .urlImagem(usuarioAutentificado.getUrlImagem())
                .build();
    }
}
