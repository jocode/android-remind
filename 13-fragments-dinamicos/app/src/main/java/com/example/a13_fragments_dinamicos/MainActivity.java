package com.example.a13_fragments_dinamicos;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    Button btnFragmentOne, btnFragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragmentOne = (Button) findViewById(R.id.btnFragmentOne);
        btnFragmentTwo = (Button)findViewById(R.id.btnFragmentTwo);

        btnFragmentOne.setOnClickListener(this);
        btnFragmentTwo.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnFragmentOne:
                /*Instanciamos el Fragment*/
                OneFragment oneFragment = new OneFragment();
                /*Instanciamos la API FragmentTrasaction */
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                /*Reemplazamos el fragment en el contenedor*/
                transaction.replace(R.id.containerFragment, oneFragment);
                /*Agregamos la transaccion a la pila trasera, para que podamos volver, al dar clic en el boton atras*/
                transaction.addToBackStack(null);
                /*Confirmamos la transaccion*/
                transaction.commit();
                break;

            case  R.id.btnFragmentTwo:
                TwoFragment twoFragment = new TwoFragment();
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.containerFragment, twoFragment);
                transaction1.addToBackStack(null);
                transaction1.commit();
                break;

        }

    }
}
