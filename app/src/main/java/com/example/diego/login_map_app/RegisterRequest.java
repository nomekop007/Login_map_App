package com.example.diego.login_map_app;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {


    private static final String REGISTER_REQUEST_URL="http://192.168.18.128/Register.php";
    private Map<String,String> params;

    public RegisterRequest(String nombre, String pass, String gmail,int ubicacion, Response.Listener<String> listener){
        super(Method.POST,REGISTER_REQUEST_URL,listener,null);
        params=new HashMap<>();
        params.put("nombre",nombre);
        params.put("pass",pass);
        params.put("gmail",gmail);
        params.put("ubicacion",ubicacion+"");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
