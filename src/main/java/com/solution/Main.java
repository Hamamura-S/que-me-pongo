package com.solution;

import com.solution.controller.UsuarioController;
import com.solution.util.JpaEntityManagerProvider;

public class Main {

  public static void main(String[] args) {
    UsuarioController usuarioController = new UsuarioController(
        new JpaEntityManagerProvider()
    );
  }

}
