package com.example.proyectoandroid;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.text.BreakIterator;
import java.text.ParseException;

public class Registro extends AppCompatActivity {

    EditText edtnombre,edtid;
    ListView lista;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        edtid = (EditText) findViewById(R.id.edtid);
        edtnombre = (EditText) findViewById(R.id.edtnombre);

        lista = (ListView) findViewById(R.id.lista);
        CargarLista();
    }

    //Agregar
    public void onClickAgregar(View view){
        DataHelper dh = new DataHelper(this,"luces.db",null,1);
        SQLiteDatabase bd = dh.getWritableDatabase();
        ContentValues reg = new ContentValues();
        reg.put("id",edtid.getText().toString());
        reg.put("nombre",edtnombre.getText().toString());
        long resp = bd.insert("luces",null,reg);
        bd.close();

        if (resp==-1){
            Toast.makeText(this, "No se pudo ingresar el registro", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Registro Agregado", Toast.LENGTH_SHORT).show();
        }
        CargarLista();
        Limpiar();

    }

    //Limpiar
    public void Limpiar(){
        edtnombre.setText("");
        edtid.setText("");
    }

    public void CargarLista(){
        DataHelper dh = new DataHelper(this,"luces.db",null,1);
        SQLiteDatabase bd = dh.getReadableDatabase();
        Cursor c = bd.rawQuery("Select id,nombre from luces",null);
        String[] arr = new String[c.getCount()];
        if (c.moveToFirst() == true){
            int i = 0;
            do {
                String linea = "| " + c.getInt(0) + " | " +c.getString(1)+" |";
                arr[i]=linea;
                i++;
            }while (c.moveToNext() == true);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>
                    (this, android.R.layout.simple_expandable_list_item_1,arr);
            lista.setAdapter(adapter);
            bd.close();
        }
    }

    public void onClickEliminar(View view){
        DataHelper dh = new DataHelper(this,"luces.db",null,1);
        SQLiteDatabase bd = dh.getWritableDatabase();
        String bid = edtid.getText().toString();

        long resp = bd.delete("luces","id=" + bid,null);
        bd.close();
        if(resp ==-1){
            Toast.makeText(this, "No se pudo Eliminar",
                    Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Dato Eliminado",
                    Toast.LENGTH_LONG).show();
        }
        CargarLista();
        Limpiar();

    }

    public void onClickModificar(View view){
        DataHelper dh = new DataHelper(this,"luces.db", null,1);
        SQLiteDatabase bd = dh.getWritableDatabase();
        ContentValues reg = new ContentValues();
        reg.put("id",edtid.getText().toString());
        reg.put("nombre", edtnombre.getText().toString());
        long resp = bd.update("luces",reg,"id=?",new String[]{edtid.getText().toString()});
        bd.close();

        if (resp == -1) {
            Toast.makeText(this,"No se pudo modificar el registro", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"Registro Modificado", Toast.LENGTH_LONG).show();
        }
        CargarLista();
        Limpiar();


    }


    public void onClickVolver(View view){
        Intent intent = new Intent(this, Perfil.class);
        startActivity(intent);

    }
}
