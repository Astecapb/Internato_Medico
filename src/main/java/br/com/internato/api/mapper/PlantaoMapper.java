package br.com.internato.api.mapper;

import br.com.internato.api.dto.response.PlantaoResponse;
import br.com.internato.domain.Plantao;
import lombok.Getter;
import org.springframework.stereotype.Component;



public final class PlantaoMapper {

    private PlantaoMapper() {
        // Impede instância
    }

    public static PlantaoResponse toResponse(Plantao plantao) {
        return new PlantaoResponse(
                plantao.getId(),
                plantao.getLocal().getNome(),
                plantao.getEspecialidade().getNome(),
                plantao.getDataHoraInicio(),
                plantao.getDataHoraFim(),
                plantao.getVagas()
        );
    }
}