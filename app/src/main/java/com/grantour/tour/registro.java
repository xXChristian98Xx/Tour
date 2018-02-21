package com.grantour.tour;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonToken;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class registro extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener {

    private EditText txtNombreCompleto, txtUsuario, txtCorreo, txtContra;
    private Button btnguardar;
    ProgressDialog progreso;
    RequestQueue request;

    JsonObjectRequest jsonObjectRequest;

    ProgressDialog pd;
    ProgressDialog pd2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtNombreCompleto = (EditText)findViewById(R.id.txtNombreCompleto);
        txtUsuario = (EditText)findViewById(R.id.txtUsuario);
        txtCorreo =(EditText)findViewById(R.id.txtCorreo);
        txtContra =(EditText)findViewById(R.id.txtContrasenia);

        btnguardar = (Button)findViewById(R.id.btnGuardar);

        request = Volley.newRequestQueue(registro.this);

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CargarWebServices();
            }


        });


    }

    private void CargarWebServices() {



        String sAccion = "RegistrarUsuario";
        String sUrl = "http://fhkuku182-001-site1.atempurl.com/Grantour.asmx/";
        String UrlWebService = sUrl + sAccion + "?nombrecompleto=" + txtNombreCompleto.getText().toString()+ "&usuario=" + txtUsuario.getText().toString()+ "&correo=" + txtCorreo.getText().toString()+ "&contrasenia=" + txtContra.getText().toString();
        final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%20";
        String urlEncoded = Uri.encode(UrlWebService, ALLOWED_URI_CHARS);
        urlEncoded.replace(" ", "%20");

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlEncoded, null, this, this);
        request.add(jsonObjectRequest);
    }


    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(),"Se ha registrado correctamente", Toast.LENGTH_SHORT ).show();


        finish();


    }

    @Override
    public void onResponse(JSONObject response) {
        ProcesoEspera();
        txtNombreCompleto.setText("");
        txtUsuario.setText("");
        txtCorreo.setText("");
        txtContra.setText("");



    }

    public void ProcesoEspera(){
        pd = new ProgressDialog(registro.this);
        pd.setTitle("Registro");
        pd.setMessage("Registrando....");
        pd.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                pd.dismiss();
            }

        },3500);




    }


    public void Confirmacion(){
        pd2 = new ProgressDialog(registro.this);
        pd2.setMessage("Registro Exitoso");
        pd2.show();
        Handler handler2 = new Handler();
        handler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                pd2.dismiss();
            }

        },1500);
    }



}









