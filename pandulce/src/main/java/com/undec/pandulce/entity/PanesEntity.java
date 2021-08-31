package com.undec.pandulce.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Panes", schema = "pandulcedb", catalog = "")
public class PanesEntity {
    private Integer idPan;
    private String nombre;
    private String contenido;
    private Integer pesoEnGramos;
    private Double precio;
    private Collection<ListaDePanesEntity> listaDePanes;

    @Id
    @Column(name = "idPan_pk")
    public Integer getIdPan() {
        return idPan;
    }

    public void setIdPan(Integer idPan) {
        this.idPan = idPan;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "contenido")
    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Basic
    @Column(name = "pesoEnGramos")
    public Integer getPesoEnGramos() {
        return pesoEnGramos;
    }

    public void setPesoEnGramos(Integer pesoEnGramos) {
        this.pesoEnGramos = pesoEnGramos;
    }

    @Basic
    @Column(name = "precio")
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PanesEntity that = (PanesEntity) o;
        return Objects.equals(idPan, that.idPan) && Objects.equals(nombre, that.nombre) && Objects.equals(contenido, that.contenido) && Objects.equals(pesoEnGramos, that.pesoEnGramos) && Objects.equals(precio, that.precio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPan, nombre, contenido, pesoEnGramos, precio);
    }

    @OneToMany(mappedBy = "panes")
    public Collection<ListaDePanesEntity> getListaDePanes() {
        return listaDePanes;
    }

    public void setListaDePanes(Collection<ListaDePanesEntity> listaDePanes) {
        this.listaDePanes = listaDePanes;
    }
}
