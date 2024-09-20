package com.solution.repository;

import com.solution.util.EntityManagerProvider;
import java.util.List;
import javax.persistence.EntityManager;

public class Repository<T, ID> {

  protected final EntityManagerProvider emProvider;
  private final Class<T> entityClass;

  public Repository(EntityManagerProvider emProvider, Class<T> entityClass) {
    this.emProvider = emProvider;
    this.entityClass = entityClass;
  }

  /**
   * Guarda una entidad transient en la base de datos, haciendola persistible.
   */
  public void guardar(T entity) {
    EntityManager em = emProvider.getEntityManager();
    em.getTransaction().begin();
    em.persist(entity);
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Actualiza una entidad detached en la base de datos.
   */
  public T buscarPorId(ID id) {
    EntityManager em = emProvider.getEntityManager();
    T entity = em.find(entityClass, id);
    em.close();
    return entity;
  }

  /**
   * Buscar todas las entidades de un tipo.
   */
  public List<T> buscarTodos() {
    EntityManager em = emProvider.getEntityManager();
    List<T> entities = em
        .createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass)
        .getResultList();
    em.close();
    return entities;
  }

  /**
   * Eliminar una entidad de la base de datos.
   */
  public void eliminar(ID id) {
    EntityManager em = emProvider.getEntityManager();
    em.getTransaction().begin();
    T entity = em.find(entityClass, id);
    em.remove(entity);
    em.getTransaction().commit();
    em.close();
  }

}
