package com.example.rhayssa_justino_andretto_211631272_prova.dtos;

import com.example.rhayssa_justino_andretto_211631272_prova.entities.Trabalho;
import lombok.Data;

@Data
public class PessoaDTO {
    private Long id;
    private String cpf;
    private Integer idade;
    private Trabalho trabalho;
}