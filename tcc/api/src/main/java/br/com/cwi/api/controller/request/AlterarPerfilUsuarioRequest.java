package br.com.cwi.api.controller.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlterarPerfilUsuarioRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String apelido;

    @NotBlank
    private String urlImagem;
}
