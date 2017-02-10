package com.hbjpro.pruebatranslator.Controller;

import android.util.Log;

import com.hbjpro.pruebatranslator.Interfaces.Observador;
import com.hbjpro.pruebatranslator.Model.Modelo;

import java.io.Serializable;

public class Controlador implements Serializable{

    private Modelo modelo;

    public Controlador(Modelo modelo){
        this.modelo = modelo;
    }

    public void addObserver(Observador obs){
        modelo.addObserver(obs);
    }

    public void translateText(String originalText){
        modelo.translateText(originalText);
    }
}
