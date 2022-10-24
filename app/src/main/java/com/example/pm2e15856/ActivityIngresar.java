package com.example.pm2e15856;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pm2e15856.configuracion.SQLiteConexion;
import com.example.pm2e15856.databinding.ActivityContactosBinding;
import com.example.pm2e15856.tablas.Transacciones;

public class ActivityIngresar extends AppCompatActivity {
    Button btnguardar, btncontac;
    EditText nombre, telefono, nota, pais;

    private void config()
    {
        pais = (EditText) findViewById(R.id.txtpais);
        nombre = (EditText) findViewById(R.id.txtnombre);
        telefono = (EditText) findViewById(R.id.txttelefono);
        nota = (EditText) findViewById(R.id.txtnota);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);
        config();

        btnguardar =(Button) findViewById(R.id.btnguardar);
        btncontac = (Button) findViewById(R.id.btncontact);

        btncontac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarContacto();
            }
        });

        btncontac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityContactos.class);
                startActivity(intent);
            }
        });


    }

    private void AgregarContacto()
    {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Transacciones.pais, pais.getText().toString());
        valores.put(Transacciones.nombre, nombre.getText().toString());
        valores.put(Transacciones.telefono, telefono.getText().toString());
        valores.put(Transacciones.nota, nota.getText().toString());

        Long resultados = db.insert(Transacciones.TbContactos, Transacciones.id, valores);

        Toast.makeText(getApplicationContext(),  "Cotacto Guardado" + resultados.toString()
                , Toast.LENGTH_SHORT).show();

        db.close();

        ClearScreen();
    }

    private void ClearScreen()
    {
        pais.setText("");
        nombre.setText("");
        telefono.setText("");
        nota.setText("");
    }
}