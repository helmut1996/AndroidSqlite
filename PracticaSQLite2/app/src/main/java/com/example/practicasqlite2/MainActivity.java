package com.example.practicasqlite2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        conexionSQLiteHelper conn = new conexionSQLiteHelper(this,"db_usuarios",null,1);
    }

    public  void Onclick(View view){
        Intent miIntent=null;

        switch (view.getId()){

            case R.id.btn_Registro:
                miIntent = new Intent(MainActivity.this,RegistroUsuarioActivity.class);
                break;
            case R.id.btn_Consulta:
            miIntent= new Intent(MainActivity.this,ConsultarUsuarioActivity.class);
            break;
        }
        if (miIntent!=null){
            startActivity(miIntent);
        }
    }
}
