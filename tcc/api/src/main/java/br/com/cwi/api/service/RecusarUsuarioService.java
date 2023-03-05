package br.com.cwi.api.service;

import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecusarUsuarioService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ValidarIdService validarIdService;

    public void recusar(Long id) {
        validarIdService.validar(id);

        Usuario usuarioAutenticado = usuarioAutenticadoService.get();

        Usuario usuarioRecusado = usuarioRepository.findById(id).get();

        usuarioAutenticado.getSolicitacoesDeAmizades().remove(usuarioRecusado);

        usuarioRepository.save(usuarioAutenticado);
    }
}
