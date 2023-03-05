package br.com.cwi.api.service;

import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AceitarUsuarioService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ValidarIdService validarIdService;

    public void aceitar(Long id) {

        validarIdService.validar(id);

        Usuario usuarioAutenticado = usuarioAutenticadoService.get();

        Usuario usuarioAceito = usuarioRepository.findById(id).get();

        usuarioAutenticado.getAmigos().add(usuarioAceito);
        usuarioAutenticado.getSolicitacoesDeAmizades().remove(usuarioAceito);

        usuarioRepository.save(usuarioAutenticado);

    }
}
