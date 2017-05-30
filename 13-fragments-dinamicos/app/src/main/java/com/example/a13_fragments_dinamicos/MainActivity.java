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
                OneFragment oneFragment = new OneFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.containerFragment, oneFragment);
                transaction.commit();
                break;

            case  R.id.btnFragmentTwo:
                TwoFragment twoFragment = new TwoFragment();
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.containerFragment, twoFragment);
                transaction1.commit();
                break;

        }

    }
}
