package com.solution;

import com.solution.enums.*;

abstract public class Prenda {

    protected Material material;

    protected Color colorPrimario;

    protected Color colorSecundario;

    public Prenda(Material material, Color colorPrimario){
        this.material=material;
        this.colorPrimario=colorPrimario;
    }

    // SETTERS
    public void setColorSecundario(Color colorSecundario){
        this.colorSecundario=colorSecundario;
    }

    //GETTERS
    public Color getColorSecundario(){return colorSecundario;}

}


