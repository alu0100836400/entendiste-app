package com.example.entendiste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.entendiste.io.response.AsignaturasResponse;
import com.example.entendiste.io.response.LoginResponse;
import com.example.entendiste.io.response.TestResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity implements Callback<LoginResponse> {

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
        Call<LoginResponse> call = ApiAdapter.getApiService().getLogin(user.getText().toString(), password.getText().toString());
        call.enqueue(this);
    }

    public void register(View view) {
        Intent register = new Intent(this, RegisterActivity.class);
        startActivity(register);
    }

    @Override
    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
        if(response.isSuccessful()) {
            LoginResponse body = response.body();
            if(body.key.toString().equals("true")) {
                SharedPreferences userpref = getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor useredit = userpref.edit();
                useredit.putString("user", user.getText().toString());
                useredit.commit();

                Toast.makeText(LoginActivity.this, "Login correcto", Toast.LENGTH_LONG).show();
                Intent asignaturas = new Intent(this, AsignaturasActivity.class);
                startActivity(asignaturas);
            }
            else
                Toast.makeText(LoginActivity.this, "Login incorrecto", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailure(Call<LoginResponse> call, Throwable t) {
        Toast.makeText(LoginActivity.this, "Ups! No se pudo conectar", Toast.LENGTH_LONG).show();
    }
}