package com.example.a23_recyclerview;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Camilo on 22/06/2017.
 */

public class Adaptador_Recycler extends RecyclerView.Adapter<Adaptador_Recycler.ViewHolder> {

    List<Habitacion> listaHabitacion;

    public Adaptador_Recycler(List<Habitacion> listaHabitacion) {
        this.listaHabitacion = listaHabitacion;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Crear una vista
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adaptador_recycler, parent, false);

        // Creamos la instancia de la clase estática del ViewHolder
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    // Reemplazamos el contenido de la vista de cada item
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Obtenemos el elemento del conjunto de datos en cada posicion y reemplazamos el contenido en la vista
        holder.imagen.setImageResource(listaHabitacion.get(position).getImagen());
        holder.tvTitulo.setText(listaHabitacion.get(position).getTipo());
        holder.tvDescripcion.setText(listaHabitacion.get(position).getDescripcion());
    }

    @Override
    public int getItemCount() {
        return listaHabitacion.size();
    }

    // En la clase estática del ViewHolder instanciamos los elementos del diseño del Item en los RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        //Instanciamos los elementos del diseño
        ImageView imagen;
        TextView tvTitulo, tvDescripcion;

        public ViewHolder(View itemView) {
            super(itemView);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
            tvTitulo = (TextView) itemView.findViewById(R.id.tvTitulo);
            tvDescripcion = (TextView) itemView.findViewById(R.id.tvDescripcion);
        }
    }

}
