package br.com.internato.service;

import br.com.internato.domain.Alocacao;
import br.com.internato.domain.Local;
import br.com.internato.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CheckinService {

    private final AlocacaoRepository alocacaoRepository;

    public void checkIn(Long alocacaoId, double lat, double lon) {
        Alocacao a = alocacaoRepository.findById(alocacaoId)
                .orElseThrow(() -> new IllegalArgumentException("Alocação não encontrada"));

        validarDistancia(lat, lon, a.getPlantao().getLocal());

        a.setCheckIn(LocalDateTime.now());
        a.setStatus(Alocacao.StatusAlocacao.CONFIRMADO);
        alocacaoRepository.save(a);
    }

    private void validarDistancia(double lat, double lon, org.springframework.cglib.core.Local local) {

    }

    public void checkOut(Long alocacaoId) {
        Alocacao a = alocacaoRepository.findById(alocacaoId)
                .orElseThrow(() -> new IllegalArgumentException("Alocação não encontrada"));

        a.setCheckOut(LocalDateTime.now());
        long minutos = Duration.between(a.getCheckIn(), a.getCheckOut()).toMinutes();
        a.setHorasReais((int) (minutos / 60));
        alocacaoRepository.save(a);
    }

    private void validarDistancia(double latAluno, double lonAluno, Local local) {
        double dist = haversine(latAluno, lonAluno,
                local.getLatitude(), local.getLongitude());
        if (dist > 100) {
            throw new IllegalStateException("Fora do raio permitido");
        }
    }

    private double haversine(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // raio da Terra em km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c * 1000; // retorna metros
    }
}