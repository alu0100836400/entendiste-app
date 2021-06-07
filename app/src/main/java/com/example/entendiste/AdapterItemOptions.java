package com.example.entendiste;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterItemOptions extends RecyclerView.Adapter<AdapterItemOptions.ViewHolderOptions> {

    ArrayList<String> listaOpciones;
    AppCompatActivity activity;

    public AdapterItemOptions(ArrayList<String> listaOpciones, AppCompatActivity activity) {
        this.listaOpciones = listaOpciones;
        this.activity = activity;
    }

    @NonNull
    @Override
    public AdapterItemOptions.ViewHolderOptions onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new ViewHolderOptions(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterItemOptions.ViewHolderOptions holder, int position) {
        holder.asignarOpciones(listaOpciones.get(position));
        //holder.opcion.setText();
    }

    @Override
    public int getItemCount() {
        return listaOpciones.size();
    }

    public class ViewHolderOptions extends RecyclerView.ViewHolder {

        ConstraintLayout layout;
        TextView opcion;

        public ViewHolderOptions(@NonNull View itemView) {
            super(itemView);
            layout = (ConstraintLayout) itemView.findViewById(R.id.constraint_item);
            opcion = (TextView) itemView.findViewById(R.id.item);
        }

        public void asignarOpciones(String s) {
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(activity, "clickado", Toast.LENGTH_SHORT).show();
                }
            });
            opcion.setText(s);
        }
    }
}
