package com.hbjpro.pruebatranslator.Logic;

import android.os.AsyncTask;
import android.os.Bundle;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

import java.io.Serializable;

public class Traductor implements Serializable{

    public Traductor(){}

    public class MyAsyncTask extends AsyncTask<String, Language, String>{

        private String text;
        private Language from;
        private Language to;

        public MyAsyncTask(String text, Language from, Language to){
            super();
            this.text = text;
            this.from = from;
            this.to = to;
        }

        @Override
        protected String doInBackground(String... params) {
            Translate.setClientId("appcoder33");
            Translate.setClientSecret("5jvik/fcB3Z68Lj+8M4sdNfu5tUrGZsnrI6ctuyOAaM=");

            try {
                return Translate.execute(text, from, to);
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
    }

}
