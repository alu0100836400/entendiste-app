package com.example.entendiste;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterItemOptions extends RecyclerView.Adapter<AdapterItemOptions.ViewHolderOptions> {

    ArrayList<String> listaOpciones;

    public AdapterItemOptions(ArrayList<String> listaOpciones) {
        this.listaOpciones = listaOpciones;
    }

    @NonNull
    @Override
    public AdapterItemOptions.ViewHolderOptions onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterItemOptions.ViewHolderOptions holder, int position) {
        holder.asignarOpciones(listaOpciones.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderOptions extends RecyclerView.ViewHolder {

        TextView opcion;

        public ViewHolderOptions(@NonNull View itemView) {
            super(itemView);
            opcion = itemView.findViewById(R.id.item);
        }

        public void asignarOpciones(String s) {
            opcion.setText(s);
        }
    }
}