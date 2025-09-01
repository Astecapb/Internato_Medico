package br.com.internato.repository;

import br.com.internato.domain.Plantao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PlantaoRepository extends JpaRepository<Plantao, Long> {

    List<Plantao> findBySemestreId(Long semestreId);
}
