package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.AlterarPerfilUsuarioRequest;
import br.com.cwi.api.controller.response.AlterarPerfilUsuarioResponse;
import br.com.cwi.api.mapper.AlterarPerfilUsuarioMapper;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlterarPerfilUsuarioService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public AlterarPerfilUsuarioResponse alterar(AlterarPerfilUsuarioRequest request) {

        Usuario usuarioAutentificado = usuarioAutenticadoService.get();

        usuarioAutentificado.setNome(request.getNome());
        usuarioAutentificado.setApelido(request.getApelido());
        usuarioAutentificado.setUrlImagem(request.getUrlImagem());

        usuarioRepository.save(usuarioAutentificado);

        return AlterarPerfilUsuarioMapper.toResponse(usuarioAutentificado);
    }
}
