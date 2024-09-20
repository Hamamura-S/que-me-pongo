package com.solution.util.motorSugerencias;

import com.solution.model.atuendos.Sugerencia;
import com.solution.model.prendas.Prenda;
import java.util.List;

public class MotorSugerenciasNormal extends MotorSugerencias {
  @Override
  public List<Sugerencia> generarSugerencias(List<Prenda> guardarropas, int edad) {
    return super.generarSugerencias(guardarropas, edad);
  }
}





