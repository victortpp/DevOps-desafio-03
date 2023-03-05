package br.com.cwi.api.security.controller;

import br.com.cwi.api.security.controller.response.ListarPerfilUsuarioResponse;
import br.com.cwi.api.security.controller.request.UsuarioRequest;
import br.com.cwi.api.security.controller.response.UsuarioResponse;
import br.com.cwi.api.security.service.BuscarUsuarioService;
import br.com.cwi.api.security.service.IncluirUsuarioService;
import br.com.cwi.api.service.ListarPerfilUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IncluirUsuarioService incluirUsuarioService;

    @Autowired
    private BuscarUsuarioService buscarUsuarioService;

    @Autowired
    private ListarPerfilUsuarioService listarPerfilUsuarioService;

    @PostMapping
    public UsuarioResponse incluir(@Valid @RequestBody UsuarioRequest request) {
        return incluirUsuarioService.incluir(request);
    }

    @GetMapping("/me")
    public UsuarioResponse buscar() {
        return buscarUsuarioService.buscar();
    }

    @GetMapping("/{id}")
    public ListarPerfilUsuarioResponse listar(@PathVariable Long id){
        return listarPerfilUsuarioService.listar(id);
    }

}
