package com.example.proyectoandroid;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

// Menu
public class Menu extends AppCompatActivity {

    @Override
    //Entrada al menu
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    //Boton Perfil
    public void onClickPerfil(View view)
    {
        Intent intent = new Intent(this, Perfil.class);
        startActivity(intent);
    }

    //Boton Configuracion
    public void onClickConfiguracion(View view)
    {
        Intent intent = new Intent(this, Configuracion.class);
        startActivity(intent);

    }

    public void onClickAbout(View view)
    {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }

    //Boton Salida
    public void onClickSalida(View view)
    {
        Intent intent = new Intent(this, Salida.class);
        startActivity(intent);
    }





}
