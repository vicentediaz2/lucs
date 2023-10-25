package com.example.proyectoandroid;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Perfil extends AppCompatActivity {
    @Override
    //Ir a Perfil
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    }

    public void onClickRegistro(View view) {
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);

    }
    //Boton Volver
    public void onClickVolver(View view)
    {
        Intent intent = new Intent(this, VolverAbout.class);
        startActivity(intent);
    }



}
