package com.example.a8_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lvPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPlanetas = (ListView) findViewById(R.id.lvPlanetas);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.list_planets, android.R.layout.simple_list_item_1);
        lvPlanetas.setAdapter(adapter);
        
    }
}
