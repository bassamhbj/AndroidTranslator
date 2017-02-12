package com.hbjpro.pruebatranslator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.hbjpro.pruebatranslator.Controller.Controlador;
import com.hbjpro.pruebatranslator.Interfaces.Observador;
import com.memetix.mst.language.Language;

import java.io.LineNumberReader;

public class ViewActivity extends AppCompatActivity implements Observador{

    private Controlador control;
    private Spinner fromS, toS;
    private String[] lang;
    private Language[] langValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        initElem();

        transalateText();
    }

    private void initElem(){
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        if(bundle != null){
            this.control = (Controlador) bundle.getSerializable("control");
        }

        control.addObserver(ViewActivity.this);

        fromS = (Spinner) findViewById(R.id.from);
        toS = (Spinner) findViewById(R.id.to);

        setSpinnerAdapt();
    }

    private void setSpinnerAdapt(){
        lang = new String[]{"Spanish", "English", "日本語", "中文"};
        langValue = new Language[]{Language.SPANISH, Language.ENGLISH, Language.JAPANESE, Language.CHINESE_SIMPLIFIED};

        ArrayAdapter adapt = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item);
        adapt.addAll(lang);
        fromS.setAdapter(adapt);
        toS.setAdapter(adapt);
    }

    private void transalateText(){
        Button transBut = (Button) findViewById(R.id.translate);
        transBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText fromText = (EditText) findViewById(R.id.textFrom);
                if(!fromText.getText().toString().equals("")) {
                    Language fromL = langValue[fromS.getSelectedItemPosition()];
                    Language toL = langValue[toS.getSelectedItemPosition()];
                    control.translateText(fromText.getText().toString(), fromL, toL);
                }
            }
        });
    }

    @Override
    public void onTextTransalted(String finalText) {
        Log.i("test", "view " + finalText);
        TextView transalatedT = (TextView) findViewById(R.id.textTo);
        transalatedT.setText(finalText);
    }
}
