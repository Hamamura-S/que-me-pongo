package com.solution.model.clima;

import com.solution.model.Usuario;
import com.solution.model.enums.AlertaMeteorologica;
import java.math.BigDecimal;
import java.util.List;

public interface ServicioMeteorologico {

  public BigDecimal getTemperatura(String ciudad);

  public BigDecimal getHumedad(String ciudad);

  public EstadoClima getEstadoClima(String ciudad);

  public List<AlertaMeteorologica> getAlertasMeteorologicas(String ciudad);

  public void actualizarAlertas();

  public void subscribe(Usuario usuario);

}
