package br.com.internato.api.dto.request;

import br.com.internato.domain.Especialidade;
import br.com.internato.domain.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;


public record CriarPlantaoRequest(
        @NotNull Long semestreId,
        @NotNull Long localId,
        @NotNull Long especialidadeId,
        @Future LocalDateTime dataHoraInicio,
        @Future LocalDateTime dataHoraFim,
        Long preceptorId,
        @Min(1) Integer vagas
) {
    public Plantao toEntity() {
        return Plantao.builder()
                .semestre(Semestre.builder().id(semestreId).build())
                .local(Local.builder().id(localId).build())
                .especialidade(Especialidade.builder().id(especialidadeId).build())
                .dataHoraInicio(dataHoraInicio)
                .dataHoraFim(dataHoraFim)
                .preceptor(preceptorId != null ? Usuario.builder().id(preceptorId).build() : null)
                .vagas(vagas)
                .build();
    }
}
