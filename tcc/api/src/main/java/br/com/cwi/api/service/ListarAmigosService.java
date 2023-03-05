package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.SolicitacaoAmizadeResponse;
import br.com.cwi.api.mapper.SolicitacaoAmizadeMapper;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarAmigosService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public List<SolicitacaoAmizadeResponse> listarAmigos() {

        Usuario usuarioAutenticado = usuarioAutenticadoService.get();

        return usuarioAutenticado.getAmigos().stream()
                .map(SolicitacaoAmizadeMapper::toResponse)
                .collect(Collectors.toList());
    }
}
