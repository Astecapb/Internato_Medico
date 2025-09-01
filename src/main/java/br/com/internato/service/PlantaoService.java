package br.com.internato.service;

import br.com.internato.api.dto.response.AlocacaoResponse;
import br.com.internato.repository.*;
import lombok.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.internato.domain.Plantao;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
@Getter
@Setter
@Builder

public class PlantaoService {

    private final PlantaoRepository plantaoRepository;
    private final SemestreRepository semestreRepository;
    private final LocalRepository localRepository;
    private final EspecialidadeRepository especialidadeRepository;
    private final UsuarioRepository usuarioRepository;

    public Plantao criar(Plantao plantao) {
        validarReferencias(plantao);
        return plantaoRepository.save(plantao);
    }

    public List<Plantao> listarPorSemestre(Long semestreId) {
        return plantaoRepository.findBySemestreId(semestreId);
    }

    private void validarReferencias(Plantao p) {
        semestreRepository.findById(p.getSemestre().getId())
                .orElseThrow(() -> new IllegalArgumentException("Semestre inválido"));

        localRepository.findById(p.getLocal().getId())  // ✅ correto
                .orElseThrow(() -> new IllegalArgumentException("Local inválido"));

        especialidadeRepository.findById(p.getEspecialidade().getId())
                .orElseThrow(() -> new IllegalArgumentException("Especialidade inválida"));

        if (p.getPreceptor() != null) {
            usuarioRepository.findById(p.getPreceptor().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Preceptor inválido"));
        }
    }

    public List<AlocacaoResponse> listarAlocacoes(Long id) {
        return List.of();
    }
}