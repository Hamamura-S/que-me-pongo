package com.solution;

import com.solution.Clima.ServicioMeteorologico;
import com.solution.repositorios.UsuariosRepositorio;

public class Empleado {

  public void calcularSugerenciasDiarias() {
    UsuariosRepositorio.getInstance().getUsuarios().forEach(Usuario::getSugerenciaDiaria);
  }

}
