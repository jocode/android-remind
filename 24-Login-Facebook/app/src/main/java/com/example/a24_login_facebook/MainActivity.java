package com.example.a24_login_facebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;

public class MainActivity extends AppCompatActivity {

    TextView tvUsuario;
    ProfilePictureView imageProfile;
    Button btnCerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUsuario = (TextView) findViewById(R.id.tvUsuario);
        imageProfile = (ProfilePictureView) findViewById(R.id.imageProfile);
        btnCerrarSesion = (Button) findViewById(R.id.btnCerrarSesion);

        if (AccessToken.getCurrentAccessToken() == null){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {
            Profile profile = Profile.getCurrentProfile();
            tvUsuario.setText(profile.getName());
            imageProfile.setProfileId(profile.getId());
        }

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Cerrrar la sesión en Facebook
                LoginManager.getInstance().logOut();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });


    }
}
