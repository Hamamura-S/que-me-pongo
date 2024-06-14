package com.solution;

import com.solution.comunicacion.Notificador;
import com.solution.enums.AlertaMeteorologica;
import java.util.List;

class GranizoObserver implements AccionConfigurable {
  public void nuevasAlertasMeteorologicas(List<AlertaMeteorologica> alertas, Usuario usuario) {
    if (alertas.contains(AlertaMeteorologica.GRANIZO)){
      new Notificador().notificar("No salgas en auto!", usuario);
    }
  }
}