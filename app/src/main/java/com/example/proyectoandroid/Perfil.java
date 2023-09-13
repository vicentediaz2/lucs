package com.example.proyectoandroid;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Perfil extends AppCompatActivity {
    @Override
    //Ir a Perfil
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    }

    //Boton Volver
    public void onClickVolverPerfil(View view)
    {
        Intent intent = new Intent(this, VolverPerfil.class);
        startActivity(intent);
    }



}
