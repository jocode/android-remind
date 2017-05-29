package com.example.a10_pasar_informacion_entre_activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TwoActivity extends AppCompatActivity {

    TextView tvDato;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        tvDato = (TextView) findViewById(R.id.tvDato);
        btnVolver = (Button) findViewById(R.id.btnVolver);

        /*Creamos un Bundle, y obtenemos los extras enviados en el intent*/
        Bundle bundle = getIntent().getExtras();
        /*Guardamos el dato obtenido en una variable y el bundle lo convertimos en string*/
        String dato = bundle.getString("Dato").toString();

        /*Mostramos el dato en el textView*/
        tvDato.setText(dato);

    }

    public void backHome(View view){
        startActivity(new Intent(TwoActivity.this, MainActivity.class));
    }
}
