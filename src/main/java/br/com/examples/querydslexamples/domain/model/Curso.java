package br.com.examples.querydslexamples.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Set;

@Entity
@Data
@Builder
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @Column
    private String sigla;

    @Column
    private Integer cargaHoraria;

    @Column
    private LocalDate dtCriacao;

    @Column
    private LocalDate dtInicio;

    @Column
    private LocalDate dtFim;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "curso_id")
    private Set<Pessoa> pessoas;
}
