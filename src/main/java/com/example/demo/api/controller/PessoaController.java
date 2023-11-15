package com.example.demo.api.controller;

import com.example.demo.api.http.resources.request.PessoaRequest;
import com.example.demo.api.http.resources.response.PessoaResponse;
import com.example.demo.core.mapper.PessoaMapper;
import com.example.demo.domain.model.Pessoa;
import com.example.demo.domain.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    private final PessoaService pessoaService;
    private final PessoaMapper pessoaMapper;

    public PessoaController(PessoaService pessoaService, PessoaMapper pessoaMapper) {
        this.pessoaService = pessoaService;
        this.pessoaMapper = pessoaMapper;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<PessoaResponse>> findAll(){
        List<Pessoa> pessoas = pessoaService.findAll();
        List<PessoaResponse> pessoaResponses = pessoas.stream()
                .map(pessoaMapper::mapEntityToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(pessoaResponses);
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<PessoaResponse> findPessoaById(@PathVariable(name = "idUsuario") Long idUsuario){
        Pessoa pessoa = pessoaService.findById(idUsuario);
        PessoaResponse pessoaResponse = pessoaMapper.mapEntityToResponse(pessoa);
        return ResponseEntity.ok(pessoaResponse);
    }

    @PostMapping
    public ResponseEntity<PessoaResponse> createPessoa(@RequestBody @Valid PessoaRequest pessoaRequest, UriComponentsBuilder uriComponentsBuilder){
        Pessoa pessoa = pessoaMapper.mapRequestToEntity(pessoaRequest);
        Pessoa pessoaSalva = pessoaService.create(pessoa);
        URI uri = uriComponentsBuilder.path("/pessoa/{id}")
                .buildAndExpand(pessoaSalva.getId())
                .toUri();
        PessoaResponse pessoaResponse = pessoaMapper.mapEntityToResponse(pessoaSalva);
        return ResponseEntity.created(uri).body(pessoaResponse);
    }
}
