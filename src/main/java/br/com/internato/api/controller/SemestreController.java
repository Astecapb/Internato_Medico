package br.com.internato.api.controller;

import br.com.internato.api.dto.request.*;
import br.com.internato.api.dto.response.*;
import br.com.internato.domain.*;
import br.com.internato.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/semestres")
@RequiredArgsConstructor
public class SemestreController {

    private final SemestreService service;

    @PostMapping
    public ResponseEntity<Semestre> criar(@RequestBody SemestreRequest req) {
        Semestre saved = service.salvar(req.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public List<Semestre> listar() {
        return service.listar();
    }
}