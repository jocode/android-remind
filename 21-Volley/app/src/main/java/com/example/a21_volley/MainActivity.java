package com.example.a21_volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvResponse = (TextView) findViewById(R.id.tvResponse);

        // Instanciamos el RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);

        //Url a la cual hacemos la peticion
        String url = "http://192.168.0.102/volleyServices/getUser.php?cc=12345";

        // Solicita una respuesta de String de la url propporcionada
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                //Respuesta recibida
                tvResponse.setText("Respuesta: "+response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                //Error en la repuesta
                tvResponse.setText("Error: "+error);

            }
        });

        // Agregamos la respuesta al RequestQueue
        queue.add(stringRequest);


    }
}
