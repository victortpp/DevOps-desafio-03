package br.com.cwi.api.controller.response;

import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ListarPostagensResponse {

    private Long id;
    private LocalDate datPostagem;
    private String urlImagem;
}
