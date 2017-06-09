package com.example.a18_sqlite_android;

import android.content.ContentValues;
import android.database.Cursor;
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

                // Para leer información de la base de datos se define el repositorio como leible
                SQLiteDatabase db = dbHelper.getReadableDatabase();

                // Se define una proyección con las columnas que va a consultar
                String[] proyection = {
                        DbHelper.TablaPersona.COLUMNA_NOMBRES,
                        DbHelper.TablaPersona.COLUMNA_TELEFONO
                };

                // Si se desea crear una condición en la consulta por ejemplo WHERE "title" = 'Mi titulo'
                 String selection = DbHelper.TablaPersona.COLUMNA_ID + " = ?";
                 String[] selectionArgs = { etId.getText().toString() };


                // Para ordenar los elementos del cursos, en caso de que sean varios datos
                /**
                 * String sortOrder = TablaConsulta.NombreColumna + "DESC";
                 */

                Cursor cursor = db.query(
                        DbHelper.TablaPersona.TABLE_NAME,     // Tabla a consultar
                        proyection,                           // Columnas a devolver
                        selection,                            // Columna para la clausula WHERE
                        selectionArgs,                        // Valor para para la clásula WHERE
                        null,                                 // No agrupar las filas
                        null,                                 // No filtrar por grupos de filas
                        null                                  // Orden de la consulta
                );

                // moveToFirst() Coloca la "posición de lectura" en la primera entrada de los resultados
                cursor.moveToFirst();

                // Colocar los registros en los campos de texto
                try {
                    etNombres.setText(cursor.getString(0));
                    etTelefono.setText(cursor.getString(1));
                } catch (Exception exeption){
                    Toast.makeText(getApplicationContext(), "No hay Información para la consulta", Toast.LENGTH_LONG).show();
                }


            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = dbHelper.getReadableDatabase();

                //Defino la seleccion
                String selection = DbHelper.TablaPersona.COLUMNA_ID + " =?";

                // Defino los argumentos de seleccion
                String[] selectionArgs = {etId.getText().toString()};

                // Hago la sentencia SQL para eliminar datos
                db.delete(DbHelper.TablaPersona.TABLE_NAME, selection, selectionArgs);
            }
        });

    }
}
