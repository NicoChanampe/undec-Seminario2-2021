package ar.edu.undec.tpseminario2.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Pedidos {
    private Integer id;
    private String codigo;
    private Integer cantidadPanes;
    private Date fechaEntrega;
    private Double costoTotal;
    private Usuarios usuariosByUsuariosid;

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
    @Column(name = "codigo", nullable = false, length = 16)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "cantidadPanes", nullable = false)
    public Integer getCantidadPanes() {
        return cantidadPanes;
    }

    public void setCantidadPanes(Integer cantidadPanes) {
        this.cantidadPanes = cantidadPanes;
    }

    @Basic
    @Column(name = "fechaEntrega", nullable = true)
    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    @Basic
    @Column(name = "costoTotal", nullable = false, precision = 0)
    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedidos pedidos = (Pedidos) o;
        return Objects.equals(id, pedidos.id) && Objects.equals(codigo, pedidos.codigo) && Objects.equals(cantidadPanes, pedidos.cantidadPanes) && Objects.equals(fechaEntrega, pedidos.fechaEntrega) && Objects.equals(costoTotal, pedidos.costoTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, cantidadPanes, fechaEntrega, costoTotal);
    }

    @ManyToOne
    @JoinColumn(name = "usuariosid", referencedColumnName = "id")
    public Usuarios getUsuariosByUsuariosid() {
        return usuariosByUsuariosid;
    }

    public void setUsuariosByUsuariosid(Usuarios usuariosByUsuariosid) {
        this.usuariosByUsuariosid = usuariosByUsuariosid;
    }
}
