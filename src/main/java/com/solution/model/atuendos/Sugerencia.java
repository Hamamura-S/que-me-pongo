package com.solution.model.atuendos;

import com.solution.model.prendas.Prenda;

/**
 * Atuendo que se genera en base al guardarropas del usuario.
 */
public class Sugerencia extends Atuendo {
  
  public Sugerencia(Prenda prendaSup, Prenda prendaInf, Prenda calzado) {
    setPrendaInf(prendaInf);
    setPrendaSup(prendaSup);
    setCalzado(calzado);
  }
  
}
