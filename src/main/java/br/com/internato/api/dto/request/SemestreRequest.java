package br.com.internato.api.dto.request;

import br.com.internato.domain.Semestre;
import jakarta.validation.constraints.*;
import br.com.internato.domain.*;
import lombok.Builder;

import java.time.LocalDate;
@Builder

public record SemestreRequest(@NotBlank String rotulo,
                              @NotNull LocalDate dataInicio,
                              @NotNull LocalDate dataFim) {

    public Semestre toEntity() {
        return Semestre.builder()
                .rotulo(rotulo)
                .dataInicio(dataInicio)
                .dataFim(dataFim)
                .build();
    }
}