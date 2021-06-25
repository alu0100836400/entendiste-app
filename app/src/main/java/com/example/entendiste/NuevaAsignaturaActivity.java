package com.example.entendiste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.entendiste.io.response.AsignaturasResponse;
import com.example.entendiste.io.response.RespuestaResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NuevaAsignaturaActivity extends AppCompatActivity {

    private Spinner modoBusqueda;
    private EditText et_asignatura;
    private Button btn_buscar;
    private RecyclerView rv_encontrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_asignatura);

        modoBusqueda = (Spinner) findViewById(R.id.modo_sp);
        et_asignatura = (EditText) findViewById(R.id.et_asignatura);
        btn_buscar = (Button) findViewById(R.id.btn_buscar);
        rv_encontrados = (RecyclerView) findViewById(R.id.rv_encontradas);
        rv_encontrados.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

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

        String usuario = getSharedPreferences("datos", Context.MODE_PRIVATE).getString("user", "");

        Call<ArrayList<AsignaturasResponse>> call = ApiAdapter.getApiService().getAsignaturasBuscar(asignatura, opcion);
        call.enqueue(new Callback<ArrayList<AsignaturasResponse>>() { //quizás execute es mejor porque es síncrono
            @Override
            public void onResponse(Call<ArrayList<AsignaturasResponse>> call, Response<ArrayList<AsignaturasResponse>> response) {
                ArrayList<AsignaturasResponse> respuesta = response.body();

                AdapterItemOptions adapter = new AdapterItemOptions(respuesta, NuevaAsignaturaActivity.this, usuario);
                rv_encontrados.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<AsignaturasResponse>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Fallo buscando la respuesta", Toast.LENGTH_SHORT).show();
            }
        });
    }
}