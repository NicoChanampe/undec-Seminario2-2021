package com.undec.pandulce.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Usuarios", schema = "pandulcedb", catalog = "")
public class UsuariosEntity {
    private Integer idUsuario;
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private String telefono;
    private String mailDeCuenta;
    private String contraseña;
    private Collection<PedidosEntity> listadoPedidos;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario_pk")
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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
    @Column(name = "apellido")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "dni")
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Basic
    @Column(name = "direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Basic
    @Column(name = "mailDeCuenta")
    public String getMailDeCuenta() {
        return mailDeCuenta;
    }

    public void setMailDeCuenta(String mailDeCuenta) {
        this.mailDeCuenta = mailDeCuenta;
    }

    @Basic
    @Column(name = "contraseña")
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuariosEntity that = (UsuariosEntity) o;
        return Objects.equals(idUsuario, that.idUsuario) && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(dni, that.dni) && Objects.equals(direccion, that.direccion) && Objects.equals(telefono, that.telefono) && Objects.equals(mailDeCuenta, that.mailDeCuenta) && Objects.equals(contraseña, that.contraseña);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nombre, apellido, dni, direccion, telefono, mailDeCuenta, contraseña);
    }

    @OneToMany(mappedBy = "usuarioDueño")
    public Collection<PedidosEntity> getListadoPedidos() {
        return listadoPedidos;
    }

    public void setListadoPedidos(Collection<PedidosEntity> listadoPedidos) {
        this.listadoPedidos = listadoPedidos;
    }
}
