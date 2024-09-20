package com.solution.model.enums;

public enum AlertaMeteorologica {
  TORMENTA("TORMENTA"),
  SIN_ALERTA("SIN_ALERTA"),
  TORNADO("TORNADO"),
  GRANIZO("GRANIZO"),
  TERREMOTO("TERREMOTO");

  private final String alerta;

  AlertaMeteorologica(String alerta) {
    this.alerta = alerta;
  }

  public String getAlerta() {
    return this.alerta;
  }

  public static AlertaMeteorologica fromString(String alerta) {
    for (AlertaMeteorologica a : AlertaMeteorologica.values()) {
      if (a.getAlerta().equalsIgnoreCase(alerta)) {
        return a;
      }
    }
    return null;
  }
}