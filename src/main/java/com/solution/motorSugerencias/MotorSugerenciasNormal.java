package com.solution.motorSugerencias;

import com.solution.atuendos.Sugerencia;
import com.solution.prendas.Prenda;
import java.util.List;

public class MotorSugerenciasNormal extends MotorSugerencias {
  @Override
  public List<Sugerencia> generarSugerencias(List<Prenda> guardarropas, int edad) {
    return super.generarSugerencias(guardarropas, edad);
  }
}





