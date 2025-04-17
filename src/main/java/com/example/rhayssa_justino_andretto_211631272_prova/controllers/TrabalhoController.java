package com.example.rhayssa_justino_andretto_211631272_prova.controllers;

import com.example.rhayssa_justino_andretto_211631272_prova.dtos.TrabalhoDTO;
import com.example.rhayssa_justino_andretto_211631272_prova.entities.Trabalho;
import com.example.rhayssa_justino_andretto_211631272_prova.services.TrabalhoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/trabalho")
@RequiredArgsConstructor
public class TrabalhoController {

    private final TrabalhoService service;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TrabalhoDTO dto) {
        Trabalho trabalho = modelMapper.map(dto, Trabalho.class);
        Trabalho savedTrabalho = service.create(trabalho);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedTrabalho.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabalho> findById(@PathVariable Long id) {
        Trabalho trabalho = service.findById(id);
        return ResponseEntity.ok(trabalho);
    }

    @GetMapping
    public ResponseEntity<List<Trabalho>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trabalho> update(@PathVariable Long id, @RequestBody TrabalhoDTO dto) {
        Trabalho trabalho = modelMapper.map(dto, Trabalho.class);
        Trabalho updated = service.update(trabalho);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

