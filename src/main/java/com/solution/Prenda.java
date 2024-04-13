package com.solution;

import static java.util.Objects.requireNonNull;

import com.solution.enums.Categoria;
import com.solution.enums.Material;
import com.solution.enums.Trama;

public class Prenda {

  protected TipoPrenda tipo;

  // Estilo
  protected Material material; //debera inicializarse manualmente

  protected Color colorPrimario; //debera inicializarse manualmente

  protected Trama trama = Trama.LISA;

  protected Color colorSecundario;

  public Prenda(TipoPrenda tipo) {
    this.tipo = requireNonNull(tipo, "Se debe proveer un tipo de ropa.");
  }

  public void setMaterialSeguro(Material unMaterial) {
    if (!(tipo.puedeEstarHechoDe(unMaterial))) {
      throw new RuntimeException("Este tipo de prenda no admite el material " + unMaterial.name());
    }
    setMaterial(unMaterial);
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

  //SETTERS
  private void setMaterial(Material unMaterial) {
    this.material = unMaterial;
  }

  public void setColorPrimario(Color colorPrimario) {
    this.colorPrimario = colorPrimario;
  }

  public void setColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public void setTrama(Trama unaTrama) {
    this.trama = unaTrama;
  }

}


