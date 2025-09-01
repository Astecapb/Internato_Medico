package br.com.internato.repository;

import br.com.internato.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalRepository extends JpaRepository<Local, Long> {
}