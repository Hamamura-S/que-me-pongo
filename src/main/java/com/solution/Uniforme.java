package com.solution;

public class Uniforme extends Atuendo {

  public final String colegio;

  Prenda prendaSup, prendaInf, calzado;
  
  public Uniforme(String colegio, TipoPrenda tipoSuperior, TipoPrenda tipoInferior, TipoPrenda tipoCalzado) {
    prendaSup = new Prenda(tipoSuperior);
    prendaInf = new Prenda(tipoInferior);
    calzado = new Prenda(tipoCalzado);
    this.colegio = colegio;
  }

}
