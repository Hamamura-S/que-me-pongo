package com.solution.model.prendas;

import com.solution.model.enums.Categoria;
import com.solution.model.enums.Material;
import com.solution.model.enums.Trama;

/**
 * Prenda definitiva e inmutable. Se guarda en el guardarropas de un Usuario.
 */
public class Prenda {

  protected TipoPrenda tipo;
  protected Material material;
  protected Color colorPrimario;
  protected Trama trama;
  protected Color colorSecundario;
  protected Formalidad formalidad;
  protected int temperaturaLimite;

  public Prenda(TipoPrenda tipo, Material material, Color colorPrimario, Trama trama, Color colorSecundario, Formalidad formalidad, int temperaturaLimite) {
    this.tipo = tipo;
    this.material = material;
    this.colorPrimario = colorPrimario;
    this.trama = trama;
    this.colorSecundario = colorSecundario;
    this.formalidad = formalidad;
    this.temperaturaLimite = temperaturaLimite;
  }

  //GETTERS

  public String getNombre() {
    return tipo.nombre;
  }

  public TipoPrenda getTipo() {
    return tipo;
  }

  public Categoria getCategoria() {
    return tipo.categoria;
  }

  public Material getMaterial() {
    return material;
  }

  public Color getColorPrimario() {
    return colorPrimario;
  }

  public Color getColorSecundario() {
    return colorSecundario;
  }

  public Trama getTrama() {
    return trama;
  }

  public Formalidad getFormalidad() {
    return formalidad;
  }

  public int getTemperaturaLimite() {
    return temperaturaLimite;
  }

}


