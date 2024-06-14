package com.solution.Clima;

import com.solution.Usuario;
import com.solution.enums.AlertaMeteorologica;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicioMeteorologicoAccWea implements ServicioMeteorologico {

  private AccuWeatherAPI api = new AccuWeatherAPI();

  private List<Usuario> subscribers = new ArrayList<>();

  private ListaAlertas alertas = new ListaAlertas();

  public void actualizarAlertas() {
    for (Usuario subscriber : subscribers) {
      alertas.actualizarAlertas(
          subscriber.getLocacion(),
          getAlertasMeteorologicas(subscriber.getLocacion())
      );
      subscriber.recibirAlerta(alertas.getAlertasActuales(subscriber.getLocacion()));
    }
  }

  public void subscribe(Usuario usuario) {
    subscribers.add(usuario);
  }

  public void unsubscribe(Usuario usuario) {
    subscribers.remove(usuario);
  }

  /**
   * Devuelve una lista con los pronosticos de las proximas 12h
   * @param ciudad string con el nombre de la ciudad - mejorable
   * @return lista de diccionarios
   */
  private List<Map<String, Object>> consultarApi(String ciudad) {
    return api.getWeather(ciudad);
  }

  /**
   * Devuelve instancia EstadoClima con los datos de humedad y temperatura del pronostico.
   *
   * @param index elemento de la lista devuelta por la api.
   * @param lista lista devuelta por consultarApi(String).
   * @return EstadoClima
   */
  @SuppressWarnings("unchecked")
  private EstadoClima getEstadoClima(int index, List<Map<String, Object>> lista) {
    HashMap<String, Object> temp = (HashMap<String, Object>) lista.get(index).get("Temperature");
    return new EstadoClima(
        (BigDecimal) temp.get("Value"),
        (BigDecimal) lista.get(index).get("PrecipitationProbability")
    );
  }

  public EstadoClima getEstadoClima(String ciudad) {
    return getEstadoClima(0, consultarApi(ciudad));
  }

  public BigDecimal getTemperatura(String ciudad) {
    return getEstadoClima(0, consultarApi(ciudad)).getTemperatura();
  }

  public BigDecimal getHumedad(String ciudad) {
    return getEstadoClima(0, consultarApi(ciudad)).getHumedad();
  }

  public List<AlertaMeteorologica> getAlertasMeteorologicas(String ciudad) {
    List<String> alerts = api.getAlerts(ciudad).get("CurrentAlerts");
    List<AlertaMeteorologica> alertasMeteorologicas = new ArrayList<>();
    if (alerts == null || alerts.isEmpty()) {
      alertasMeteorologicas.add(AlertaMeteorologica.SIN_ALERTA);
    } else {
      for (String alert : alerts) {
        alertasMeteorologicas.add(AlertaMeteorologica.fromString(alert));
      }
    }
    return alertasMeteorologicas;
  }

}
