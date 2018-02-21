package com.grantour.tour;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class Login extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {

    private final int LOCATION_REQUEST_CODE =2;
    private final int CAMERA_REQUEST_CODE =3;
    private final int EXTERNAL_REQUEST_CODE =4;
    EditText txtuser, txtcontra;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        askPermission(Manifest.permission.CAMERA, CAMERA_REQUEST_CODE);
        txtuser= (EditText) findViewById(R.id.txtUser);
        txtcontra = (EditText) findViewById(R.id.txtCon);
        Button btniniciar = (Button) findViewById(R.id.btnIniciarSesion);
        request = Volley.newRequestQueue(getApplicationContext());

            btniniciar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {




                    Intent intent = new Intent(view.getContext(), menu.class);
                    startActivityForResult(intent, 0);

                    askPermission(Manifest.permission.ACCESS_FINE_LOCATION, LOCATION_REQUEST_CODE);
                    askPermission(Manifest.permission.READ_EXTERNAL_STORAGE, EXTERNAL_REQUEST_CODE);
                }
            });






        Button btnleer = (Button) findViewById(R.id.btnLeermas);
        btnleer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), info.class);
                startActivityForResult(intent, 0);
            }
        });

        Button btnregistrarse = (Button) findViewById(R.id.btnRegistro);
        btnregistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), registro.class);
                startActivityForResult(intent, 0);
            }
        });





    }


    public  void CargarWebServices(){

        String sAccion = "IniciarSesion";
        String sUrl = "http://fhkuku182-001-site1.atempurl.com/Grantour.asmx/";
        String UrlWebService = sUrl + sAccion + "?us=" + txtuser.getText().toString()+ "&contra=" + txtcontra.getText().toString();
        final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%20";
        String urlEncoded = Uri.encode(UrlWebService, ALLOWED_URI_CHARS);
        urlEncoded.replace(" ", "%20");

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, urlEncoded,null,this,this);
        request.add(jsonObjectRequest);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(),"Datos: "+error.toString(), Toast.LENGTH_SHORT ).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getApplicationContext(),"Datos: "+response.toString(), Toast.LENGTH_SHORT ).show();
    }

    private  void askPermission(String permission, int request){
        if (ContextCompat.checkSelfPermission(this, permission)!= PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this, new String[]{permission},request);
        }else {


        }
    }

    public  void onRequestPermissionsResult(int requestcode, @NonNull String[] permissions, @NonNull int[] grantresults){
        switch (requestcode){
            case LOCATION_REQUEST_CODE:
                if (grantresults.length>0&&grantresults[0]==PackageManager.PERMISSION_GRANTED){


                }else {


                }
                break;
            case CAMERA_REQUEST_CODE:
                if (grantresults.length>0&&grantresults[0]==PackageManager.PERMISSION_GRANTED){


                }else {


                }
            break;


        }

    }



}
