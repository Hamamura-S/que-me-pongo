package com.solution;

import static java.util.Objects.requireNonNull;

import com.solution.enums.Categoria;
import com.solution.enums.Material;

public class Prenda {

  protected Material material;

  protected Color colorPrimario;

  protected Color colorSecundario;

  protected TipoPrenda tipo;

  public Prenda(Material material, Color colorPrimario, TipoPrenda tipo) {
    this.material = requireNonNull(material, "Se debe proveer un material de ropa.");
    this.colorPrimario = requireNonNull(colorPrimario, "Se debe proveer un color primario.");
    this.tipo = requireNonNull(tipo, "Se debe proveer un tipo de ropa.");
  }

  // SETTERS
  public void setColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  //GETTERS
  public Color getColorSecundario() {
    return colorSecundario;
  }

  public TipoPrenda getTipo() {
    return tipo;
  }

  public Categoria getCategoria() {
    return tipo.categoria;
  }

}


