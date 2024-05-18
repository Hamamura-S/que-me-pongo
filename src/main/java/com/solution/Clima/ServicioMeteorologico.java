package com.solution.Clima;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ServicioMeteorologico {

  public BigDecimal getTemperatura(String ciudad);

  public BigDecimal getHumedad(String ciudad);

  public EstadoClima getEstadoClima(String ciudad);

}
