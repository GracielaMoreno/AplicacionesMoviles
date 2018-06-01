package com.example.usrgam.prototipado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import control.control;
import modelo1.Persona;

public class MainActivity extends AppCompatActivity {
     Persona[] dato;
    private GoogleApiClient googleApiClient;
    private final int CODERC = 9001;
    EditText usuario;
    EditText pasword;
    private control lea = new control();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        usuario =(EditText)findViewById(R.id.iduser);
        pasword =(EditText)findViewById(R.id.idpasword);
        Button buttonIngresar =(Button)findViewById(R.id.buttoningresar);
        SignInButton botongoogle = (SignInButton) findViewById(R.id.logeogmail);
        botongoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logeoGmail();
            }
        });

    }

    public void AbrirListalogin (View view){

        Intent intento = new Intent(getApplicationContext(), Main5Activity.class);
        ArrayList<Persona> u = lea.leerArchivo("usuario u");
        boolean bandera = true;

        for (int i = 0; i < u.size(); i++) {
            if(usuario.getText().toString().equals(u.get(i).getUsuario()) && pasword.getText().toString().equals(u.get(i).getPasword())) {
                bandera = true;
                break;
            }
            else {
                bandera = false;
            }
            Log.e("usuario : ", u.get(i).toString());
        }
        if(bandera) {
            Toast.makeText(getApplicationContext(), "INGRESO CORRECTO", Toast.LENGTH_LONG).show();
            startActivity(intento);
        }
        else {
            Toast.makeText(getApplicationContext(), "USUARIO O CONTRASEÑA INCORRECTOS", Toast.LENGTH_LONG).show();
        }

    }




    public void logeoGmail() {
        if(googleApiClient!=null) {
            //desconectado
            googleApiClient.disconnect();
        }
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        //igual el cliente con el logeo
        googleApiClient = new GoogleApiClient.Builder(this).addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions).build();
        //abrir ventana de google
        Intent singIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(singIntent, CODERC);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CODERC) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if(result.isSuccess()) {
                GoogleSignInAccount acc = result.getSignInAccount();
                String token = acc.getIdToken();
                Log.e("correo: ", acc.getEmail());
                Log.e("correo: ", acc.getDisplayName());
                Log.e("correo: ",acc.getId());
                if(token!=null) {

                    Toast.makeText(this, token, Toast.LENGTH_LONG).show();
                }

                Toast.makeText(this, "INGRESO CORRECTO", Toast.LENGTH_LONG).show();
                Intent intent =new Intent(getApplicationContext(),Main5Activity.class);
                startActivity(intent);
            }
        }
    }
    public void Registro(View view){
        Intent intent =new Intent(getApplicationContext(),registrarusuario.class);
        startActivity(intent);
    }
}
