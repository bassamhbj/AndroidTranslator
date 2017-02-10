package com.hbjpro.pruebatranslator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hbjpro.pruebatranslator.Controller.Controlador;
import com.hbjpro.pruebatranslator.Interfaces.Observador;

public class ViewActivity extends AppCompatActivity implements Observador{

    private Controlador control;

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
    }

    private void transalateText(){
        Button transBut = (Button) findViewById(R.id.translate);
        transBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText fromText = (EditText) findViewById(R.id.textFrom);
                if(!fromText.getText().toString().equals(""))
                    control.translateText(fromText.getText().toString());
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
