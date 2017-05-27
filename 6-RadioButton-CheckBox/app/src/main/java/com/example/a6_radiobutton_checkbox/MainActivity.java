package com.example.a6_radiobutton_checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btnSeleccion;
    TextView tvSeleccion;
    CheckBox cboxTres, cboxCuatro;
    RadioButton rbUno, rbDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSeleccion = (Button) findViewById(R.id.btnSeleccion);
        tvSeleccion = (TextView) findViewById(R.id.tvSeleccion);
        cboxCuatro = (CheckBox) findViewById(R.id.cboxCuatro);
        cboxTres = (CheckBox) findViewById(R.id.cboxTres);
        rbDos = (RadioButton) findViewById(R.id.rbDos);
        rbUno  = (RadioButton) findViewById(R.id.rbUno);

        btnSeleccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rbUno.isChecked()){
                    tvSeleccion.setText(rbUno.getText());
                } else if (rbDos.isChecked()){
                    tvSeleccion.setText(rbDos.getText());
                } else if(cboxTres.isChecked()){
                    tvSeleccion.setText(cboxTres.getText());
                } else if (cboxCuatro.isChecked()){
                    tvSeleccion.setText(cboxCuatro.getText());
                } else {
                    tvSeleccion.setText("No se ha seleccionado nada");
                }


            }
        });
    }
}
