package com.example.diego.login_map_app;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    private static final String LOGIN_REQUEST_URL="https://diego-rios.000webhostapp.com/login_mapa/Login.php";
    private Map<String,String> params;

    public LoginRequest(String nombre, String pass, Response.Listener<String> listener){
        super(Request.Method.POST,LOGIN_REQUEST_URL,listener,null);
        params=new HashMap<>();
        params.put("nombre",nombre);
        params.put("pass",pass);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
