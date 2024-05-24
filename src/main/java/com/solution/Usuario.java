package com.solution;

import static java.util.Objects.requireNonNull;

import com.solution.Clima.ServicioMeteorologico;
import com.solution.atuendos.Atuendo;
import com.solution.atuendos.Sugerencia;
import com.solution.guardarropas.Guardarropas;
import com.solution.motorSugerencias.MotorSugerencias;
import com.solution.prendas.BorradorPrenda;
import com.solution.prendas.Prenda;
import com.solution.prendas.TipoPrenda;
import java.math.BigDecimal;
import java.security.Guard;
import java.util.ArrayList;
import java.util.List;


public class Usuario {

  protected List<Guardarropas> listaGuardarropas = new ArrayList<>();
  protected List<BorradorPrenda> borradoresPrendas = new ArrayList<>();
  protected List<Atuendo> atuendos = new ArrayList<>();
  protected List<Sugerencia> sugerencias = new ArrayList<>();
  protected int edad;
  public MotorSugerencias motor;
  public ServicioMeteorologico pronostico;

  public Usuario(int edad, MotorSugerencias motor, ServicioMeteorologico pronostico) {
    this.edad = edad;
    this.motor = motor;
    this.pronostico = pronostico;
  }

  /**
   * La nueva instancia de borrador se retorna y ademas se guarda en el usuario.
   * Los cambios efectuados se reflejan en la instancia ya almacenada.
   * @param tipo el tipo de la prenda de TipoPrenda.
   * @return Borrador
   */
  public BorradorPrenda nuevaPrenda(TipoPrenda tipo) {
    BorradorPrenda newBorradorPrenda = new BorradorPrenda(tipo);
    borradoresPrendas.add(newBorradorPrenda);
    return newBorradorPrenda;
  }

  /**
   * Elimina el borrador y carga la nueva prenda en el guardarropas.
   * @param borradorPrenda sus datos deberan estar cargados.
   */
  public void guardarPrenda(BorradorPrenda borradorPrenda, Guardarropas guardarropas) {
    Prenda newPrenda = borradorPrenda.build();
    borradoresPrendas.remove(borradorPrenda);
    guardarropas.agregarPrenda(newPrenda);
  }

  public void recibirAtuendo(Atuendo unAtuendo) {
    atuendos.add(unAtuendo);
  }

  /**
   * Utiliza el motor cargado actualmente para generar sugerencias con el guardarropas.
   */
  public void recibirSugerencias(Guardarropas guardarropas) {
    sugerencias.addAll(motor.generarSugerencias(guardarropas, this.edad));
  }

  public void recibirSugerenciasPorTemperatura() {
    sugerencias.addAll(motor.generarSugerencias(filtrarPorTemperatura(guardarropas), this.edad));
  }

  protected List<Prenda> filtrarPorTemperatura(List<Prenda> guardarropas) {
    return guardarropas
        .stream()
        .filter(prenda ->
                pronostico
                    .getTemperatura("Buenos Aires")
                    .compareTo(new BigDecimal(prenda.getTemperaturaLimite())) == 0
        )
        .toList();
  }

  //GETTERS
  public Prenda getPrenda(int index) {
    return guardarropas.get(index);
  }

  public BorradorPrenda getBorrador(int index) {
    return borradoresPrendas.get(index);
  }

  public int getEdad() {
    return edad;
  }

}

