package br.com.cwi.api.controller.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SolicitacaoAmizadeResponse {

    private Long id;

    private String nome;

    private String apelido;

    private String urlImagem;
}
