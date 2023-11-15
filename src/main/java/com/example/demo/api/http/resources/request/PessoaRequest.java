package com.example.demo.api.http.resources.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PessoaRequest {

    private String nome;

    @NotBlank(message = "NotEmpty")
    @Schema(description = "telefone")
    private String telefone;


    private String cpf;

}
