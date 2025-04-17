package com.example.rhayssa_justino_andretto_211631272_prova.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    private Integer idade;

    @ManyToOne
    @JoinColumn(name = "trabalho_id")
//    @JsonIgnoreProperties("pessoas")
    private Trabalho trabalho;
}
