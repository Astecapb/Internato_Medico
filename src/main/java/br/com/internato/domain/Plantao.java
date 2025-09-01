package br.com.internato.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@SuppressWarnings("JpaAttributeTypeInspection")
@Entity
@Table(name = "plantoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Plantao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "semestre_id")
    private Semestre semestre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "local_id")
    private Local local;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "especialidade_id")
    private Especialidade especialidade;

    @Column(name = "data_hora_inicio")
    private LocalDateTime dataHoraInicio;

    @Column(name = "data_hora_fim")
    private LocalDateTime dataHoraFim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "preceptor_id")
    private Usuario preceptor;

    @Column(nullable = false)
    private Integer vagas;



    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }




    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }
}

