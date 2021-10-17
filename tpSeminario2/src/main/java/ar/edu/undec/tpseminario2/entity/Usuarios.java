package ar.edu.undec.tpseminario2.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Usuarios {
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private String telefono;
    private String maildecuenta;
    private String contraseña;
    private Byte estado;
    private Date fechacreacion;
    private Date fechamodificacion;
    private Date fechadebaja;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 30)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "apellido", nullable = false, length = 30)
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Basic
    @Column(name = "dni", nullable = false, length = 10)
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Basic
    @Column(name = "direccion", nullable = false, length = 60)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "telefono", nullable = false, length = 15)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Basic
    @Column(name = "maildecuenta", nullable = false, length = 40)
    public String getMailDeCuenta() {
        return maildecuenta;
    }

    public void setMailDeCuenta(String maildecuenta) {
        this.maildecuenta = maildecuenta;
    }

    @Basic
    @Column(name = "contraseña", nullable = false, length = 20)
    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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
    @Column(name = "fechacreacion", nullable = true)
    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Basic
    @Column(name = "fechamodificacion", nullable = true)
    public Date getFechamodificacion() {
        return fechamodificacion;
    }

    public void setFechamodificacion(Date fechamodificacion) {
        this.fechamodificacion = fechamodificacion;
    }

    @Basic
    @Column(name = "fechadebaja", nullable = true)
    public Date getFechadebaja() {
        return fechadebaja;
    }

    public void setFechadebaja(Date fechadebaja) {
        this.fechadebaja = fechadebaja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuarios usuarios = (Usuarios) o;
        return Objects.equals(id, usuarios.id) && Objects.equals(nombre, usuarios.nombre) && Objects.equals(apellido, usuarios.apellido) && Objects.equals(dni, usuarios.dni) && Objects.equals(direccion, usuarios.direccion) && Objects.equals(telefono, usuarios.telefono) && Objects.equals(maildecuenta, usuarios.maildecuenta) && Objects.equals(contraseña, usuarios.contraseña) && Objects.equals(estado, usuarios.estado) && Objects.equals(fechacreacion, usuarios.fechacreacion) && Objects.equals(fechamodificacion, usuarios.fechamodificacion) && Objects.equals(fechadebaja, usuarios.fechadebaja);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, dni, direccion, telefono, maildecuenta, contraseña, estado, fechacreacion, fechamodificacion, fechadebaja);
    }
}
