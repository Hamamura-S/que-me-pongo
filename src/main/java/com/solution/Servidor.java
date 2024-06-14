package com.solution;

import com.solution.Clima.ServicioMeteorologico;
import com.solution.Clima.ServicioMeteorologicoAccWea;
import com.solution.atuendos.Uniforme;
import com.solution.motorSugerencias.MotorSugerencias;
import com.solution.motorSugerencias.MotorSugerenciasNormal;
import com.solution.prendas.Prenda;
import java.util.ArrayList;
import java.util.List;

/**
 * Determinar motor de sugerencias, luego pueden crearse usuarios.
 */
public class Servidor {

  private static List<Usuario> usuarios;

  private static List<Uniforme> uniformes = new ArrayList<>();

  public static MotorSugerencias motor = new MotorSugerenciasNormal();


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
  public static void enviarUniforme(String colegioName, Usuario unUsuario) {
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

  public static void enviarUniforme(int index, Usuario unUsuario) {
    Uniforme uniformeSeleccionado = uniformes.get(index);
    unUsuario.recibirAtuendo(uniformeSeleccionado);
  }

  public static void nuevoUsuario(int edad, ServicioMeteorologico pronostico) {
    usuarios.add(new Usuario(edad, motor, pronostico));
  }

}
