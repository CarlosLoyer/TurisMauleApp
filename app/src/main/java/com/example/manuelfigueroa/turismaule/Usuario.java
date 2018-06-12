package com.example.manuelfigueroa.turismaule;

public class Usuario {
    private int id_usuario;
    private String password;
    private String nombre;
    private String email;
    private String fecha_nac;
    private String fecha_creacion;
    private String estado;

    public Usuario() {
    }

    public Usuario(int id_usuario, String password, String nombre, String email, String fecha_nac, String fecha_creacion, String estado) {
        this.id_usuario = id_usuario;
        this.password = password;
        this.nombre = nombre;
        this.email = email;
        this.fecha_nac = fecha_nac;
        this.fecha_creacion = fecha_creacion;
        this.estado = estado;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
