package com.solution.Clima;

import java.math.BigDecimal;

public class EstadoClima {

  private final BigDecimal temperatura;
  private final BigDecimal humedad;

  public EstadoClima(BigDecimal temperatura, BigDecimal humedad) {
    this.temperatura = temperatura;
    this.humedad = humedad;
  }

  public BigDecimal getHumedad() {
    return humedad;
  }

  public BigDecimal getTemperatura() {
    return temperatura;
  }

}
