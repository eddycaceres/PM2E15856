package com.example.pm2e15856.configuracion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pm2e15856.tablas.Transacciones;

public class SQLiteConexion extends SQLiteOpenHelper
{
    public SQLiteConexion (Context context,
                           String dbname,
                           SQLiteDatabase.CursorFactory factory,
                           int version)
    {
        super(context, dbname, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
       db.execSQL(Transacciones.CTContactos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        db.execSQL(Transacciones.DropTContactos);
        onCreate(db);
    }
}
