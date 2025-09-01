package br.com.internato.api.controller;

import br.com.internato.api.dto.request.*;
import br.com.internato.api.dto.response.*;
import br.com.internato.api.mapper.PlantaoMapper;
import br.com.internato.service.*;
import br.com.internato.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/br/com/internato/sistema/api/plantoes")
@RequiredArgsConstructor
public class PlantaoController {

    private final PlantaoService service;

    @PostMapping
    public ResponseEntity<PlantaoResponse> criar(@RequestBody @Valid CriarPlantaoRequest req) {
        Plantao p = service.criar(req.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(PlantaoMapper.toResponse(p));
    }

    @GetMapping("/{id}/alocacoes")
    public List<AlocacaoResponse> listarAlocacoes(@PathVariable Long id) {
        return service.listarAlocacoes(id);
    }
}