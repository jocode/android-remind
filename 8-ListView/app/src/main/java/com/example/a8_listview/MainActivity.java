package com.example.a8_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPlanetas = (ListView) findViewById(R.id.lvPlanetas);

        ArrayList languajes = new ArrayList();
        languajes.add("Java");
        languajes.add("Kotlin");
        languajes.add("Swift");
        languajes.add("C#");
        languajes.add("C++");
        languajes.add("Javascript");
        languajes.add("Phyton");
        languajes.add("Ruby");
        languajes.add("PHP");
        languajes.add("C");
        languajes.add("Objective-C");
        languajes.add("Perl");
        languajes.add("Go");
        languajes.add("Visual Basic");
        languajes.add("Spark");

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, languajes);

        lvPlanetas.setAdapter(adapter);

    }
}
