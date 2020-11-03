package br.com.examples.querydslexamples.api.controller;

import br.com.examples.querydslexamples.domain.service.CursoService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping("cursos")
    public ResponseEntity<?> findAll(@RequestParam(name = "unpaged", required = false) boolean unpaged, @RequestParam(required = false) MultiValueMap<String, String> parameters, Pageable pageable){
        if(unpaged){
            pageable = Pageable.unpaged();
        }
        return ResponseEntity.ok(cursoService.findAll(parameters, pageable));
    }
}
