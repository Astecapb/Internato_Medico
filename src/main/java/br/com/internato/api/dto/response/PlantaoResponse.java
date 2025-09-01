package br.com.internato.api.dto.response;

import br.com.internato.domain.Plantao;
import java.time.LocalDateTime;
import java.lang.String;



public record PlantaoResponse(Long id,
                              String localNome,
                              String especialidadeNome,
                              LocalDateTime inicio,
                              LocalDateTime fim,
                              Integer vagas) {

    public static PlantaoResponse from(Plantao p) {
        return new PlantaoResponse(
                p.getId(),
                p.getLocal().getType(),
                p.getEspecialidade().getNome(),
                p.getDataHoraInicio(),
                p.getDataHoraFim(),
                p.getVagas()
        );
    }
}