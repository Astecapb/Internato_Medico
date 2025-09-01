package br.com.internato.service;

import br.com.internato.domain.*;
import br.com.internato.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocalService {

    private final LocalRepository repository;

    public Local salvar(Local local) {
        return repository.save(local);
    }

    public List<Local> listar() {
        return repository.findAll();
    }
}