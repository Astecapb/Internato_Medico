package br.com.internato.api.dto.response;

import br.com.internato.domain.Semestre;

import java.time.LocalDate;

public record SemestreResponse(
        Long id,
        String rotulo,
        LocalDate dataInicio,
        LocalDate dataFim
) {

    public static SemestreResponse from(Semestre semestre) {
        return new SemestreResponse(
                semestre.getId(),
                semestre.getRotulo(),
                semestre.getDataInicio(),
                semestre.getDataFim()
        );
    }
}