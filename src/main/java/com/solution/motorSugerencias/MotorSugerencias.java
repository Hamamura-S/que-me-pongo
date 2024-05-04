package com.solution.motorSugerencias;

import com.google.common.collect.Lists;
import com.solution.prendas.Prenda;
import com.solution.atuendos.Sugerencia;
import com.solution.enums.Categoria;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class MotorSugerencias {

  public List<Sugerencia> generarSugerencias(List<Prenda> guardarropas) {
    List<Prenda> partesSuperiores = guardarropas.stream().filter(prenda -> prenda.getTipo().categoria == Categoria.PARTE_SUPERIOR).collect(Collectors.toList());
    List<Prenda> partesInferiores = guardarropas.stream().filter(prenda -> prenda.getTipo().categoria == Categoria.PARTE_INFERIOR).collect(Collectors.toList());
    List<Prenda> calzados = guardarropas.stream().filter(prenda -> prenda.getTipo().categoria == Categoria.CALZADO).collect(Collectors.toList());

    List<List<Prenda>> cartesianProduct = Lists.cartesianProduct(partesSuperiores, partesInferiores, calzados);

    List<Sugerencia> sugerencias = new ArrayList<>();
    cartesianProduct.forEach(sugerencia -> sugerencias.add(
        new Sugerencia(
            sugerencia.get(0), //prenda superior
            sugerencia.get(1), //prenda inferior
            sugerencia.get(2)) //calzado
    ));

    return sugerencias;
  }

}

