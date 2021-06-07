package com.example.entendiste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class TemasActivity extends AppCompatActivity {

    private ArrayList<String> listOpciones;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temas);
        recycler = (RecyclerView) findViewById(R.id.rv1);
        recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        listOpciones = new ArrayList<String>();

//        for(int i = 0; i <= 50; i++) {
//            listOpciones.add("Dato # " + i + " ");
//        }
        listOpciones.add("Vectores");
        listOpciones.add("Matrices");
        listOpciones.add("Listas");
        //AdapterItemOptions adapter = new AdapterItemOptions(listOpciones);
        //recycler.setAdapter(adapter);
    }
}