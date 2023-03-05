package br.com.cwi.api.security.domain;

import br.com.cwi.api.domain.Post;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nome;
    private String apelido;
    private LocalDate dataNascimento;
    private String urlImagem;
    private String email;
    private String senha;
    private boolean ativo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Permissao> permissoes = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "solicitacao_amizade",
                joinColumns = @JoinColumn(name = "usuario_id"),
                inverseJoinColumns = @JoinColumn(name = "usuario_solicitou_id"))
    private List<Usuario> solicitacoesDeAmizades = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "amigo",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario_amigo"))
    private List<Usuario> amigos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Post> postagens = new ArrayList<>();

    public void adicionarPermissao(Permissao permissao) {
        this.permissoes.add(permissao);
        permissao.setUsuario(this);
    }
}
