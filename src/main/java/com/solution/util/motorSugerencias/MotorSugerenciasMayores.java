package com.solution.util.motorSugerencias;

import com.solution.model.atuendos.Sugerencia;
import com.solution.model.prendas.Formalidad;
import com.solution.model.prendas.Prenda;
import java.util.List;

public class MotorSugerenciasMayores extends MotorSugerencias {
  public List<Prenda> guardarropasFormal(List<Prenda> guardarropas) {
    return guardarropas.stream()
        .filter(prenda -> prenda.getFormalidad() == Formalidad.FORMAL)
        .toList();
  }

  @Override
  public List<Sugerencia> generarSugerencias(List<Prenda> guardarropas, int edad) {
    return super.generarSugerencias(edad <= 55 ? guardarropas : guardarropasFormal(guardarropas), edad);
  }
}
