package br.com.cwi.minhaRedeSocial.service;

import br.com.cwi.api.controller.request.PostarUsuarioRequest;
import br.com.cwi.api.domain.Post;
import br.com.cwi.api.repository.PostRepository;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.PostarUsuarioService;
import br.com.cwi.minhaRedeSocial.factories.UsuarioFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostarUsuarioServiceTest {

    @InjectMocks
    private PostarUsuarioService tested;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Mock
    private PostRepository postRepository;

    @Captor
    private ArgumentCaptor<Post> PostCaptor;

    @Test
    @DisplayName("Deve postar")
    public void devePostar() {
        Usuario usuario = UsuarioFactory.get();
        Usuario usuarioAceito = UsuarioFactory.get();
        PostarUsuarioRequest request = new PostarUsuarioRequest();
        request.setUrlPostagem("post");

        when(usuarioAutenticadoService.get()).thenReturn(usuario);

        tested.postar(request);

        verify(usuarioAutenticadoService).get();
        verify(postRepository).save(PostCaptor.capture());

        Post post = PostCaptor.getValue();
        Assertions.assertEquals(post.getUrlPostagem(), request.getUrlPostagem());
    }
}
