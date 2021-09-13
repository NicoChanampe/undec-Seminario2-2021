package ar.edu.undec.tpseminario2.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Panes {
    private Integer id;
    private String nombre;
    private String contenido;
    private Integer pesoengramos;
    private Double precio;
    private Date fechadebaja;
    private Date fechadealta;
    private Byte estado;
    private Date fechamodificacion;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 20)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "contenido", nullable = true, length = 75)
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Basic
    @Column(name = "pesoengramos", nullable = true)
    public Integer getPesoengramos() {
        return pesoengramos;
    }

    public void setPesoengramos(Integer pesoengramos) {
        this.pesoengramos = pesoengramos;
    }

    @Basic
    @Column(name = "precio", nullable = false, precision = 0)
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Basic
    @Column(name = "fechadebaja", nullable = true)
    public Date getFechadebaja() {
        return fechadebaja;
    }

    public void setFechadebaja(Date fechadebaja) {
        this.fechadebaja = fechadebaja;
    }

    @Basic
    @Column(name = "fechadealta", nullable = true)
    public Date getFechadealta() {
        return fechadealta;
    }

    public void setFechadealta(Date fechadealta) {
        this.fechadealta = fechadealta;
    }

    @Basic
    @Column(name = "estado", nullable = false)
    public Byte getEstado() {
        return estado;
    }

    public void setEstado(Byte estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "fechamodificacion", nullable = true)
    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Panes panes = (Panes) o;
        return Objects.equals(id, panes.id) && Objects.equals(nombre, panes.nombre) && Objects.equals(contenido, panes.contenido) && Objects.equals(pesoengramos, panes.pesoengramos) && Objects.equals(precio, panes.precio) && Objects.equals(fechadebaja, panes.fechadebaja) && Objects.equals(fechadealta, panes.fechadealta) && Objects.equals(estado, panes.estado) && Objects.equals(fechamodificacion, panes.fechamodificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, contenido, pesoengramos, precio, fechadebaja, fechadealta, estado, fechamodificacion);
    }
}
