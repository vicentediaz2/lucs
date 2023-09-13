package com.example.proyectoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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
