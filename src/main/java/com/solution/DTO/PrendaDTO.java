package com.solution.DTO;

import com.solution.model.enums.Material;
import com.solution.model.enums.Trama;
import com.solution.model.prendas.Color;
import com.solution.model.prendas.Formalidad;


public class PrendaDTO {

  private Long id;
  private Long tipoPrendaId;
  private Material material;
  private Trama trama;
  private Color colorPrimario;
  private Color colorSecundario;
  private Formalidad formalidad;
  private int temperaturaLimite;

  public PrendaDTO() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getTipoPrendaId() {
    return tipoPrendaId;
  }

  public void setTipoPrendaId(Long tipoPrendaId) {
    this.tipoPrendaId = tipoPrendaId;
  }

  public Material getMaterial() {
    return material;
  }

  public void setMaterial(Material material) {
    this.material = material;
  }

  public Trama getTrama() {
    return trama;
  }

  public void setTrama(Trama trama) {
    this.trama = trama;
  }

  public Color getColorPrimario() {
    return colorPrimario;
  }

  public void setColorPrimario(Color colorPrimario) {
    this.colorPrimario = colorPrimario;
  }

  public Color getColorSecundario() {
    return colorSecundario;
  }

  public void setColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public Formalidad getFormalidad() {
    return formalidad;
  }

  public void setFormalidad(Formalidad formalidad) {
    this.formalidad = formalidad;
  }

  public int getTemperaturaLimite() {
    return temperaturaLimite;
  }

  public void setTemperaturaLimite(int temperaturaLimite) {
    this.temperaturaLimite = temperaturaLimite;
  }

}
