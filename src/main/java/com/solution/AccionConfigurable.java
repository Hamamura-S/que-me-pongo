package com.solution;

import com.solution.enums.AlertaMeteorologica;
import java.util.List;

public interface AccionConfigurable {
  public void nuevasAlertasMeteorologicas(List<AlertaMeteorologica> alertas, Usuario usuario);
}
