package com.solution.atuendos;

import com.solution.prendas.Prenda;

public class Uniforme extends Atuendo {

  public final String colegio;

  public Uniforme(String colegio, Prenda prendaSup, Prenda prendaInf, Prenda calzado) {
    this.colegio = colegio;
    setPrendaInf(prendaInf);
    setPrendaSup(prendaSup);
    setCalzado(calzado);
  }

}

