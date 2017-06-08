package com.example.a18_sqlite_android;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnGuardar, btnBuscar, btnActualizar, btnEliminar;
    EditText etId, etNombres, etTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Para acceder a la base de datos, crea una instancia de la subclase de SQLiteOpenHelper:
        final DbHelper dbHelper = new DbHelper(getApplicationContext());

        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnBuscar = (Button) findViewById(R.id.btnBuscar);

        etId = (EditText) findViewById(R.id.etId);
        etNombres = (EditText) findViewById(R.id.etNombres);
        etTelefono = (EditText) findViewById(R.id.etTelefono);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Obtener el repositorio de Datos en modo escritura
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                // Crear un mapa de valores donde los nombres de las columnas son las claves
                ContentValues values = new ContentValues();
                values.put(DbHelper.TablaPersona.COLUMNA_ID, etId.getText().toString());
                values.put(DbHelper.TablaPersona.COLUMNA_NOMBRES, etNombres.getText().toString());
                values.put(DbHelper.TablaPersona.COLUMNA_TELEFONO, etTelefono.getText().toString());

                //Inserte la nueva fila, devolviendo el valor de clave principal de la nueva fila
                long idGuardado = db.insert(DbHelper.TablaPersona.TABLE_NAME, DbHelper.TablaPersona.COLUMNA_ID, values);

                Toast.makeText(getApplicationContext(), "Se guardó el dato: "+idGuardado, Toast.LENGTH_LONG).show();

            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
