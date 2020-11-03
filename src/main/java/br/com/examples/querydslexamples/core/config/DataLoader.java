package br.com.examples.querydslexamples.core.config;

import br.com.examples.querydslexamples.domain.model.Curso;
import br.com.examples.querydslexamples.domain.model.Pessoa;
import br.com.examples.querydslexamples.domain.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class DataLoader implements ApplicationRunner {
    private CursoRepository repository;

    @Autowired
    public DataLoader(CursoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 50; i++) {
            Set<Pessoa> pessoas = new HashSet<>();
            criarPessoas(pessoas);

            Curso curso = Curso.builder()
                    .dtCriacao(LocalDate.now())
                    .dtInicio(LocalDate.now().plusDays(1 + i))
                    .dtFim(LocalDate.now().plusDays(1 + i).plusMonths(1))
                    .nome("CURSO " + (i + 1))
                    .sigla("CR"+(i+1))
                    .cargaHoraria(ThreadLocalRandom.current().nextInt(120, 360))
                    .pessoas(pessoas)
                    .build();

            Curso cursoResult = repository.save(curso);
        }

    }

    private void criarPessoas(Set<Pessoa> pessoas) {
        for (int i = 0; i < 5; i++) {
            Pessoa pessoa = Pessoa.builder()
                    .dtNascimento(LocalDate.of(1970 + (i*10), 6, 5+i))
                    .nome("pessoa " + (i + 1))
                    .build();

            pessoas.add(pessoa);
        }
    }
}
