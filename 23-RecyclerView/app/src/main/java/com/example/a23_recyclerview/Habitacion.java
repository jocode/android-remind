package com.example.a23_recyclerview;

/**
 * Created by Camilo on 22/06/2017.
 */

public class Habitacion {

    int imagen;
    String tipo;
    String Descripcion;

    public Habitacion(int imagen, String tipo, String descripcion) {
        this.imagen = imagen;
        this.tipo = tipo;
        Descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
