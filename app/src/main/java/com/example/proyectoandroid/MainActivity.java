package com.example.proyectoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Boton Ingresar Menu
    public void onClickIngresarMenu(View view)
    {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }





}