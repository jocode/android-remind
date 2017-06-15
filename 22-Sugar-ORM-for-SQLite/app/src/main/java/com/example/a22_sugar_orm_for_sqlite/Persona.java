package com.example.a22_sugar_orm_for_sqlite;

import com.orm.SugarRecord;

/**
 * Created by Camilo on 15/06/2017.
 */

public class Persona extends SugarRecord<Persona> {

    private String identificacion;
    private String nombres;
    private String apellidos;
    private String telefono;

    public Persona() {
    }

    public Persona(String identificacion, String nombres, String apellidos, String telefono) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
