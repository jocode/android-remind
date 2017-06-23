package com.example.a23_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Habitacion> dataSet_habitaciones;

    // Debemos crear el Adatador y el layoutManager del RecyclerView
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    // Url para obtener la peticion
    String url = "http://192.168.0.102/volleyServices/getUsers.php";

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

        /*
        dataSet_habitaciones = Arrays.asList(
                new Habitacion(R.mipmap.ic_launcher_round, "Habitacion con Jacuzzi", "Esta habiración tiene  JAcuzzi"),
                new Habitacion(R.mipmap.ic_launcher_round, "Habitacion con Baño", "Esta habitacion tiene baño"),
                new Habitacion(R.mipmap.ic_launcher_round, "Habitación doble", "Tiene doble cama, doble baño y todo es doble")
        );
        */
        // Usamos un LinearLayoutManager
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        // Llenar un recyclerView con informarcion de JSON
        request_user(url);

        /*
        mAdapter = new Adaptador_Recycler(dataSet_habitaciones);
        recyclerView.setAdapter(mAdapter);
        */


    }

    private void request_user(String url) {
        // Instanciar el RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            load_listData(jsonArray);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Error al Obtener la respuesta", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error en la Petición", Toast.LENGTH_SHORT).show();
            }
        });
        // Agregar la peticion al RequestQueue
        queue.add(stringRequest);
    }

    private void load_listData(JSONArray jsonArray) throws JSONException {
        // Creo un ArrayList de tipo Usuario
        ArrayList<Usuarios> listaUsuarios = new ArrayList();

        // Recorrer el JSON y agregar el listado al ArrayList
        for (int i = 0; i < jsonArray.length(); i++){
            listaUsuarios.add(new Usuarios(
                    jsonArray.getJSONObject(i).getString("cedula"),
                    jsonArray.getJSONObject(i).getString("nombres"),
                    jsonArray.getJSONObject(i).getString("apellidos"),
                    jsonArray.getJSONObject(i).getString("direccion"),
                    jsonArray.getJSONObject(i).getString("telefono")
            ));
        }

        // Especificar el adaptador
        mAdapter = new AdaptadorUsuarios(listaUsuarios);
        recyclerView.setAdapter(mAdapter);

    }
}
