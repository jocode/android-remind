package com.example.a22_sugar_orm_for_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etIdentificacion, etNombres, etApellidos, etTelefono;
    Button btnGuardar, btnConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etIdentificacion = (EditText) findViewById(R.id.etIdentificacion);
        etNombres = (EditText) findViewById(R.id.etNombres);
        etApellidos = (EditText) findViewById(R.id.etApellidos);
        etTelefono = (EditText) findViewById(R.id.etTelefono);

        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnConsultar = (Button) findViewById(R.id.btnConsultar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Instanciar la Clase para guardar los datos con Sugar
                Persona persona = new Persona(etIdentificacion.getText().toString(), etNombres.getText().toString(),
                                        etApellidos.getText().toString(), etTelefono.getText().toString());
                persona.save();
            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    // Consultar los datos de la tabla persona
                    List<Persona> listaPersonas = Persona.find(Persona.class, "identificacion = ?", etIdentificacion.getText().toString());
                    /** Lo que se obtiene es un listado de Objetos persona, entonces almacenamos los valores en un nuevo
                    *   objeto persona para usar los métodos get de la clase.
                    */
                    Persona persona = listaPersonas.get(0);
                    etNombres.setText(persona.getNombres());
                    etApellidos.setText(persona.getApellidos());
                    etTelefono.setText(persona.getTelefono());
                } catch (Exception exception){
                    Toast.makeText(getApplicationContext(), "No se encontraron datos para la búsqueda", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
