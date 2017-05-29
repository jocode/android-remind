package com.example.a10_pasar_informacion_entre_activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etDato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDato = (EditText) findViewById(R.id.etDato);
    }

    public void enviarInformacion(View view) {
        Intent intent =  new Intent(MainActivity.this, TwoActivity.class);
        intent.putExtra("Dato", etDato.getText().toString());
        startActivity(intent);
    }

    public void  exit(View view){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
