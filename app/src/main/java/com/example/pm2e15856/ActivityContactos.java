package com.example.pm2e15856;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pm2e15856.configuracion.SQLiteConexion;
import com.example.pm2e15856.tablas.Contactos;
import com.example.pm2e15856.tablas.Transacciones;

import java.util.ArrayList;;

public class ActivityContactos extends AppCompatActivity {

    SQLiteConexion con;
    ListView listcontac;
    ArrayList<Contactos> listac;
    ArrayList<String> listaconca;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        con = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1 );

        listcontac =(ListView) findViewById(R.id.listcontac1);

        GetListContac();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaconca);
        listcontac.setAdapter(adp);

    }

    private void GetListContac()
    {
        SQLiteDatabase db = con.getReadableDatabase();

        Contactos listcontac = null;

        listac = new ArrayList<Contactos>();

        Cursor cursor = db.rawQuery(Transacciones.GetContactos, null);

        while (cursor.moveToNext())
        {
            listcontac = new Contactos();
            listcontac.setId(cursor.getInt(0));
            listcontac.setPais(cursor.getString(1));
            listcontac.setNombre(cursor.getString(2));
            listcontac.setTelefono(cursor.getString(3));
            listcontac.setNota(cursor.getString(4));

            listac.add(listcontac);
        }

        cursor.close();

        LlenarLista();

    }

    private void LlenarLista()
    {
        listaconca = new ArrayList<String>();

        for(int i=0; i < listac.size(); i++)
        {
            listaconca.add(listac.get(i).getPais() +" - " +
                    listac.get(i).getNombre() +" - " +
                    listac.get(i).getTelefono());
        }
    }
}