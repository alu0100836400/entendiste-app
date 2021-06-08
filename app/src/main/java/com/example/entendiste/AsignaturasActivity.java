package com.example.entendiste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.entendiste.io.response.AsignaturasResponse;
import com.example.entendiste.io.response.LoginResponse;
import com.example.entendiste.model.Asignatura;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AsignaturasActivity extends AppCompatActivity implements Callback<List<Asignatura>> {

    private ArrayList<AsignaturasResponse> listOpciones;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);
        recycler = (RecyclerView) findViewById(R.id.rv1);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        SharedPreferences userpref = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String usuario = userpref.getString("user", "");

        Call<List<Asignatura>> call = ApiAdapter.getApiService().getAsignaturas(usuario);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<AsignaturaResponse>> call, Response<List<Asignatura>> response) {
        listOpciones = new ArrayList<AsignaturasResponse>();

        for(int i = 0; i < response.body().size(); i++) {
            listOpciones.add(response.body().get(i));
        }
        AdapterItemOptions adapter = new AdapterItemOptions(listOpciones, this);
        recycler.setAdapter(adapter);
    }

    @Override
    public void onFailure(Call<List<Asignatura>> call, Throwable t) {
        Toast.makeText(this, "Fallo buscando las asignaturas", Toast.LENGTH_SHORT).show();
    }
}