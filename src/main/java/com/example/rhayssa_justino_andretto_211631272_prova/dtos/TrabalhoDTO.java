package com.example.rhayssa_justino_andretto_211631272_prova.dtos;

import com.example.rhayssa_justino_andretto_211631272_prova.entities.Pessoa;
import lombok.Data;

import java.util.List;

@Data
public class TrabalhoDTO {
    private Long id;
    private String nome;
    private String endereco;
    private List<Pessoa> pessoas;
}
