package com.example.demo.domain.service;

import com.example.demo.domain.model.Pessoa;
import com.example.demo.domain.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
    }
    public void delete(Long id) {
        Pessoa pessoa = findById(id);
        pessoaRepository.delete(pessoa);
    }

    public Pessoa create(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa update(Long id, Pessoa pessoa){
        Pessoa pessoaUpdate = findById(id);
        BeanUtils.copyProperties(pessoa, pessoaUpdate, "id", "cpf");
        return pessoaRepository.save(pessoaUpdate);
    }
}

