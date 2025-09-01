package br.com.internato.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha; // armazenar hash BCrypt

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Papel papel;

    public enum Papel {
        COORDENADOR, PRECEPTOR, ALUNO, SECRETARIA
    }
}