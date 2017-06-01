package com.example.a17_sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etDato;
    Button btnGuardar, btnConsultar;
    /*Declaro el contexto*/
    Context context = this;
    /*Declaro un objeto de tipo SharedPreferences*/
    SharedPreferences sharedPreferences;
    public static final String PREFS_NAME = "misPreferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etDato = (EditText) findViewById(R.id.etDato);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnConsultar = (Button) findViewById(R.id.btnConsultar);

        btnConsultar.setOnClickListener(this);
        btnGuardar.setOnClickListener(this);

        /*Definir las preferencias y darle un nombre
        * getSharedPrefences() recibe por parámetro el Nombre de la preferencias y el modo del contexto,
        *  por ejemplo si es Privada, se puede leer y escribir solo en esta aplicación, y si es
        *  publico se puede escribir desde cualquier aplicación
         */
        sharedPreferences = getSharedPreferences(PREFS_NAME, context.MODE_PRIVATE);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnConsultar:
                /* Leer las preeferencias
                * getString() o tipo de dato recibe por parámetro el nombre de la preferencia y el valor por defecto
                * en caso de no tener datos
                * */
                String valor = sharedPreferences.getString("Dato", "No hay datos guardados");
                etDato.setText(valor);
                break;

            case R.id.btnGuardar:
                /* Guardar y sobreescribir preferencias */
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Dato", etDato.getText().toString());
                editor.commit();

                Toast.makeText(context, "Se ha guardado la preferencia.", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
