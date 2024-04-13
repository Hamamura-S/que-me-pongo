package com.solution;

import static java.util.Objects.requireNonNull;

import com.solution.enums.Categoria;

public class TipoPrenda {

  public final String nombre;

  public final Categoria categoria;

  public TipoPrenda(String nombre, Categoria categoria) {
    this.nombre = requireNonNull(nombre, "La prenda debe tener un nombre");
    this.categoria = requireNonNull(categoria, "La prenda debe tener una categoria");
  }

}
