package br.com.cwi.api.service;

import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesfazerAmizadeService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private ValidarIdService validarIdService;

    public void desfazer(Long id) {

        validarIdService.validar(id);

        Usuario usuario = usuarioAutenticadoService.get();

        Usuario usuarioRemovido = usuarioRepository.findById(id).get();

        usuario.getAmigos().remove(usuarioRemovido);

        usuarioRepository.save(usuario);
    }
}
