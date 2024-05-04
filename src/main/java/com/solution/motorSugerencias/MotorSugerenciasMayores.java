package com.solution.motorSugerencias;

import com.solution.atuendos.Sugerencia;
import com.solution.enums.Categoria;
import com.solution.prendas.Formalidad;
import com.solution.prendas.Prenda;
import java.text.Normalizer;
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
