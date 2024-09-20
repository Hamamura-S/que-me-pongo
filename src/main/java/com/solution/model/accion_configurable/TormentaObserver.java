package com.solution.model.accion_configurable;

import com.solution.util.comunicacion.Notificador;
import com.solution.model.Usuario;
import com.solution.model.enums.AlertaMeteorologica;
import java.util.List;

public class TormentaObserver implements AccionConfigurable {
  public void nuevasAlertasMeteorologicas(List<AlertaMeteorologica> alertas, Usuario usuario) {
    if (alertas.contains(AlertaMeteorologica.TORMENTA)){
      new Notificador().notificar("Sali con paraguas!", usuario);
    }
  }
}
