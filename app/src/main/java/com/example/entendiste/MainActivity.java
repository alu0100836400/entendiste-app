package com.example.entendiste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.entendiste.model.Asignatura;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //datoEjemplo = (EditText) findViewById(R.id.editUserLogin);
        //las 2 siguientes lineas ponen el icono de la app al lado del nombre
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    public void Login(View view) {
        String usuario = getSharedPreferences("datos", Context.MODE_PRIVATE).getString("user", "");
        if(usuario.equals("")) {
            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);
        }
        else {
            Toast.makeText(this, "Hola " + usuario, Toast.LENGTH_SHORT).show();
            Intent asignaturas = new Intent(this, AsignaturasActivity.class);
            startActivity(asignaturas);
        }
    }

    public void salir() {
        SharedPreferences userpref = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor useredit = userpref.edit();
        useredit.remove("user");
        useredit.commit();

        Intent principal = new Intent(this, MainActivity.class);
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

/*
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de hacerse visible.
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
        // Enfocarse en otra actividad  (esta actividad está a punto de ser "detenida").
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
        // La actividad ya no es visible (ahora está "detenida")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de ser destruida.
    }
    */

}