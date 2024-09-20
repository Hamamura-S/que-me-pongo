package com.solution.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * Clase que se encarga de devolver la unica instancia de EntityManagerFactory.
 */
public class JpaUtil {

  private static final EntityManagerFactory emf = Persistence
      .createEntityManagerFactory(
          "miUnidadPersistencia"
      );

  public static EntityManagerFactory getEntityManagerFactory() {
    return emf;
  }

  /**
   * Cierra el EntityManagerFactory.
   */
  public static void shutdown() {
    if (emf != null && emf.isOpen()) {
      emf.close();
    }
  }

}
