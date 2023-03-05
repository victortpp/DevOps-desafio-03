package br.com.cwi.api.service;

import br.com.cwi.api.security.controller.response.ListarPerfilUsuarioResponse;
import br.com.cwi.api.security.mapper.ListPerfilUsuarioMapper;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListarPerfilUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public ListarPerfilUsuarioResponse listar(Long id) {

        Usuario usuario = usuarioRepository.findById(id).get();

        return ListPerfilUsuarioMapper.toResponse(usuario);
    }
}
