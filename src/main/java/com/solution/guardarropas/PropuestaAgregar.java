package com.solution.guardarropas;

import com.solution.prendas.Prenda;

public class PropuestaAgregar implements PropuestaModificacion {
  private final Prenda prenda;
  private final Guardarropas guardarropas;

  public PropuestaAgregar(Prenda prenda, Guardarropas guardarropas) {
    this.prenda = prenda;
    this.guardarropas = guardarropas;
  }

  public void modificarGuardarropas() {
    guardarropas.agregarPrenda(prenda);
  }

  public void revertir() {
    guardarropas.removerPrenda(prenda);
  }

}
