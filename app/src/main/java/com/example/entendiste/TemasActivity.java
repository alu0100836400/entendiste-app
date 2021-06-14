package com.example.entendiste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.entendiste.io.response.AsignaturasResponse;
import com.example.entendiste.io.response.TemasResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TemasActivity extends AppCompatActivity implements Callback<List<TemasResponse>> {

    private ArrayList<TemasResponse> listOpciones;
    private RecyclerView recycler;
    private String idAsignatura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
            setContentView(R.layout.activity_temas);
            recycler = (RecyclerView) findViewById(R.id.rv1);
            recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            idAsignatura = parametros.getString("idAsignatura");
            Call<List<TemasResponse>> call = ApiAdapter.getApiService().getTemas(idAsignatura);
            call.enqueue(this);
        }
        else {
            Toast.makeText(this, "Error: Asignatura no encontrada", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse(Call<List<TemasResponse>> call, Response<List<TemasResponse>> response) {
        listOpciones = new ArrayList<TemasResponse>();

        for(int i = 0; i < response.body().size(); i++) {
            listOpciones.add(response.body().get(i));
        }
        AdapterItemTemas adapter = new AdapterItemTemas(listOpciones, this);
        recycler.setAdapter(adapter);
    }

    @Override
    public void onFailure(Call<List<TemasResponse>> call, Throwable t) {
        Toast.makeText(this, "Fallo buscando los temas", Toast.LENGTH_SHORT).show();
    }
}