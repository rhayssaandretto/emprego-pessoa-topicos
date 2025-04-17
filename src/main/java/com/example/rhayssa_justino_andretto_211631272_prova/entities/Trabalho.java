    package com.example.rhayssa_justino_andretto_211631272_prova.entities;

    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import jakarta.persistence.*;
    import lombok.*;

    import java.util.ArrayList;
    import java.util.List;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Entity
    public class Trabalho {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;

        private String endereco;

        @OneToMany(mappedBy = "trabalho", cascade = CascadeType.ALL)
        @JsonIgnoreProperties("trabalho")
        private List<Pessoa> pessoas = new ArrayList<>();

    }
