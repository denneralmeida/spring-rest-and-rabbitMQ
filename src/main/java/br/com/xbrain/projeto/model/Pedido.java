package br.com.xbrain.projeto.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido implements Serializable {

    @Id
    private UUID id = UUID.randomUUID();

    @NotNull(message = "Escolha um cliente.")
    @ManyToOne(targetEntity = Cliente.class)
    @JoinColumn(name = "cliente", foreignKey = @ForeignKey(name = "fk_pedido_cliente"))
    private Cliente cliente;

    @Min(value = 0)
    @Digits(fraction = 2, integer = 10)
    @Column(columnDefinition = "DECIMAL(10,2) DEFAULT 0", nullable = false)
    private float valorTotal;


    @OneToOne(targetEntity = Endereco.class)
    @JoinColumn(name = "endereco", foreignKey = @ForeignKey(name = "fk_pedido_endereco"))
    private Endereco enderecoEntrega;

    @NotNull(message = "Selecione um ou mais produtos.")
    @ManyToMany(targetEntity = Produto.class)
    @JoinTable(name = "pedido_produtos",
            joinColumns = @JoinColumn(name = "pedido_id", foreignKey = @ForeignKey(name = "fk_pedido_id")),
            inverseJoinColumns = @JoinColumn(name = "produto_id", foreignKey = @ForeignKey(name = "fk_pedido_produto")))
    private List<Produto> produtos;


}
