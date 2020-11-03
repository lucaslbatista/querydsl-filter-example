package br.com.examples.querydslexamples.api.controller;

import br.com.examples.querydslexamples.domain.model.Curso;
import br.com.examples.querydslexamples.domain.service.CursoService;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("cursos")
    public ResponseEntity<?> findAll(@RequestParam(required = false) MultiValueMap<String, String> parameters, Pageable pageable){
        return ResponseEntity.ok(cursoService.findAll(parameters, pageable));
    }
}
