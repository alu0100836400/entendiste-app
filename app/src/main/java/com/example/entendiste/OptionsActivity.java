package com.example.entendiste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class OptionsActivity extends AppCompatActivity {

    private ArrayList<String> listOpciones;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        recycler = (RecyclerView) findViewById(R.id.rv1);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        listOpciones = new ArrayList<String>();

//        for(int i = 0; i <= 50; i++) {
//            listOpciones.add("Dato # " + i + " ");
//        }
        listOpciones.add("Ajustes de pantalla");
        listOpciones.add("Preferencias");
        listOpciones.add("Cuenta");
        listOpciones.add("Cerrar sesión");
        AdapterItemOptions adapter = new AdapterItemOptions(listOpciones);
        recycler.setAdapter(adapter);
    }
}