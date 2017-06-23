package com.example.a23_recyclerview;

/**
 * Created by Camilo on 23/06/2017.
 */

public class Usuarios {

    String cedula;
    String nombres;
    String Apellidos;
    String direccion;
    String telefono;

    public Usuarios(String cedula, String nombres, String apellidos, String direccion, String telefono) {
        this.cedula = cedula;
        this.nombres = nombres;
        Apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
