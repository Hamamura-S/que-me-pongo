package com.solution.repository;

import com.solution.model.Usuario;
import com.solution.model.prendas.Prenda;
import com.solution.util.EntityManagerProvider;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository extends Repository<Usuario, Long> {

  public UsuarioRepository(EntityManagerProvider emProvider, Class<Usuario> entityClass) {
    super(emProvider, entityClass);
  }

  public UsuarioRepository(EntityManagerProvider emProvider) {
    super(emProvider, Usuario.class);
  }

}
