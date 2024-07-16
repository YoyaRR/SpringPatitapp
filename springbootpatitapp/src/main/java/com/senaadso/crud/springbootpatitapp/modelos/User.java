package com.senaadso.crud.springbootpatitapp.modelos;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private long cedula;
    private String direccion;
    private String email;
    private String usuario;
    private String contrasena;
    private Date fecha_de_registro;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFecha_de_registro() {
        return fecha_de_registro;
    }

    public void setFecha_de_registro(Date fecha_de_registro) {
        this.fecha_de_registro = fecha_de_registro;
    }
}
