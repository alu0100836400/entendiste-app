package com.example.entendiste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;


public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private EditText user;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = (EditText) findViewById(R.id.editUserLogin);
        password = (EditText) findViewById(R.id.editPasswordLogin);
    }

    public void Login(View view) {
        SharedPreferences preferences = getSharedPreferences("sesionesIniciadas", Context.MODE_PRIVATE);
        SharedPreferences.Editor editSessionPreferences = preferences.edit();

        Map<String, ?> passwords = preferences.getAll();
        //String dato = preferences.getString("clave", ""); //así no tengo que obtener todos los datos

        if(passwords.containsKey(user.getText().toString())) {
            if(password.getText().toString().equals(passwords.get(user.getText().toString())))
                Toast.makeText(this, "Estás dentro papi", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "Esa contraseña no es socio", Toast.LENGTH_SHORT).show();
        }
        else {
            editSessionPreferences.putString(user.getText().toString(), password.getText().toString());
            editSessionPreferences.commit();
            Toast.makeText(this, "El usuario " + user.getText().toString() + " no existe, añadiendo...", Toast.LENGTH_SHORT).show();
        }
    }
}