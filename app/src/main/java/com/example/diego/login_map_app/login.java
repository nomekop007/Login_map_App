package com.example.diego.login_map_app;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class login extends AppCompatActivity {


    TextView txt_registar;

    EditText t_usuario, t_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_registar = (TextView) findViewById(R.id.txt_registrar);

        t_usuario = findViewById(R.id.txt_usuario);
        t_pass = findViewById(R.id.txt_pass);

    }



    public void registrar(View view) {
        Intent i = new Intent(this, Registro.class);
        startActivity(i);
    }

    public void login(View view) {

        final String nombre = t_usuario.getText().toString();
        final String pass = t_pass.getText().toString();


             //crear el escuchador para enviarselo al loginRequest
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success){ //pregunta si no hay error

                        //extraer los datos del json
                        String nombre = jsonResponse.getString("nombre");
                        String gmail = jsonResponse.getString("gmail");

                        Intent intent = new Intent(login.this , Usuario.class);
                        //enviar los datos al activity usuario
                        intent.putExtra("nombre",nombre);
                        intent.putExtra("gmail",gmail);

                        startActivity(intent);


                    }else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
                        builder.setMessage("nombre o contraseña incorrecta").setNegativeButton("reintentar",null).create().show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };



        LoginRequest loginRequest = new LoginRequest(nombre,pass,responseListener);

        RequestQueue queue = Volley.newRequestQueue(login.this);
        queue.add(loginRequest);
    }
}
