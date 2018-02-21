package com.grantour.tour;

import android.widget.Button;

/**
 * Created by Fernando on 19/02/2018.
 */

public class DatosRegistro {

    public  String NombreCompleto, Usuario, Correo, Contra;


    public  DatosRegistro(String nombre, String usuario, String correo, String contra){

        this.NombreCompleto = nombre;
        this.Usuario = usuario;
        this.Correo = correo;
        this.Contra = contra;

    }

    public String getNombreCompleto(){return NombreCompleto;}
    public  void SetNomnbreCompleto(String nombreCompleto){this.NombreCompleto = nombreCompleto;}
    public String getUsuario(){return Usuario;}
    public void setUsuario(String usuario){this.Usuario = usuario;}
    public String getCorreo(){return Correo;}
    public void setCorreo(String correo){this.Correo = correo;}
    public String getContra(){return Contra;}
    public void setContra(String contra){this.Contra = contra;}












}
