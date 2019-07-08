package br.com.xbrain.projeto.model;

import br.com.xbrain.projeto.model.enums.UF;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10, nullable = false)
    @NotBlank(message = "O cep não pode estar vazio.")
    private String cep;

    @NotBlank(message = "O nome da rua não pode ser vazia.")
    @Column(length = 60, nullable = false)
    private String logradouro;

    @NotBlank(message = "A cidade não pode estar vazia.")
    @Column(length = 60, nullable = false)
    private String municipio;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 2, nullable = false)
    @NotNull(message = "O estado não pode ser nulo.")
    private UF uf;

}
