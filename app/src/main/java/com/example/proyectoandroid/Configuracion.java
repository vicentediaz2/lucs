package com.example.proyectoandroid;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Configuracion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
    }

    //Boton Volver
    public void onClickVolverConfiguracion(View view)
    {
        Intent intent = new Intent(this, VolverConfiguracion.class);
        startActivity(intent);
    }

}
