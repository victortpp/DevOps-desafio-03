package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.SolicitacaoAmizadeResponse;
import br.com.cwi.api.mapper.SolicitacaoAmizadeMapper;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitacaoAmizadeService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public List<SolicitacaoAmizadeResponse> listar() {

        Usuario usuarioAutentificado = usuarioAutenticadoService.get();

        return usuarioAutentificado.getSolicitacoesDeAmizades().stream()
                .map(SolicitacaoAmizadeMapper::toResponse)
                .collect(Collectors.toList());

    }
}
