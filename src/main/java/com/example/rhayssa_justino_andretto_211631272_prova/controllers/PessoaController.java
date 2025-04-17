package com.example.rhayssa_justino_andretto_211631272_prova.controllers;

import com.example.rhayssa_justino_andretto_211631272_prova.dtos.PessoaDTO;
import com.example.rhayssa_justino_andretto_211631272_prova.entities.Pessoa;
import com.example.rhayssa_justino_andretto_211631272_prova.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<Pessoa>> find() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody PessoaDTO dto) {
        Pessoa pessoa = modelMapper.map(dto, Pessoa.class);
        Pessoa savedPessoa = service.create(pessoa);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPessoa.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody PessoaDTO dto) {
        Pessoa pessoa = modelMapper.map(dto, Pessoa.class);
        return ResponseEntity.ok(service.update(id, pessoa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
