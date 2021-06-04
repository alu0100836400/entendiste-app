package com.example.entendiste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
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
        Call<LoginResponse> call = ApiAdapter.getApiService().getLogin(user.getText().toString(), password.getText().toString()); //user.getText().toString(), password.getText().toString()
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
        if(response.isSuccessful()) {
            LoginResponse body = response.body();
            if(body.key.toString().equals("true"))
                Toast.makeText(LoginActivity.this, "Pa dentro!", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(LoginActivity.this, "No puedes pasar!", Toast.LENGTH_LONG).show();

            Log.d("response: ", body.key.toString());
        }
    }

    @Override
    public void onFailure(Call<LoginResponse> call, Throwable t) {
        Toast.makeText(LoginActivity.this, "upsss, no se pudo conectar", Toast.LENGTH_LONG).show();
    }
}