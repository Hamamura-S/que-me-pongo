package com.solution.model;

import static java.util.Objects.requireNonNull;

import com.solution.model.accion_configurable.AccionConfigurable;
import com.solution.model.clima.ServicioMeteorologico;
import com.solution.model.atuendos.Atuendo;
import com.solution.model.atuendos.Sugerencia;
import com.solution.model.enums.AlertaMeteorologica;
import com.solution.model.guardarropas.Guardarropas;
import com.solution.util.motorSugerencias.MotorSugerencias;
import com.solution.model.prendas.BorradorPrenda;
import com.solution.model.prendas.Prenda;
import com.solution.model.prendas.TipoPrenda;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Usuario {

  protected List<Guardarropas> listaGuardarropas = new ArrayList<>();
  protected List<BorradorPrenda> borradoresPrendas = new ArrayList<>();
  protected List<Atuendo> atuendos = new ArrayList<>();
  protected List<Sugerencia> sugerencias = new ArrayList<>();
  protected Sugerencia sugerenciaDiaria;
  protected int edad;
  protected String locacion;
  public MotorSugerencias motor;
  public ServicioMeteorologico pronostico;
  protected List<AccionConfigurable> accionConfigurables;


  public Usuario(int edad, MotorSugerencias motor, ServicioMeteorologico pronostico) {
    this.edad = edad;
    this.motor = motor;
    this.pronostico = pronostico;
    pronostico.subscribe(this);
  }

  /* Consultar: sobre que guardarropas se generan las sugerencias diarias? */
  public void getSugerenciaDiaria() {
    Guardarropas temp = new Guardarropas();
    temp.setPrendas(getPrendas()); //Se asume que se generan las sugerencias diarias sobre todas las prendas del usuario
    sugerenciaDiaria = motor.generarSugerenciaDiaria(temp, this.edad);
  }

  public void recibirAlerta(List<AlertaMeteorologica> alertas) {
    accionConfigurables.forEach(accionConfigurable ->
        accionConfigurable.nuevasAlertasMeteorologicas(alertas, this)
    );
  }

  public void agregarGuardarropas(Guardarropas guardarropas) {
    listaGuardarropas.add(guardarropas);
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

  public void recibirSugerenciasPorTemperatura(Guardarropas guardarropas) {
    Guardarropas temp = new Guardarropas();
    temp.setPrendas(filtrarPorTemperatura(guardarropas));
    sugerencias.addAll(motor.generarSugerencias(temp, this.edad));
  }

  protected List<Prenda> filtrarPorTemperatura(Guardarropas guardarropas) {
    return guardarropas
        .getPrendas()
        .stream()
        .filter(prenda ->
                pronostico
                    .getTemperatura(locacion)
                    .compareTo(new BigDecimal(prenda.getTemperaturaLimite())) == 0
        )
        .toList();
  }

  //GETTERS
  public List<Guardarropas> getListaGuardarropas() {
    return listaGuardarropas;
  }

  public BorradorPrenda getBorrador(int index) {
    return borradoresPrendas.get(index);
  }

  public int getEdad() {
    return edad;
  }

  public List<Prenda> getPrendas() {
    List<Prenda> prendas = new ArrayList<>();
    for (Guardarropas guardarropas : listaGuardarropas) {
      prendas.addAll(guardarropas.getPrendas());
    }
    return prendas;
  }

  public String getLocacion() {
    return locacion;
  }
}

