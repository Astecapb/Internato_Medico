package br.com.internato.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "local_especialidade")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class LocalEspecialidade {

    @EmbeddedId
    private LocalEspecialidadeId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("localId")
    @JoinColumn(name = "local_id")
    private Local local;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("especialidadeId")
    @JoinColumn(name = "especialidade_id")
    private Especialidade especialidade;

    private Integer vagasPorTurno;

    @Embeddable
    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LocalEspecialidadeId implements java.io.Serializable {
        private Long localId;
        private Long especialidadeId;
    }
}