package br.com.internato.service;

import br.com.internato.domain.*;
import br.com.internato.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AlocacaoService {

    private final AlocacaoRepository alocacaoRepository;
    private final PlantaoRepository plantaoRepository;
    private final UsuarioRepository usuarioRepository;
    private Integer vagas;


    public Alocacao alocar(Long plantaoId, Long alunoId) {
        var plantao = plantaoRepository.findById(plantaoId)
                .orElseThrow(() -> new IllegalArgumentException("Plantão não encontrado"));
        var aluno = usuarioRepository.findById(alunoId)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        if (alocacaoRepository.countByPlantaoId(plantaoId) >= plantao.getVagas()) {
            throw new IllegalStateException("Vagas esgotadas");
        }

        if (alocacaoRepository.existsByAlunoIdAndHorario(alunoId,
                plantao.getDataHoraInicio(), plantao.getDataHoraFim())) {
            throw new IllegalStateException("Conflito de horário");
        }

        var alocacao = Alocacao.builder()
                .plantao(plantao)
                .aluno(aluno)
                .status(Alocacao.StatusAlocacao.PENDENTE)
                .build();
        return alocacaoRepository.save(alocacao);
    }

    public void checkIn(Long id, double lat, double lon) {
    }

    public void checkOut(Long id) {
    }
    public Integer getVagas() {
        return vagas;
    }
    
    
}