package com.example.a22_sugar_orm_for_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etIdentificacion, etNombres, etApellidos, etTelefono;
    Button btnGuardar, btnConsultar;
    ListView lvResulado;

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

        lvResulado = (ListView) findViewById(R.id.lvResultados);

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

                    // Cargar todos los datos
                    loadResultSQLite();

                } catch (Exception exception){
                    Toast.makeText(getApplicationContext(), "No se encontraron datos para la búsqueda", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    private void loadResultSQLite() {
        // Hacer la consulta de todos los datos de la Clase Persona
        List<Persona> personas = Persona.listAll(Persona.class);
        // Crear un array list para agregar los datos al ListView
        ArrayList<String> listado = new ArrayList<String>();

        // Recorrer el tamaño de los datos de la consulta y agregarlo al ArrayList
        for (int i = 0; i < personas.size(); i++){
            Persona persona =  personas.get(i);
            listado.add(""+persona.getId()+" - "+persona.getIdentificacion()+" - "+persona.getNombres() );
        }

        // Definir el Adaptador, y pasarle el listado
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listado);

        // Definir el adaptador al ListView
        lvResulado.setAdapter(adapter);
    }
}
