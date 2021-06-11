package com.example.entendiste;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.entendiste.io.response.TemasResponse;

import java.util.ArrayList;

public class AdapterItemTemas  extends RecyclerView.Adapter<AdapterItemTemas.ViewHolderTemas>{

    ArrayList<TemasResponse> listaOpciones;
    AppCompatActivity activity;

    public AdapterItemTemas(ArrayList<TemasResponse> listaOpciones, AppCompatActivity activity) {
        this.listaOpciones = listaOpciones;
        this.activity = activity;
    }

    @NonNull
    @Override
    public AdapterItemTemas.ViewHolderTemas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return new AdapterItemTemas.ViewHolderTemas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterItemTemas.ViewHolderTemas holder, int position) {
        holder.asignarOpciones(listaOpciones.get(position));
    }

    @Override
    public int getItemCount() {
        return listaOpciones.size();
    }
    public class ViewHolderTemas extends RecyclerView.ViewHolder {

        ConstraintLayout layout;
        TextView opcion;

        public ViewHolderTemas(@NonNull View itemView) {
            super(itemView);
            layout = (ConstraintLayout) itemView.findViewById(R.id.constraint_item);
            opcion = (TextView) itemView.findViewById(R.id.item);
        }

        public void asignarOpciones(TemasResponse s) {
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent asignaturas = new Intent(activity, TemasActivity.class);
                    activity.startActivity(asignaturas);
                    Toast.makeText(activity, "clickado", Toast.LENGTH_SHORT).show();
                }
            });
            opcion.setText(s.getPregunta());
        }
    }
}
