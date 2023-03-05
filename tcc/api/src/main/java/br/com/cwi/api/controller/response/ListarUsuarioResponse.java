package br.com.cwi.api.controller.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ListarUsuarioResponse {

    private String nome;
    private String email;
}
