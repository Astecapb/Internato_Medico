package br.com.internato.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "locais")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String sigla;

    @Column(length = 500)
    private String endereco;

    private String cidade;
    private String cep;

    private Double latitude;
    private Double longitude;

    @OneToMany(mappedBy = "local", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private Set<LocalEspecialidade> especialidades = new HashSet<>();

    // ✅ Método adicional para compatibilidade com os erros de compilação
    public Integer getIndex() {
        return this.id != null ? this.id.intValue() : null;
    }

    // ✅ Método adicional para compatibilidade com os erros de compilação
    public String getType() {
        return this.sigla != null ? this.sigla : this.nome;
    }
}