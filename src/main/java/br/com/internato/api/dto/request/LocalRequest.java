package br.com.internato.api.dto.request;

import br.com.internato.domain.Local;
import jakarta.validation.constraints.*;
import br.com.internato.domain.*;

public record LocalRequest(String nome,
                           String sigla,
                           String endereco,
                           String cidade,
                           String cep,
                           Double latitude,
                           Double longitude) {

    public Local toEntity() {
        return Local.builder()
                .nome(nome)
                .sigla(sigla)
                .endereco(endereco)
                .cidade(cidade)
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }
}