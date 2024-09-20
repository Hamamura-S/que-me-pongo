package com.solution.model.accion_configurable;

import com.solution.model.Usuario;
import com.solution.model.enums.AlertaMeteorologica;
import java.util.List;

public interface AccionConfigurable {
  public void nuevasAlertasMeteorologicas(List<AlertaMeteorologica> alertas, Usuario usuario);
}
