package br.com.cwi.minhaRedeSocial.service;

import br.com.cwi.api.controller.request.AlterarPerfilUsuarioRequest;
import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.AlterarPerfilUsuarioService;
import br.com.cwi.minhaRedeSocial.factories.UsuarioFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AlterarPerfilUsuarioServiceTest {

    @InjectMocks
    private AlterarPerfilUsuarioService tested;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    @DisplayName("Deve alterar os dados do usuario")
    public void deveAlterarDadosUsuario() {

        Usuario usuario = UsuarioFactory.get();
        AlterarPerfilUsuarioRequest request = new AlterarPerfilUsuarioRequest();
        request.setNome("teste");
        request.setApelido("teste");
        request.setUrlImagem("teste");

        when(usuarioAutenticadoService.get()).thenReturn(usuario);

        tested.alterar(request);

        verify(usuarioAutenticadoService).get();
        verify(usuarioRepository).save(usuario);
        Assertions.assertEquals("teste", usuario.getNome());
    }
}
