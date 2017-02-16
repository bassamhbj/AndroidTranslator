package com.hbjpro.pruebatranslator;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.hbjpro.pruebatranslator.Controller.Controlador;
import com.hbjpro.pruebatranslator.Interfaces.Observador;
import com.memetix.mst.language.Language;


public class ViewFragment extends Fragment implements Observador {

    private Controlador control;
    private View root;
    private Spinner fromS, toS;
    private String[] lang;
    private Language[] langValue;

    public ViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_view, container, false);

        initElem();

        translateText();

        return root;
    }

    private void initElem(){
        Bundle bundle = getArguments();

        if(bundle != null){
            control = (Controlador) bundle.getSerializable("control");
        }

        control.addObserver(this);

        fromS = (Spinner) root.findViewById(R.id.from);
        toS = (Spinner) root.findViewById(R.id.to);

        setSpinnerAdapt();
    }

    private void setSpinnerAdapt(){
        lang = new String[]{"Spanish", "English", "日本語", "中文"};
        langValue = new Language[]{Language.SPANISH, Language.ENGLISH, Language.JAPANESE, Language.CHINESE_SIMPLIFIED};

        ArrayAdapter adapt = new ArrayAdapter(getActivity().getApplicationContext(), R.layout.spinner_item);
        adapt.addAll(lang);
        fromS.setAdapter(adapt);
        toS.setAdapter(adapt);
    }

    private void translateText(){
        Button transBut = (Button) root.findViewById(R.id.translate);
        transBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText fromText = (EditText) root.findViewById(R.id.textFrom);
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
        TextView transalatedT = (TextView) root.findViewById(R.id.textTo);
        transalatedT.setText(finalText);
    }
}
