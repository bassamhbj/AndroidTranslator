package com.hbjpro.pruebatranslator.Model;

import com.hbjpro.pruebatranslator.Interfaces.Observador;
import com.hbjpro.pruebatranslator.Logic.Traductor;

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

    public void translateText(String originalText){
        trad.new MyAsyncTask(){
            @Override
            protected void onPostExecute(String s) {
                obs.onTextTransalted(s);
            }
        }.execute(originalText);
    }
}
