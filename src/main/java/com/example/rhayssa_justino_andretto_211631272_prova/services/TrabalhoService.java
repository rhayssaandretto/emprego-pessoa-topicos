package com.example.rhayssa_justino_andretto_211631272_prova.services;

import com.example.rhayssa_justino_andretto_211631272_prova.entities.Trabalho;
import com.example.rhayssa_justino_andretto_211631272_prova.repositories.TrabalhoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrabalhoService {

    private final TrabalhoRepository repository;

    public Trabalho create(Trabalho trabalho) {
        return repository.save(trabalho);
    }

    public Trabalho update(Trabalho trabalho) {
        Trabalho existingTrabalho = this.findById(trabalho.getId());

        existingTrabalho.setNome(trabalho.getNome());
        existingTrabalho.setEndereco(trabalho.getEndereco());

        return repository.save(trabalho);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Trabalho findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Trabalho não encontrado"));
    }

    public List<Trabalho> findAll() {
        return repository.findAll();
    }


}
