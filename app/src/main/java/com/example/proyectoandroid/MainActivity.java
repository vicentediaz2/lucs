package com.example.proyectoandroid;

import android.content.Intent;

import android.os.AsyncTask;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //*//Declarar variables

    TextView textView1;
    ImageView imageView1;
    EditText Usuario, Passw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //*// Unimos las variables con su ID del XML
        Usuario = (EditText) findViewById(R.id.edtUsuario);
        Passw = (EditText) findViewById(R.id.edtPassw);

        textView1 = findViewById(R.id.textView1);
        imageView1 = findViewById(R.id.imageView1);

        MyAsyncTask asyncTask = new MyAsyncTask();
        asyncTask.execute();
    }

    public class MyAsyncTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "LUCS";
        }
        @Override
        protected void onPostExecute(String result){
            textView1.setText(result);
            imageView1.setVisibility(ImageView.VISIBLE);
        }
    }


    //Boton Ingresar Menu
    public void onClickIngresarMenu(View view)
    {

        String username = Usuario.getText().toString().trim();
        String passw = Passw.getText().toString().trim();

        if (username.equals("")) {
            Toast.makeText(this,"Ingrese el Usuario", Toast.LENGTH_LONG).show();
            return;
        }
        if (passw.equals("")) {
            Toast.makeText(this,"Ingrese la Contraseña", Toast.LENGTH_LONG).show();
            return;
        }

        if (username.equals("Admin") && passw.equals("1234")) {

            Intent intent = new Intent(this, Menu.class);
            startActivity(intent);
            Toast.makeText(this,"Inicio de session exitosa", Toast.LENGTH_LONG).show();
            return;
        }else{
            Toast.makeText(this,"Credenciales incorrectas", Toast.LENGTH_LONG).show();
        }
    }
}