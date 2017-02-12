package com.hbjpro.pruebatranslator.Model;

import com.hbjpro.pruebatranslator.Interfaces.Observador;
import com.hbjpro.pruebatranslator.Logic.Traductor;
import com.memetix.mst.language.Language;

import java.io.Serializable;

public class Modelo implements Serializable {

    private Observador obs;
    private Traductor trad;

    public Modelo (){
        trad = new Traductor();
    }

    public void addObserver(Observador obs){
        this.obs = obs;
    }

    public void translateText(String originalText, Language from, Language to){
        trad.new MyAsyncTask(originalText, from, to){
            @Override
            protected void onPostExecute(String s) {
                obs.onTextTransalted(s);
            }
        }.execute();
    }
}
