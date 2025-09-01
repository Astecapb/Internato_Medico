package br.com.internato.repository;

import br.com.internato.domain.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SemestreRepository extends JpaRepository<Semestre, Long> {
    Optional<Semestre> findByRotulo(String rotulo);
}