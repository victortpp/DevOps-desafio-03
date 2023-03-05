package br.com.cwi.minhaRedeSocial.service;

import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import br.com.cwi.api.security.service.UsuarioAutenticadoService;
import br.com.cwi.api.service.DesfazerAmizadeService;
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
public class DesfazerAmizadeServiceTest {

    @InjectMocks
    private DesfazerAmizadeService tested;


    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private ValidarIdService validarIdService;

    @Test
    @DisplayName("Deve desfazer amizade ")
    public void deveDesfazerAmizade() {
        Usuario usuario = UsuarioFactory.get();
        Usuario usuarioRemovido = UsuarioFactory.get();
        Long id = usuarioRemovido.getId();

        when(usuarioAutenticadoService.get()).thenReturn(usuario);
        when(usuarioRepository.findById(id)).thenReturn(Optional.of(usuarioRemovido));

        tested.desfazer(id);

        verify(validarIdService).validar(id);
        verify(usuarioAutenticadoService).get();
        verify(usuarioRepository).findById(id);
        verify(usuarioRepository).save(usuario);

        Assertions.assertTrue(usuario.getAmigos().isEmpty());
    }

}
