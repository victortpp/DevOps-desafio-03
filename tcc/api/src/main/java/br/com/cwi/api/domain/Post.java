package br.com.cwi.api.domain;

import br.com.cwi.api.security.domain.Usuario;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Post {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private LocalDate dataPostagem;
    private String urlPostagem;

    public void postar(Usuario usuario) {
        this.setUsuario(usuario);
        this.setDataPostagem(LocalDate.now());
    }
}
