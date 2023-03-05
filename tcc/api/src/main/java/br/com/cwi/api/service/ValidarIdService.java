package br.com.cwi.api.service;

import br.com.cwi.api.security.domain.Usuario;
import br.com.cwi.api.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ValidarIdService {

    public static final String ERRO_USUARIO_INEXISTENTE = "Não existe esse usuario";
    public static final String ERRO_MESMO_USUARIO = "Não é possível adicionar a si mesmo";
    public static final String ERRO_JA_ESTA_NOS_AMIGOS = "Usuario já é seu amigo";

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validar(Long id) {
        if(!usuarioRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ERRO_USUARIO_INEXISTENTE);
        }
    }

    public void validarMesmoId(Long id, Long idUsuarioLogado) {
        if(idUsuarioLogado == id){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ERRO_MESMO_USUARIO);
        }
    }

    public void validarAmizade(Long id, List<Usuario> amigos) {
        Usuario usuario = usuarioRepository.findById(id).get();
        if(amigos.contains(usuario)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ERRO_JA_ESTA_NOS_AMIGOS);
        }
    }
}
