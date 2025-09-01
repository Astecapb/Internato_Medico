package br.com.internato.api.controller;


import br.com.internato.api.dto.request.*;
import br.com.internato.domain.*;
import br.com.internato.service.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/alocacoes")

public class AlocacaoController {

    private final AlocacaoService service;
    public AlocacaoController(AlocacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Alocacao> alocar(@RequestBody AlocacaoRequest req) {
        Alocacao aloc = service.alocar(req.plantaoId(), req.alunoId());
        return ResponseEntity.status(HttpStatus.CREATED).body(aloc);
    }

    @PostMapping("/{id}/checkin")
    public ResponseEntity<Void> checkIn(@PathVariable Long id,
                                        @RequestParam double lat,
                                        @RequestParam double lon) {
        service.checkIn(id, lat, lon);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/checkout")
    public ResponseEntity<Void> checkOut(@PathVariable Long id) {
        service.checkOut(id);
        return ResponseEntity.ok().build();
    }
}