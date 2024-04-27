package com.solution;

import java.util.ArrayList;
import java.util.List;

public class Servidor {

  private static List<Usuario> usuarios;

  private static List<Uniforme> uniformes = new ArrayList<>();

  public static void nuevoUniforme(String colegioName, Prenda prendaSup, Prenda prendaInf, Prenda calzado) {
    uniformes.add(
        new Uniforme(
          colegioName,
          prendaSup,
          prendaInf,
          calzado
        )
    );
  }

  /**
   * Dado un uniforme previamente cargado, se envia al usuario.
   * @param colegioName nombre del colegio
   * @param unUsuario usuario al que se envia
   */
  public void enviarUniforme(String colegioName, Usuario unUsuario) {
    Uniforme uniformeSeleccionado = null;
    for (Uniforme unUniforme : uniformes) {
      if (unUniforme.colegio.equals(colegioName)) {
        uniformeSeleccionado = unUniforme;
        break;
      }
    }
    if (uniformeSeleccionado == null) {
      throw new RuntimeException("No hay uniforme para este colegio.");
    }
    unUsuario.recibirAtuendo(uniformeSeleccionado);
  }

  public void enviarUniforme(int index, Usuario unUsuario) {
    Uniforme uniformeSeleccionado = uniformes.get(index);
    unUsuario.recibirAtuendo(uniformeSeleccionado);
  }

}
