package br.com.cwi.minhaRedeSocial.service;

import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.AceitarUsuarioService;
import br.com.cwi.api.service.ValidarIdService;
import br.com.cwi.minhaRedeSocial.factories.UsuarioFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AceitarUsuarioServiceTest {

    @InjectMocks
    private AceitarUsuarioService tested ;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private ValidarIdService validarIdService;

    @Test
    @DisplayName("Deve aceitar pedido de amizade")
    public void deveAceitarPedidoAmizade() {
        Usuario usuario = UsuarioFactory.get();
        Usuario usuarioAceito = UsuarioFactory.get();
        Long id = usuarioAceito.getId();


        when(usuarioAutenticadoService.get()).thenReturn(usuario);
        when(usuarioRepository.findById(id)).thenReturn(Optional.of(usuarioAceito));

        tested.aceitar(id);

        verify(validarIdService).validar(id);
        verify(usuarioAutenticadoService).get();
        verify(usuarioRepository).findById(id);
        verify(usuarioRepository).save(usuario);

        Assertions.assertEquals(usuario.getAmigos().get(0).getNome(), usuarioAceito.getNome());
        Assertions.assertTrue(usuario.getSolicitacoesDeAmizades().isEmpty());
    }
}
