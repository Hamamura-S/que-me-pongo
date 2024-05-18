package com.solution.Clima;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicioMeteorologicoAccWea implements ServicioMeteorologico {

  static ServicioMeteorologicoAccWea single_instance = null;

  static AccuWeatherAPI api = new AccuWeatherAPI();

  /**
   * Devuelve la instancia unica del motor del clima
   * @return ServicioMeteorologico.
   *
   */
  public static synchronized ServicioMeteorologicoAccWea getInstance() {
    if (single_instance == null) {
      single_instance = new ServicioMeteorologicoAccWea();
    }
    return single_instance;
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

}
