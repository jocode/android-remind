package com.example.a23_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Camilo on 23/06/2017.
 */

class AdaptadorUsuarios extends RecyclerView.Adapter<AdaptadorUsuarios.ViewHolder> {

    List<Usuarios> list_users = new LinkedList<>();

    public AdaptadorUsuarios(List<Usuarios> list_users) {
        this.list_users = list_users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Crear una nueva vista
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_users, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    // Reemplazamos el contenido de la visa con cada item del listado
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String nombres = list_users.get(position).getNombres();
        char first = nombres.charAt(0);

        holder.tvInicial.setText(""+first);
        holder.tvNombres.setText(nombres);
        holder.tvApellidos.setText(list_users.get(position).getApellidos());
        holder.tvTelefono.setText(list_users.get(position).getTelefono());
    }

    @Override
    public int getItemCount() {
        return list_users.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        // Instanciamos los elementos de la vista
        TextView tvInicial, tvNombres, tvApellidos, tvTelefono;

        public ViewHolder(View itemView) {
            super(itemView);
            tvInicial = (TextView) itemView.findViewById(R.id.tvInicial);
            tvNombres = (TextView) itemView.findViewById(R.id.tvNombres);
            tvApellidos = (TextView) itemView.findViewById(R.id.tvApellidos);
            tvTelefono = (TextView) itemView.findViewById(R.id.tvTelefono);
        }
    }
}
