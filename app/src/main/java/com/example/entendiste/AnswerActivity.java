package com.example.entendiste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.entendiste.io.response.AsignaturasResponse;
import com.example.entendiste.io.response.RespuestaResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnswerActivity extends AppCompatActivity {
    private int idPregunta;
    private RadioGroup rdgRespuesta;
    private Button btnConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){

            rdgRespuesta = (RadioGroup)findViewById(R.id.rdgRespuesta);
            btnConfirmar = (Button)findViewById(R.id.btnConfirmar);
            idPregunta = parametros.getInt("idPregunta");

            SharedPreferences userpref = getSharedPreferences("datos", Context.MODE_PRIVATE);
            String user = userpref.getString("user", "");

            Call<RespuestaResponse> call = ApiAdapter.getApiService().getRespuesta(idPregunta, user);
            call.enqueue(new Callback<RespuestaResponse>() { //quizás execute es mejor porque es síncrono
                @Override
                public void onResponse(Call<RespuestaResponse> call, Response<RespuestaResponse> response) {
                    RespuestaResponse respuesta = response.body();
                    if(!respuesta.getEmpty()) {
                        if(respuesta.getRespuesta()) rdgRespuesta.check(R.id.yesBtn);
                        else rdgRespuesta.check(R.id.noBtn);
                    }
                }

                @Override
                public void onFailure(Call<RespuestaResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Fallo buscando la respuesta", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else {
            Toast.makeText(this, "Error: Tema no encontrado", Toast.LENGTH_SHORT).show();
        }
    }

    public void enviarRespuesta(View view) {
        Boolean eleccion = null;
        switch (rdgRespuesta.getCheckedRadioButtonId()) {
            case R.id.yesBtn: eleccion = true; break;
            case R.id.noBtn: eleccion = false; break;
            default: Toast.makeText(this, "Debe seleccionar una respuesta", Toast.LENGTH_SHORT).show();
        }
        if(eleccion != null) {
            SharedPreferences userpref = getSharedPreferences("datos", Context.MODE_PRIVATE);
            String user = userpref.getString("user", "");
            Toast.makeText(getApplicationContext(), "Respuesta guardada correctamente", Toast.LENGTH_SHORT).show();
            Call<RespuestaResponse> call = ApiAdapter.getApiService().setRespuesta(idPregunta, user, eleccion);
            call.enqueue(new Callback<RespuestaResponse>() {
                @Override
                public void onResponse(Call<RespuestaResponse> call, Response<RespuestaResponse> response) {
                    RespuestaResponse respuesta = response.body();

                    if (!respuesta.getError()) {
                        Toast.makeText(getApplicationContext(), "Respuesta guardada correctamente", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else
                        Toast.makeText(getApplicationContext(), "El servidor devolvió error", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<RespuestaResponse> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "No se pudo guardar la respuesta", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}