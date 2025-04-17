package com.example.rhayssa_justino_andretto_211631272_prova.services;

import com.example.rhayssa_justino_andretto_211631272_prova.entities.Pessoa;
import com.example.rhayssa_justino_andretto_211631272_prova.entities.Trabalho;
import com.example.rhayssa_justino_andretto_211631272_prova.repositories.PessoaRepository;
import com.example.rhayssa_justino_andretto_211631272_prova.repositories.TrabalhoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository repository;
    private final TrabalhoRepository trabalhoRepository;

    public Pessoa create(Pessoa pessoa, Long trabalhoId){
        Trabalho trabalho = trabalhoRepository.findById(trabalhoId)
                .orElseThrow(() -> new RuntimeException("Trabalho não encontrado"));

        pessoa.setTrabalho(trabalho);
        return repository.save(pessoa);
    }

    public Pessoa update(Long id, Pessoa pessoa){
        Pessoa existingPessoa = this.findById(pessoa.getId());

        existingPessoa.setIdade(pessoa.getIdade());
        existingPessoa.setCpf(pessoa.getCpf());

        return repository.save(existingPessoa);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Pessoa findById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
    }

    public List<Pessoa> findAll(){
        return repository.findAll();
    }

}
