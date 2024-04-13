package com.solution;

import java.util.List;

public class Atuendo {

  private List<Prenda> prendas;

  //GETTERS

  public List<Prenda> getPrendas() {
    return prendas;
  }

  /*---------------------------*/

  public void agregarPrenda(Prenda unaPrenda){
    prendas.add(unaPrenda);
  }

}
