package com.example.practicasqlite2.utilidades;

public class Utilidades {
    public static final String TABLA_USUARIO="usuarios";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_TELEFONO="usuarios";


  public static final String CREAR_TABLA_USUARIO="CREATE TABLE "+TABLA_USUARIO+" ("+CAMPO_ID+" INTEGER, "+CAMPO_NOMBRE+" TEXT, "+CAMPO_TELEFONO+" TEXT)";
}
