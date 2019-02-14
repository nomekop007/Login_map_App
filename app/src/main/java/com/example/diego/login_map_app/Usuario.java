package com.example.diego.login_map_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Usuario extends AppCompatActivity {

    TextView txt_nom, txt_gm ;
    Button ubicacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        ubicacion = findViewById(R.id.ubicame);

        txt_nom = findViewById(R.id.txt_Nombre);
        txt_gm = findViewById(R.id.txt_Gmail);

        //resibiendo los valores del activity login
        Intent i = getIntent();
        String nombre = i.getStringExtra("nombre");
        String gmail = i.getStringExtra("gmail");

        txt_nom.setText(nombre);
        txt_gm.setText(gmail);
    }




    public void ubicame(View view) {

        Intent i = new Intent(Usuario.this, MapsActivity.class);

        Intent e = getIntent();
        String nom = e.getStringExtra("nombre");

        i.putExtra("nombre",nom);

        startActivity(i);




    }
}
