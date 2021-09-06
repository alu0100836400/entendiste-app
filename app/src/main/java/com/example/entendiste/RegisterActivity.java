package com.example.entendiste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.entendiste.io.response.EstadisticasResponse;
import com.example.entendiste.io.response.LoginResponse;
import com.example.entendiste.io.response.StandardResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private EditText password2;
    private RegisterActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = (EditText) findViewById(R.id.editUserEmail);
        password = (EditText) findViewById(R.id.editPasswordRegister);
        password2 = (EditText) findViewById(R.id.editPasswordRepeatRegister);
        activity = this;
    }

    public void register(View view) {
        if(!password.getText().toString().equals(password2.getText().toString())) Toast.makeText(this, "Contraseñas diferentes", Toast.LENGTH_SHORT).show();
        else {
            Call<StandardResponse> call = ApiAdapter.getApiService().register(email.getText().toString(), password.getText().toString());
            call.enqueue(new Callback<StandardResponse>() { //quizás execute es mejor porque es síncrono
                @Override
                public void onResponse(Call<StandardResponse> call, Response<StandardResponse> response) {
                    //registrado con exito
                    //mandar a asignaturas
                    StandardResponse body = response.body();
                    if(body.isError()) Toast.makeText(activity, body.getMsg_error(), Toast.LENGTH_SHORT).show();
                    else {
                        Toast.makeText(activity, "Mensaje enviado, revisa tu correo", Toast.LENGTH_SHORT).show();
                        Intent login = new Intent(activity, LoginActivity.class);
                        startActivity(login);
                    }
                }

                @Override
                public void onFailure(Call<StandardResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Fallo registrando", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}