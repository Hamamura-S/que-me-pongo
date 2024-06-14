package com.solution.enums;

public enum AlertaMeteorologica {
  STORM("STORM"),
  HAIL("HAIL"),
  SIN_ALERTA("SIN_ALERTA");

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