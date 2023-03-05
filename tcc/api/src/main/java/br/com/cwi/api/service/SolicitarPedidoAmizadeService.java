package br.com.cwi.api.service;

import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitarPedidoAmizadeService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private ValidarIdService validarIdService;

    public void solicitar(Long id) {

        validarIdService.validar(id);

        Usuario usuarioAutenticado = usuarioAutenticadoService.get();

        validarIdService.validarMesmoId(id, usuarioAutenticado.getId());
        validarIdService.validarAmizade(id, usuarioAutenticado.getAmigos());

        Usuario usuarioSolicitacao = usuarioRepository.findById(id).get();

        usuarioAutenticado.getSolicitacoesDeAmizades().add(usuarioSolicitacao);

        usuarioRepository.save(usuarioAutenticado);
    }
}
