package com.example.manuelfigueroa.turismaule;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class LoginActivity extends AppCompatActivity {

    private Button btn_login;
    private EditText txt_user;
    private EditText txt_pass;
    private static Usuario userstatic = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = (Button) findViewById(R.id.btn_login);
        txt_user = (EditText) findViewById(R.id.txt_user);
        txt_pass = (EditText) findViewById(R.id.txt_pass);

    }


    public void ClienteGetUsuarios(String user, String pass) {
        String url = "http://turis.ostrichgroup.cl/restUsuarios";
        AsyncHttpClient client = new AsyncHttpClient();

        RequestParams params = new RequestParams();
        params.put("key", "3F!9#");
        params.put("user", user);
        params.put("pass", pass);

        client.post(url, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    limpiarUsuario(new String(responseBody));
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }

    //para obtener valores del arreglo -> json.getJSONObject(i).getString("id_usuario"));

    public ArrayList<String> getDataJSON(String response) {
        ArrayList<String> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(response);
            String text;
            for (int i = 0; i < jsonArray.length(); i++) {
                text = jsonArray.getJSONObject(i).getString("id_usuario") + " " +
                        jsonArray.getJSONObject(i).getString("password") + " " +
                        jsonArray.getJSONObject(i).getString("nombre") + " " +
                        jsonArray.getJSONObject(i).getString("email") + " " +
                        jsonArray.getJSONObject(i).getString("fecha_nac") + " " +
                        jsonArray.getJSONObject(i).getString("fecha_creacion") + " " +
                        jsonArray.getJSONObject(i).getString("estado") + " ";
                list.add(text);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public void limpiarUsuario(String respuesta) {
        Usuario usuario = new Usuario();

        try {
            JSONArray json = new JSONArray(respuesta);

            usuario.setEmail(json.getJSONObject(0).getString("email"));
            usuario.setEstado(json.getJSONObject(0).getString("estado"));
            usuario.setFecha_creacion(json.getJSONObject(0).getString("fecha_creacion"));
            usuario.setFecha_nac(json.getJSONObject(0).getString("fecha_nac"));
            usuario.setId_usuario(Integer.parseInt(json.getJSONObject(0).getString("id_usuario")));
            usuario.setNombre(json.getJSONObject(0).getString("nombre"));
            usuario.setPassword(json.getJSONObject(0).getString("password"));


        } catch (Exception e) {

        }

        if (usuario.getId_usuario() == 0) {
            Context context = getApplicationContext();
            CharSequence text = "Ta vacioh";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            Context context = getApplicationContext();
            CharSequence text = "Usuario: " + usuario.getNombre();
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }

    public void bt_login_click(View view) {

        String user = txt_user.getText().toString();
        String pass = txt_pass.getText().toString();
        ClienteGetUsuarios(user, pass);

    }
}
