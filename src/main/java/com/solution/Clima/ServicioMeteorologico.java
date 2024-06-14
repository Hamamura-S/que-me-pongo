package com.solution.Clima;

import com.solution.Usuario;
import com.solution.enums.AlertaMeteorologica;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ServicioMeteorologico {

  public BigDecimal getTemperatura(String ciudad);

  public BigDecimal getHumedad(String ciudad);

  public EstadoClima getEstadoClima(String ciudad);

  public List<AlertaMeteorologica> getAlertasMeteorologicas(String ciudad);

  public void actualizarAlertas();

  public void subscribe(Usuario usuario);

}
