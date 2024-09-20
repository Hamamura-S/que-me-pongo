package com.solution.model.prendas;

public class Color {

  public int red, green, blue;

  public Color(int red, int green, int blue) throws Exception {
    this.red = validarComponente(red);
    this.green = validarComponente(green);
    this.blue = validarComponente(blue);
  }

  private static int validarComponente(int color) throws Exception {
    if (!(color >= 0 && color <= 255)) {
      throw new Exception("Componentes de color deben estar en [0;255]");
    }
    return color;
  }

}
