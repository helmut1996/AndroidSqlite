package com.example.practicasqlite2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practicasqlite2.utilidades.Utilidades;

public class ConsultarUsuarioActivity extends AppCompatActivity {


    private EditText campo_id, campo_nombre, campo_telefono;

    conexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuario);


        conn=new conexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);
        campo_id = (EditText) findViewById(R.id.id);
        campo_nombre = (EditText) findViewById(R.id.nombre);
        campo_telefono = (EditText) findViewById(R.id.telefono);
    }


    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnConsultar:
                consultar();
                break;
            case R.id.btn_editar:
                actualizarUsuario();
                break;
            case R.id.btn_eliminar:
                eliminarUsuario();
                break;
        }

    }

    private void eliminarUsuario() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campo_id.getText().toString()};

        db.delete(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se Eliminó el usuario",Toast.LENGTH_LONG).show();
        campo_id.setText("");
        limpiar();
        db.close();
    }

    private void actualizarUsuario() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campo_id.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,campo_nombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,campo_telefono.getText().toString());

        db.update(Utilidades.TABLA_USUARIO,values,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se actualizó el usuario",Toast.LENGTH_LONG).show();
        db.close();

    }

    private void consultar() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campo_id.getText().toString()};
        String[] campos={Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_TELEFONO};

        try {
            Cursor cursor =db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.CAMPO_ID+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            campo_nombre.setText(cursor.getString(0));
            campo_telefono.setText(cursor.getString(1));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_LONG).show();
            limpiar();
        }


    }

    private void limpiar() {
        campo_nombre.setText("");
        campo_telefono.setText("");
    }

}

