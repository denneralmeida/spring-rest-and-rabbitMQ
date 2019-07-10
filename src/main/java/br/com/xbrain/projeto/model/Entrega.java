package br.com.xbrain.projeto.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "entrega")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Entrega implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(targetEntity = Endereco.class)
    @JoinColumn(name = "endereco_entrega", foreignKey = @ForeignKey(name = "fk_entrega_endereco"))
    private Endereco enderecoEntrega;

    @OneToOne(targetEntity = Pedido.class)
    @JoinColumn(name = "pedido", foreignKey = @ForeignKey(name = "fk_entrega_pedido"))
    private Pedido pedido;


}
