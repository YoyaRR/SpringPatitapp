package com.senaadso.crud.springbootpatitapp.modelos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class UserDTO {
    @NotEmpty(message = "El campo nombre es obligatorio")
    private String nombre;

    @Min(0)
    private long cedula;

    @NotEmpty(message = "El campo direccion es obligatorio")
    private String direccion;

    @NotEmpty(message = "El campo email es obligatorio")
    private String email;

    @NotEmpty(message = "El campo usuario es obligatorio")
    private String usuario;

    @NotEmpty(message = "El campo contrasena es obligatorio")
    private String contrasena;

    public @NotEmpty(message = "El campo nombre es obligatorio") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotEmpty(message = "El campo nombre es obligatorio") String nombre) {
        this.nombre = nombre;
    }

    @Min(0)
    public long getCedula() {
        return cedula;
    }

    public void setCedula(@Min(0) long cedula) {
        this.cedula = cedula;
    }

    public @NotEmpty(message = "El campo direccion es obligatorio") String getDireccion() {
        return direccion;
    }

    public void setDireccion(@NotEmpty(message = "El campo direccion es obligatorio") String direccion) {
        this.direccion = direccion;
    }

    public @NotEmpty(message = "El campo email es obligatorio") String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "El campo email es obligatorio") String email) {
        this.email = email;
    }

    public @NotEmpty(message = "El campo usuario es obligatorio") String getUsuario() {
        return usuario;
    }

    public void setUsuario(@NotEmpty(message = "El campo usuario es obligatorio") String usuario) {
        this.usuario = usuario;
    }

    public @NotEmpty(message = "El campo contrasena es obligatorio") String getContrasena() {
        return contrasena;
    }

    public void setContrasena(@NotEmpty(message = "El campo contrasena es obligatorio") String contrasena) {
        this.contrasena = contrasena;
    }
}
