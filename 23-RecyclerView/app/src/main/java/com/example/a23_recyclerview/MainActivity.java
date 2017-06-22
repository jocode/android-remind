package com.example.a23_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Habitacion> dataSet_habitaciones;

    // Debemos crear el Adatador y el layoutManager del RecyclerView
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Intanciamos el recycler view
        recyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);

        /**
         * Utilice esta configuración para mejorar el rendimiento si sabe que los cambios
         * En el contenido no cambian el tamaño de diseño del RecyclerView
         */
        recyclerView.setHasFixedSize(true);

        dataSet_habitaciones = Arrays.asList(
                new Habitacion(R.mipmap.ic_launcher_round, "Habitacion con Jacuzzi", "Esta habiración tiene  JAcuzzi"),
                new Habitacion(R.mipmap.ic_launcher_round, "Habitacion con Baño", "Esta habitacion tiene baño"),
                new Habitacion(R.mipmap.ic_launcher_round, "Habitación doble", "Tiene doble cama, doble baño y todo es doble")
        );

        // Usamos un LinearLayoutManager
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new Adaptador_Recycler(dataSet_habitaciones);
        recyclerView.setAdapter(mAdapter);


    }
}
