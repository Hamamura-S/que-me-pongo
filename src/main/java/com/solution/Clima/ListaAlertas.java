package com.solution.Clima;

import com.solution.enums.AlertaMeteorologica;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaAlertas {
  Map<String, List<AlertaMeteorologica>> alertasActuales = new HashMap<>();

  public List<AlertaMeteorologica> getAlertasActuales(String ciudad) {
    return alertasActuales.get(ciudad);
  }

  public void actualizarAlertas(String ciudad, List<AlertaMeteorologica> alertas) {
    if (alertasActuales.get(ciudad) == null) {
      alertasActuales.put(ciudad, alertas);
    } else {
      alertasActuales.get(ciudad).addAll(alertas);
    }
  }

}
