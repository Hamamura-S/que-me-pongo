package com.solution.repositorios;

import com.solution.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuariosRepositorio {

  private static UsuariosRepositorio instance = null;

  private static List<Usuario> usuarios;

  public static UsuariosRepositorio getInstance() {
    if (instance == null) {
      instance = new UsuariosRepositorio();
      usuarios = new ArrayList<>();
    }
    return instance;
  }

  public void guardar(Usuario usuario) {
      usuarios.add(usuario);
  }

  public List<Usuario> getUsuarios() {
    return usuarios;
  }
}
