package com.solution.categorias;

import com.solution.Prenda;
import com.solution.enums.Material;
import com.solution.enums.Color;
import com.solution.enums.TipoAccesorio;

public class Accesorio extends Prenda {

    final private TipoAccesorio tipo;

    public Accesorio(Material material, Color colorPrimario, TipoAccesorio tipo) {

        super(material, colorPrimario);
        this.tipo=tipo;

    }

}

