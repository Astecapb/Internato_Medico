package br.com.internato.api.dto.response;

import br.com.internato.domain.Alocacao;

import java.time.LocalDateTime;

public record AlocacaoResponse(
        Integer id,
        String alunoNome,
        String plantaoLocal,
        String plantaoEspecialidade,
        LocalDateTime checkIn,
        LocalDateTime checkOut,
        Integer horasReais,
        String status
) {

    public static AlocacaoResponse from(Alocacao a) {
        return new AlocacaoResponse(
                a.getId(),
                a.getAluno() != null ? a.getAluno().getNome() : null,
                a.getPlantao() != null && a.getPlantao().getLocal() != null ? a.getPlantao().getLocal().getNome() : null,
                a.getPlantao() != null && a.getPlantao().getEspecialidade() != null ? a.getPlantao().getEspecialidade().getNome() : null,
                a.getCheckIn(),
                a.getCheckOut(),
                a.getHorasReais(),
                a.getStatus() != null ? a.getStatus().name() : null
        );
    }
}