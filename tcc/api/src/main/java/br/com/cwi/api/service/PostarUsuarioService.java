package br.com.cwi.api.service;

import br.com.cwi.api.controller.request.PostarUsuarioRequest;
import br.com.cwi.api.controller.response.PostarUsuarioResponse;
import br.com.cwi.api.domain.Post;
import br.com.cwi.api.mapper.PostarUsuarioMapper;
import br.com.cwi.api.repository.PostRepository;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostarUsuarioService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public PostarUsuarioResponse postar(PostarUsuarioRequest request) {

        Usuario usuarioAutentificado = usuarioAutenticadoService.get();

        Post postagem = PostarUsuarioMapper.toEntity(request);

        postagem.postar(usuarioAutentificado);

        postRepository.save(postagem);

        return PostarUsuarioMapper.toResponse(postagem);
    }
}
