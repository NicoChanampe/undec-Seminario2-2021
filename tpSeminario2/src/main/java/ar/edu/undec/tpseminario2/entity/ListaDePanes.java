package ar.edu.undec.tpseminario2.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lista_de_panes", schema = "pandulcedb", catalog = "")
public class ListaDePanes {
    private Integer id;
    private Integer cantidad;
    private Panes panesByPanesid;
    private Pedidos pedidosByPedidosid;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cantidad", nullable = false)
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListaDePanes that = (ListaDePanes) o;
        return Objects.equals(id, that.id) && Objects.equals(cantidad, that.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cantidad);
    }

 //   @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
 //   @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "panesid", referencedColumnName = "id", nullable = false)
    public Panes getPanesByPanesid() {
        return panesByPanesid;
    }

    public void setPanesByPanesid(Panes panesByPanesid) {
        this.panesByPanesid = panesByPanesid;
    }

    @ManyToOne
    @JoinColumn(name = "pedidosid", referencedColumnName = "id", nullable = false)
    public Pedidos getPedidosByPedidosid() {
        return pedidosByPedidosid;
    }

    public void setPedidosByPedidosid(Pedidos pedidosByPedidosid) {
        this.pedidosByPedidosid = pedidosByPedidosid;
    }
}
