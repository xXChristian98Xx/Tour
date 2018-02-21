package com.grantour.tour;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fernando on 20/02/2018.
 */

public class Adaptador extends ArrayAdapter {
    List list = new ArrayList();
    public Adaptador(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public void Add(DatosRegistro objec){
        super.add(objec);
        list.add(objec);

    }




}
