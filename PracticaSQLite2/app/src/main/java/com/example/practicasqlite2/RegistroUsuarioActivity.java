package com.example.practicasqlite2;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practicasqlite2.utilidades.Utilidades;

public class RegistroUsuarioActivity extends AppCompatActivity {

    private EditText campo_id,campo_nombre,campo_telefono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);



        campo_id=(EditText)findViewById(R.id.id);
        campo_nombre=(EditText)findViewById(R.id.nombre);
        campo_telefono=(EditText)findViewById(R.id.telefono);
    }

    public void Onclick(View view){
        RegistroUsuario();
    }

    public void RegistroUsuario(){
        conexionSQLiteHelper conn = new conexionSQLiteHelper(this,"db_usuarios",null,1);
        SQLiteDatabase db =conn.getWritableDatabase();

        String id = campo_id.getText().toString();
        String nombre=campo_nombre.getText().toString();
        String telefono=campo_telefono.getText().toString();

        if (!id.isEmpty() && !nombre.isEmpty() && !telefono.isEmpty()){
            ContentValues values =new  ContentValues();
            values.put(Utilidades.CAMPO_ID,id);
            values.put(Utilidades.CAMPO_NOMBRE,nombre);
            values.put(Utilidades.CAMPO_TELEFONO,telefono);

            db.insert(Utilidades.TABLA_USUARIO,null,values);
            db.close();
            campo_id.setText("");
            campo_nombre.setText("");
            campo_telefono.setText("");

            Toast.makeText(this,"Registro de Usuarios Exitoso!!",Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this,"Debe llenar todos los campos",Toast.LENGTH_SHORT).show();

        }

    }
}
