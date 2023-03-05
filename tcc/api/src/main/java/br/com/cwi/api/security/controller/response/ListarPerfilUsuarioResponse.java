package br.com.cwi.api.security.controller.response;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ListarPerfilUsuarioResponse {

    private Long id;
    private String nome;
    private String apelido;
    private LocalDate dataNascimento;
    private String urlImagem;
}
