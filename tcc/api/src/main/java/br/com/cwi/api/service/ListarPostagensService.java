package br.com.cwi.api.service;

import br.com.cwi.api.controller.response.ListarPostagensResponse;
import br.com.cwi.api.mapper.ListarPostagensMapper;
import br.com.cwi.api.repository.PostRepository;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarPostagensService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private PostRepository postRepository;

    public List<ListarPostagensResponse> listar() {

        Usuario usuarioAutenticado = usuarioAutenticadoService.get();

        List<Usuario> listaAmigos = usuarioAutenticado.getAmigos();

        return postRepository.findByPost(usuarioAutenticado.getId(), listaAmigos ).stream()
                .map(ListarPostagensMapper::toResponse)
                .collect(Collectors.toList());
    }
}
