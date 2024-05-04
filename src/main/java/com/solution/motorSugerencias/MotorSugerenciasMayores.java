package com.solution.motorSugerencias;

import com.solution.atuendos.Sugerencia;
import com.solution.prendas.Prenda;
import java.util.List;

public class MotorSugerenciasMayores extends MotorSugerencias {
  @Override
  public List<Sugerencia> generarSugerencias(List<Prenda> guardarropas) {
    //filtrar ropa formal del guardarropas.
    return super.generarSugerencias(guardarropas);
  }
}
