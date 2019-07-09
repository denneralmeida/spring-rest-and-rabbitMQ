package br.com.xbrain.projeto.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "produto", uniqueConstraints = @UniqueConstraint(name = "uc_produto", columnNames = "descricao"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "A descrição do produto não pode ser vazia.")
    @Column(length = 60, nullable = false)
    private String descricao;

    @Min(value = 0)
    @Digits(fraction = 2, integer = 8)
    @Column(columnDefinition = "decimal(8,2) default 0", nullable = false)
    private double valor;

}
