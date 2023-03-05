package br.com.cwi.api.controller;


import br.com.cwi.api.controller.request.AlterarPerfilUsuarioRequest;
import br.com.cwi.api.controller.request.PostarUsuarioRequest;
import br.com.cwi.api.controller.response.*;
import br.com.cwi.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/perfis")
public class PerfilUsuarioController {

    @Autowired
    private AlterarPerfilUsuarioService alterarPerfilUsuarioService;

    @Autowired
    private SolicitacaoAmizadeService solicitacaoAmizadeService;

    @Autowired
    private PostarUsuarioService postarUsuarioService;

    @Autowired
    private AceitarUsuarioService aceitarUsuarioService;

    @Autowired
    private RecusarUsuarioService recusarUsuarioService;

    @Autowired
    private ListarPostagensService listarPostagensService;

    @Autowired
    private SolicitarPedidoAmizadeService solicitarPedidoAmizadeService;

    @Autowired
    private ListarAmigosService listarAmigosService;

    @Autowired
    private DesfazerAmizadeService desfazerAmizadeService;

    @Autowired
    private ListarUsuarioService listarUsuarioService;

    @PutMapping("/me")
    public AlterarPerfilUsuarioResponse alterar(@Valid @RequestBody AlterarPerfilUsuarioRequest request) {
        return alterarPerfilUsuarioService.alterar(request);
    }

    @GetMapping("/me/solicitacoes")
    public List<SolicitacaoAmizadeResponse> listar() {
        return solicitacaoAmizadeService.listar();
    }

    @PostMapping("/postar")
    public PostarUsuarioResponse postar(@Valid @RequestBody PostarUsuarioRequest request) {
        return postarUsuarioService.postar(request);
    }

    @PutMapping("/aceitar/{id}")
    public void aceitar(@PathVariable Long id) {
        aceitarUsuarioService.aceitar(id);
    }

    @PutMapping("/recusar/{id}")
    public void recusar(@PathVariable Long id) {
        recusarUsuarioService.recusar(id);
    }

    @PutMapping("/solicitar/{id}")
    public void solicitar(@PathVariable Long id) {
        solicitarPedidoAmizadeService.solicitar(id);
    }

    @GetMapping("/postagens")
    public List<ListarPostagensResponse> listarPaginado() {
        return listarPostagensService.listar();
    }

    @GetMapping("/amigos")
    public List<SolicitacaoAmizadeResponse> listarAmigos() {
        return listarAmigosService.listarAmigos();
    }

    @PutMapping("/desfazer-amizade/{id}")
    public void desfazer(@PathVariable Long id) {
        desfazerAmizadeService.desfazer(id);
    }

    @GetMapping("/buscar")
    public Page<ListarUsuarioResponse> listarUsuarios(@RequestParam String text, Pageable pageable) {
        return listarUsuarioService.listarUsuarioPaginado(text, pageable);
    }

}