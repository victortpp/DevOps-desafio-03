package br.com.cwi.api.controller.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostarUsuarioRequest {

    @NotBlank
    private String urlPostagem;
}
