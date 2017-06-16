package com.example.a21_volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etCedula, etNombres, etApellidos, etDireccion, etTelefono;
    Button btnGuadar, btnConsultar;
    ListView lvPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCedula = (EditText) findViewById(R.id.etCedula);
        etNombres = (EditText) findViewById(R.id.etNombres);
        etApellidos = (EditText) findViewById(R.id.etApellidos);
        etDireccion = (EditText) findViewById(R.id.etDireccion);
        etTelefono = (EditText) findViewById(R.id.etTelefono);

        btnGuadar = (Button) findViewById(R.id.btnGuadar);
        btnConsultar = (Button) findViewById(R.id.btnConsultar);

        lvPersonas = (ListView) findViewById(R.id.lvPersonas);


        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "http://192.168.0.102/volleyServices/getUsers.php";
                requestRest(url);

            }
        });

        btnGuadar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "http://192.168.0.102/volleyServices/insertUser.php?" +
                        "cc=" + etCedula.getText().toString() +
                        "&nombres=" + etNombres.getText().toString() +
                        "&apellidos=" +  etApellidos.getText().toString() +
                        "&direccion=" + etDireccion.getText().toString() +
                        "&telefono=" + etTelefono.getText().toString();
                url = url.replace(" ", "%20");
                requestRest(url);
                Toast.makeText(getApplicationContext(), "Se ha guardado los datos", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void requestRest(String url) {
        // Instanciamos el RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);

        // Solicita una respuesta de String de la url propporcionada
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    // Convertir el String A JSONArray
                    JSONArray jsonArray = new JSONArray(response);
                    // Cargar el ListView
                    cargarListView(jsonArray);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error en la Petición", Toast.LENGTH_SHORT).show();
            }
        });

        // Agregamos la respuesta al RequestQueue
        queue.add(stringRequest);
    }

    private void cargarListView(JSONArray jsonArray) throws JSONException {

        // Crear un ArrarList
        ArrayList<String> listado = new ArrayList<>();

        // Recorrer los datos del JSON
        for (int i = 0; i < jsonArray.length(); i++){
            listado.add(jsonArray.getJSONObject(i).getString("nombres")+" "+jsonArray.getJSONObject(i).getString("apellidos"));
        }

        // Crear el adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listado);
        // Asignar el Adapador al listView
        lvPersonas.setAdapter(adapter);

    }
}
