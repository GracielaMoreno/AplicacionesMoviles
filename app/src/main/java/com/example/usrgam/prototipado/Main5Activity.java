package com.example.usrgam.prototipado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class Main5Activity extends AppCompatActivity {
    //crear un cliente api google
    //codigo de respuesta 9001
    private GoogleApiClient googleApiClient;
    private final int CODERC = 9001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

    }

    public void AbrirLoginGoogle(View view){
        Intent intent =new Intent(getApplicationContext(),Registro.class);
        startActivity(intent);
    }
    public void AbrirLogin(View view){
        Intent intent =new Intent(getApplicationContext(),Main6Activity.class);
        startActivity(intent);
    }
}
