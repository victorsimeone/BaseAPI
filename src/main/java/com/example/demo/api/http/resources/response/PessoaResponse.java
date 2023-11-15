package com.example.demo.api.http.resources.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PessoaResponse {

    private Long id;


    private String nome;


    private String telefone;


    private String cpf;

}
