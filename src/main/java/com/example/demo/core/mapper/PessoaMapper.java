package com.example.demo.core.mapper;

import com.example.demo.api.http.resources.request.PessoaRequest;
import com.example.demo.api.http.resources.response.PessoaResponse;
import com.example.demo.domain.model.Pessoa;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PessoaMapper {
    @Mapping(target = "id", ignore = true)
    Pessoa mapRequestToEntity(PessoaRequest pessoaRequest);

    PessoaResponse mapEntityToResponse(Pessoa pessoa);
}
