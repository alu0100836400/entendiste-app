package com.example.entendiste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AsignaturasActivity extends AppCompatActivity {

    private ArrayList<String> listOpciones;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);
        recycler = (RecyclerView) findViewById(R.id.rv1);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        listOpciones = new ArrayList<String>();

//        for(int i = 0; i <= 50; i++) {
//            listOpciones.add("Dato # " + i + " ");
//        }
        listOpciones.add("AEDA");
        listOpciones.add("CyA");
        listOpciones.add("Principios de computadores");
        listOpciones.add("IA");
        AdapterItemOptions adapter = new AdapterItemOptions(listOpciones, this);
        recycler.setAdapter(adapter);
    }
}