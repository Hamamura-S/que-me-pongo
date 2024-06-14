package com.solution.comunicacion;

import com.solution.Usuario;

public interface Notificador {
  public void notificar(String mensaje, Usuario user);
}
