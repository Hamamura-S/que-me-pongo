package com.solution.util.comunicacion;

import com.solution.model.Usuario;

public interface Notificador {
  public void notificar(String mensaje, Usuario user);
}
