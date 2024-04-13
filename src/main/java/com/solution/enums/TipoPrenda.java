package com.solution.enums;

public enum TipoPrenda {

  ZAPATOS(Categoria.CALZADO),
  ZAPATILLAS(Categoria.CALZADO),
  TACONES(Categoria.CALZADO),
  RELOJ(Categoria.ACCESORIO),
  COLLAR(Categoria.ACCESORIO),
  JEANS(Categoria.PARTE_INFERIOR),
  JOGGINS(Categoria.PARTE_INFERIOR),
  SHORTS(Categoria.PARTE_INFERIOR),
  REMERA(Categoria.PARTE_SUPERIOR),
  CHOMBA(Categoria.PARTE_SUPERIOR),
  CAMISA(Categoria.PARTE_SUPERIOR),
  SACO(Categoria.PARTE_SUPERIOR);

  public final Categoria categoria;

  TipoPrenda(Categoria categoria) {
    this.categoria = categoria;
  }

}
