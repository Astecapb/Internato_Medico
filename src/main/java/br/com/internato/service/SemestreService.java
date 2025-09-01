package br.com.internato.service;

import br.com.internato.domain.*;
import br.com.internato.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SemestreService {

    private final SemestreRepository repository;

    public Semestre salvar(Semestre semestre) {
        return repository.save(semestre);
    }

    public List<Semestre> listar() {
        return repository.findAll();
    }
}