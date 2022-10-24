package com.example.pm2e15856.tablas;

public class Transacciones
{
    public static final String NameDatabase = "PME15956";

    public static final String TbContactos = "contactos";

    public static final String id = "id";
    public static final String pais = "pais";
    public static final String nombre = "nombre";
    public static final String telefono = "telefono";
    public static final String nota = "nota";

    public static final String CTContactos = "CREATE TABLE contactos (id INTEGER PRIMARY KEY AUTOINCREMENT, "+
            "pais TEXT, nombre TEXT, telefono TEXT, nota TEXT)";

    public static final String GetContactos = "SELECT * FROM " ;

    public static final String DropTContactos = "DROP TABLE IF EXISTS contactos" + Transacciones.TbContactos;
}
