package com.example.entendiste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.entendiste.io.response.AsignaturasResponse;
import com.example.entendiste.io.response.RespuestaResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AsignaturasActivity extends AppCompatActivity {

    private ArrayList<AsignaturasResponse> listOpciones;
    private RecyclerView recycler;
    private TextView emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);
        emptyView = (TextView) findViewById(R.id.empty_view);
        recycler = (RecyclerView) findViewById(R.id.rv1);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        SharedPreferences userpref = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String usuario = userpref.getString("user", "");

        Call<List<AsignaturasResponse>> call = ApiAdapter.getApiService().getAsignaturas(usuario);
        call.enqueue(new Callback<List<AsignaturasResponse>>() {
            @Override
            public void onResponse(Call<List<AsignaturasResponse>> call, Response<List<AsignaturasResponse>> response) {
                listOpciones = new ArrayList<AsignaturasResponse>();

                for(int i = 0; i < response.body().size(); i++) {
                    listOpciones.add(response.body().get(i));
                }
                if(listOpciones.isEmpty()) {
                    recycler.setVisibility(View.GONE);
                    emptyView.setVisibility(View.VISIBLE);
                    emptyView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
                }
                else {
                    recycler.setVisibility(View.VISIBLE);
                    emptyView.setVisibility(View.GONE);
                    AdapterItemOptions adapter = new AdapterItemOptions(listOpciones, AsignaturasActivity.this, "");
                    recycler.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<AsignaturasResponse>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Fallo buscando las asignaturas", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void salir() {
        SharedPreferences userpref = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor useredit = userpref.edit();
        useredit.remove("user");
        useredit.commit();

        Intent principal = new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(principal);

        Toast.makeText(this, "Hasta pronto", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void asignaturas() {
        String usuario = getSharedPreferences("datos", Context.MODE_PRIVATE).getString("user", "");
        if(usuario.length() > 0) {
            Intent asignaturas = new Intent(this, AsignaturasActivity.class);
            startActivity(asignaturas);
        }
        else {
            Toast.makeText(this, "Debes iniciar sesión", Toast.LENGTH_SHORT).show();
            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);
        }
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.item1: asignaturas();
                break;
            case R.id.item2: Toast.makeText(this, "Próximamente...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3: salir();
                break;
            default:         Toast.makeText(this, "Opción no tratada", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void buscarAsignatura(View view) {
        Intent nuevaAsignatura = new Intent(this, NuevaAsignaturaActivity.class);
        startActivity(nuevaAsignatura);
    }
}