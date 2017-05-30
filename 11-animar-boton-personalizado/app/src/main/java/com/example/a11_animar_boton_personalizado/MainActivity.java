package com.example.a11_animar_boton_personalizado;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    /*Intanciamos el objto MediaPlayer*/
    MediaPlayer mediaPlayer;
    Button btnSaludar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Agregarmos el sonido desde indicandole el contexto y el recurso*/
        mediaPlayer = MediaPlayer.create(this, R.raw.clic);

        btnSaludar = (Button) findViewById(R.id.btnSaludar);

        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                Toast.makeText(getApplicationContext(), "Hola, ¿Cómo estas?", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
