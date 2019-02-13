package com.example.diego.login_map_app;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Registro extends AppCompatActivity {


    EditText edit_nombre, edit_pass, edit_gmail;
    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        edit_nombre = findViewById(R.id.txt_nombre);
        edit_pass = findViewById(R.id.txt_pass);
        edit_gmail = findViewById(R.id.txt_gmail);

        registrar = findViewById(R.id.btn_registrar);

    }

    public void registrar(View view) {

        final String nombre = edit_nombre.getText().toString();
        final String pass = edit_pass.getText().toString();
        final String gmail = edit_gmail.getText().toString();

    if (!nombre.isEmpty() && !pass.isEmpty() && !gmail.isEmpty()){

        Response.Listener<String> responListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    //pregunta si el registro es correcto o no

                    if (success){

                        Intent i = new Intent(Registro.this , login.class);
                        Toast.makeText(Registro.this, "Usuario Registrado", Toast.LENGTH_SHORT).show();
                        startActivity(i);


                    }else {

                        AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
                        builder.setMessage("error registro").setNegativeButton("reintentar",null).create().show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };


        RegisterRequest registerRequest = new RegisterRequest(nombre,pass,gmail,1,responListener);

        RequestQueue queue = Volley.newRequestQueue(Registro.this);
        queue.add(registerRequest);


    }else {
        AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
        builder.setMessage("campos incompletos").setNegativeButton("reintentar",null).create().show();
    }

    }
}
