package com.undec.pandulce.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Lista_de_panes", schema = "pandulcedb", catalog = "")
public class ListaDePanesEntity {
    private Integer idLista;
    private Integer idPedido;
    private Integer cantidad;
    private PanesEntity panes;

    @Id
    @Column(name = "idLista_pk")
    public Integer getIdLista() {
        return idLista;
    }

    public void setIdLista(Integer idLista) {
        this.idLista = idLista;
    }

    @Basic
    @Column(name = "idPedido_fk")
    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    @Basic
    @Column(name = "cantidad")
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
        ListaDePanesEntity that = (ListaDePanesEntity) o;
        return Objects.equals(idLista, that.idLista) && Objects.equals(idPedido, that.idPedido) && Objects.equals(cantidad, that.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLista, idPedido, cantidad);
    }

    @ManyToOne
    @JoinColumn(name = "idPan_fk", referencedColumnName = "idPan_pk", nullable = false)
    public PanesEntity getPanes() {
        return panes;
    }

    public void setPanes(PanesEntity panes) {
        this.panes = panes;
    }
}
