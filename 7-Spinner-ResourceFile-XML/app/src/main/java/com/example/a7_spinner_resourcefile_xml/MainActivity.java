package com.example.a7_spinner_resourcefile_xml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spPlanets = (Spinner) findViewById(R.id.spPlanetas);

        ArrayList languages = new ArrayList();
        languages.add("Java");
        languages.add("PHP");
        languages.add("Phyton");
        languages.add("Kotlin");
        languages.add("Go");
        languages.add("JavaScrip");
        languages.add("C#");
        languages.add("VB");
        languages.add("C");
        languages.add("C++");
        languages.add("Swift");

        //Crear un ArrayAdapter usando el string array y un diseño de spinner por defecto
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);

        //Especificar el diseño a utilizar cuando aparezca la lista de opciones
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, languages);

        //Aplicar el adaptador al Spinner
        spPlanets.setAdapter(adapter1);

    }
}
