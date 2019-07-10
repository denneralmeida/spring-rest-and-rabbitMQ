package br.com.xbrain.projeto.model;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "cliente",
        uniqueConstraints = @UniqueConstraint(name = "uc_cliente", columnNames = "cpf"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 60, nullable = false)
    @NotBlank(message = "O nome do cliente não pode ser vazio.")
    private String nome;

    @Email(message = "Insira um e-mail válido.")
    @Column(nullable = false, length = 60)
    @NotBlank(message = "Preencha o e-mail")
    private String email;

    @CPF(message = "Insira um CPF válido.")
    @Column(length = 14, nullable = false)
    @NotBlank(message = "Preencha o cpf")
    private String cpf;

    @Valid
    @OneToOne(cascade = CascadeType.ALL, targetEntity = Endereco.class)
    @JoinColumn(name = "endereco", foreignKey = @ForeignKey(name = "fk_cliente_endereco"))
    private Endereco endereco;

}
