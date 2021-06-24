package com.example.entendiste;

import android.content.DialogInterface;
import android.content.Intent;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.entendiste.io.response.AsignaturasResponse;

import java.util.ArrayList;

public class AdapterItemOptions extends RecyclerView.Adapter<AdapterItemOptions.ViewHolderOptions> {

    ArrayList<AsignaturasResponse> listaOpciones;
    AppCompatActivity activity;
    private String password;

    public AdapterItemOptions(ArrayList<AsignaturasResponse> listaOpciones, AppCompatActivity activity) {
        this.listaOpciones = listaOpciones;
        //for(int i = 0; i < 30; i++) this.listaOpciones.add(listaOpciones.get(0)); // por si necesito una lista larga de asignaturas
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

        public void asignarOpciones(AsignaturasResponse s) {
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(activity instanceof NuevaAsignaturaActivity) {
                        AlertDialog.Builder pedirPassword = new AlertDialog.Builder(activity);
                        pedirPassword.setTitle("Contraseña");
                        final EditText et_password = new EditText(activity);
                        et_password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        pedirPassword.setView(et_password);

                        pedirPassword.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                password = et_password.getText().toString();
                                Toast.makeText(activity, password, Toast.LENGTH_SHORT).show();
                                //comprobar contraseña, agregar a mis asignaturas y entrar en la asignatura
                                s.getPassword(); //la api aun no me manda el password, arreglar eso
                            }
                        });

                        pedirPassword.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        pedirPassword.show();
                    }
                    else {
                        Intent temas = new Intent(activity, TemasActivity.class);
                        temas.putExtra("idAsignatura", s.getId());
                        activity.startActivity(temas);
                        //Toast.makeText(activity, "clickado", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            opcion.setText(s.getNombre());
        }
    }
}
