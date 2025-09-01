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
@RequestMapping("/api/locais")
@RequiredArgsConstructor
public class LocalController {

    private final LocalService service;

    @PostMapping
    public ResponseEntity<Local> criar(@RequestBody LocalRequest req) {
        Local saved = service.salvar(req.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public List<Local> listar() {
        return service.listar();
    }
}