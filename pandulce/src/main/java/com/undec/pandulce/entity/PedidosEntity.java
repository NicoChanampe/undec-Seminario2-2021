package com.undec.pandulce.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Pedidos", schema = "pandulcedb", catalog = "")
public class PedidosEntity {
    private Integer idPedido;
    private String codigo;
    private Integer cantidadPanes;
    private Date fechaEntrega;
    private Double costoTotal;
    private Integer idCliente;
    private Collection<ListaDePanesEntity> listaDePanes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPedido_pk")
    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    @Basic
    @Column(name = "codigo")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "cantidadPanes")
    public Integer getCantidadPanes() {
        return cantidadPanes;
    }

    public void setCantidadPanes(Integer cantidadPanes) {
        this.cantidadPanes = cantidadPanes;
    }

    @Basic
    @Column(name = "fechaEntrega")
    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    @Basic
    @Column(name = "costoTotal")
    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Basic
    @Column(name = "idCliente_fk")
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidosEntity that = (PedidosEntity) o;
        return Objects.equals(idPedido, that.idPedido) && Objects.equals(codigo, that.codigo) && Objects.equals(cantidadPanes, that.cantidadPanes) && Objects.equals(fechaEntrega, that.fechaEntrega) && Objects.equals(costoTotal, that.costoTotal) && Objects.equals(idCliente, that.idCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPedido, codigo, cantidadPanes, fechaEntrega, costoTotal, idCliente);
    }

    @OneToMany(mappedBy = "pedidos")
    public Collection<ListaDePanesEntity> getListaDePanes() {
        return listaDePanes;
    }

    public void setListaDePanes(Collection<ListaDePanesEntity> listaDePanes) {
        this.listaDePanes = listaDePanes;
    }
}
