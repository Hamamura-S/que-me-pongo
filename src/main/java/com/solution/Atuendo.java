package com.solution;

import static java.util.Objects.requireNonNull;

import com.solution.enums.Categoria;

public class Atuendo {

  protected Prenda prendaSuperior;
  protected Prenda prendaInferior;
  protected Prenda calzado;
  protected Prenda accesorio;

  public void setPrendaInf(Prenda prendaInf) {
    requireNonNull(prendaInf, "La prenda inferior no puede ser nula.");
    if (prendaInf.getTipo().categoria != Categoria.PARTE_INFERIOR) {
      throw new RuntimeException("La prenda debe ser de tipo inferior.");
    }
    this.prendaInferior = prendaInf;
  }

  public void setPrendaSup(Prenda prendaSup) {
    requireNonNull(prendaSup, "La prenda superior no puede ser nula.");
    if (prendaSup.getTipo().categoria != Categoria.PARTE_SUPERIOR) {
      throw new RuntimeException("La prenda debe ser de tipo superior.");
    }
    this.prendaSuperior = prendaSup;
  }

  public void setCalzado(Prenda calzado) {
    requireNonNull(calzado, "El calzado no puede ser nulo.");
    if (calzado.getTipo().categoria != Categoria.CALZADO) {
      throw new RuntimeException("La prenda debe ser de tipo calzado.");
    }
    this.calzado = calzado;
  }

  public void setAccesorio(Prenda accesorio) {
    requireNonNull(accesorio, "El accesorio no puede ser nulo.");
    if (accesorio.getTipo().categoria != Categoria.ACCESORIO) {
      throw new RuntimeException("La prenda debe ser de tipo accesorio.");
    }
    this.accesorio = accesorio;
  }

  public Prenda getPrendaInferior() {
    return prendaInferior;
  }

  public Prenda getPrendaSuperior() {
    return prendaSuperior;
  }

  public Prenda getCalzado() {
    return calzado;
  }

  public Prenda getAccesorio() {
    return accesorio;
  }

}

