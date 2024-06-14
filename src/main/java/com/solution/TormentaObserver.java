package com.solution;

import com.solution.comunicacion.Notificador;
import com.solution.enums.AlertaMeteorologica;
import java.util.List;

public class TormentaObserver implements AccionConfigurable {
  public void nuevasAlertasMeteorologicas(List<AlertaMeteorologica> alertas, Usuario usuario) {
    if (alertas.contains(AlertaMeteorologica.TORMENTA)){
      new Notificador().notificar("Sali con paraguas!", usuario);
    }
  }
}
