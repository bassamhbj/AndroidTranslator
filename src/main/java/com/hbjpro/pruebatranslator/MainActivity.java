package com.hbjpro.pruebatranslator;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hbjpro.pruebatranslator.Controller.Controlador;
import com.hbjpro.pruebatranslator.Model.Modelo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        FragmentManager frm = getFragmentManager();
        FragmentTransaction frt = frm.beginTransaction();

        Modelo model = new Modelo();
        Controlador control = new Controlador(model);

        Bundle bundle = new Bundle();
        bundle.putSerializable("control", control);

        ViewFragment viewF = new ViewFragment();
        viewF.setArguments(bundle);

        frt.replace(R.id.container, viewF);
        frt.commit();
    }
}
