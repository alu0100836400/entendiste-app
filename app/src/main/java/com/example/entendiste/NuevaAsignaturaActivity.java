package com.example.entendiste;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.entendiste.io.response.AsignaturasResponse;
import com.example.entendiste.io.response.RespuestaResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NuevaAsignaturaActivity extends AppCompatActivity {

    private Spinner modoBusqueda;
    private EditText et_asignatura;
    private Button btn_buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_asignatura);

        modoBusqueda = (Spinner) findViewById(R.id.modo_sp);
        et_asignatura = (EditText) findViewById(R.id.et_asignatura);
        btn_buscar = (Button) findViewById(R.id.btn_buscar);

        String [] opciones = {"Por código", "Por nombre"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        modoBusqueda.setAdapter(adapter);
    }

    public void buscarAsignatura(View view) {
        String seleccion = modoBusqueda.getSelectedItem().toString();
        String asignatura = et_asignatura.getText().toString();
        int opcion = 0;

        switch (seleccion) {
            case "Por código": opcion = 1; break;
            case "Por nombre": opcion = 2; break;
            default: Toast.makeText(this, "Algo fue mal", Toast.LENGTH_SHORT).show();
        }

        Call<AsignaturasResponse> call = ApiAdapter.getApiService().getAsignaturasBuscar(Integer.parseInt(idPregunta));
        call.enqueue(new Callback<AsignaturasResponse>() { //quizás execute es mejor porque es síncrono
            @Override
            public void onResponse(Call<AsignaturasResponse> call, Response<AsignaturasResponse> response) {
                AsignaturasResponse respuesta = response.body();
                if(!respuesta.getEmpty()) {
                    if(respuesta.getRespuesta()) rdgRespuesta.check(R.id.yesBtn);
                    else rdgRespuesta.check(R.id.noBtn);
                }
            }

            @Override
            public void onFailure(Call<AsignaturasResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Fallo buscando la respuesta", Toast.LENGTH_SHORT).show();
            }
        });
    }
}