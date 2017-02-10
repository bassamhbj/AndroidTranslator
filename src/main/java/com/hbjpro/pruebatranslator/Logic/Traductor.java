package com.hbjpro.pruebatranslator.Logic;

import android.os.AsyncTask;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

import java.io.Serializable;

public class Traductor implements Serializable{

    public Traductor(){}

    public class MyAsyncTask extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... originalText) {

            Translate.setClientId("microsoft translate api client id");
            Translate.setClientSecret("microsoft translate api secret key");

            try {
                return Translate.execute(originalText[0], Language.SPANISH, Language.ENGLISH);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
    }
}
