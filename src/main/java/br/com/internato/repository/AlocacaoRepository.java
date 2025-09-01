package br.com.internato.repository;

import br.com.internato.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AlocacaoRepository extends JpaRepository<Alocacao, Long> {

    long countByPlantaoId(Long plantaoId);

    @Query("""
        SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END
        FROM Alocacao a
        WHERE a.aluno.id = :alunoId
          AND (a.plantao.dataHoraInicio < :fim AND a.plantao.dataHoraFim > :inicio)
    """)
    boolean existsByAlunoIdAndHorario(@Param("alunoId") Long alunoId,
                                      @Param("inicio") LocalDateTime inicio,
                                      @Param("fim") LocalDateTime fim);

    List<Alocacao> findByAlunoId(Long alunoId);
}