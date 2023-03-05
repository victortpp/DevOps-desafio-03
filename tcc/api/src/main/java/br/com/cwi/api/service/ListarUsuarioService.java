package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.ListarUsuarioResponse;
import br.com.cwi.api.mapper.ListarUsuarioMapper;
import br.com.cwi.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<ListarUsuarioResponse> listarUsuarioPaginado(String text, Pageable pageable) {
        return usuarioRepository.findByNomeContainingIgnoreCaseOrEmailContainingIgnoreCase(text, text, pageable)
                .map(ListarUsuarioMapper::toResponse);
    }
}
