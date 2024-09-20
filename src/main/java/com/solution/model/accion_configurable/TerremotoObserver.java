package com.solution.model.accion_configurable;

import com.solution.util.comunicacion.Notificador;
import com.solution.model.Usuario;
import com.solution.model.enums.AlertaMeteorologica;
import java.util.List;

public class TerremotoObserver {
  public void nuevasAlertasMeteorologicas(List<AlertaMeteorologica> alertas, Usuario usuario) {
    if (alertas.contains(AlertaMeteorologica.TERREMOTO)){
      new Notificador().notificar("Corre por tu vida!", usuario);
    }
  }
}


