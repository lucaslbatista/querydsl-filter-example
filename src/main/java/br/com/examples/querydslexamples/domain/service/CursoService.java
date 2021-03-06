package br.com.examples.querydslexamples.domain.service;


import br.com.examples.querydslexamples.domain.filter.CursoFilter;
import br.com.examples.querydslexamples.domain.model.Curso;
import br.com.examples.querydslexamples.domain.repository.CursoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Page<Curso> findAll(MultiValueMap<String, String> parameters, Pageable pageable){
        return cursoRepository.findAll(CursoFilter.toPredicate(parameters), pageable);
    }

}
