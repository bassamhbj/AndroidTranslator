package com.hbjpro.pruebatranslator;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hbjpro.pruebatranslator.Controller.Controlador;
import com.hbjpro.pruebatranslator.Model.Modelo;
import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initProgram();
    }

    private void initProgram(){
        Modelo model = new Modelo();
        Controlador control = new Controlador(model);
        Intent i = new Intent(getApplicationContext(), ViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("control", control);
        i.putExtra("bundle", bundle);
        startActivity(i);
    }
}
