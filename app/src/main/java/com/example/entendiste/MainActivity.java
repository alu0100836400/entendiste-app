package com.example.entendiste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


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
        Intent login = new Intent(this, LoginActivity.class);
        //login.putExtra("dato", datoEjemplo.getText().toString()); //así se le pasa un argumento a la otra vista
        startActivity(login);
    }
    public void asignaturas(View view) {
        Intent asignaturas = new Intent(this, AsignaturasActivity.class);
        //login.putExtra("dato", datoEjemplo.getText().toString()); //así se le pasa un argumento a la otra vista
        startActivity(asignaturas);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.item1: Toast.makeText(this, "Opción 1", Toast.LENGTH_SHORT).show();
                            break;
            case R.id.item2: Intent opciones = new Intent(this, OptionsActivity.class);
                            //login.putExtra("dato", datoEjemplo.getText().toString()); //así se le pasa un argumento a la otra vista
                            startActivity(opciones);
                            break;
            case R.id.item3: Toast.makeText(this, "Opción 3", Toast.LENGTH_SHORT).show();
                            break;
            default:         Toast.makeText(this, "¿?¿?", Toast.LENGTH_SHORT).show();
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