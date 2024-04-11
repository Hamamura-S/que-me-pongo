package com.solution.categorias;

import com.solution.Prenda;
import com.solution.enums.Material;
import com.solution.enums.Color;
import com.solution.enums.TipoCalzado;

public class Calzado extends Prenda {

    final private TipoCalzado tipo;

    public Calzado(Material material, Color colorPrimario, TipoCalzado tipo) {

        super(material, colorPrimario);
        this.tipo=tipo;


    }

}

