package br.com.internato.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "alocacoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Alocacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "plantao_id")
    private Plantao plantao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "aluno_id")
    private Usuario aluno;

    private LocalDateTime checkIn;
    private LocalDateTime checkOut;

    private Integer horasReais; // horas efetivamente cumpridas

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private StatusAlocacao status = StatusAlocacao.PENDENTE;

    public enum StatusAlocacao {
        PENDENTE, CONFIRMADO, FALTA, REPOSICAO
    }
}