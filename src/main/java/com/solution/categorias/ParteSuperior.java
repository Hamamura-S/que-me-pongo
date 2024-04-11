package com.solution.categorias;

import com.solution.Prenda;
import com.solution.enums.Material;
import com.solution.enums.Color;
import com.solution.enums.TipoParteSuperior;

public class ParteSuperior extends Prenda {

    final private TipoParteSuperior tipo;

    public ParteSuperior(Material material, Color colorPrimario, TipoParteSuperior tipo) {

        super(material, colorPrimario);
        this.tipo=tipo;

    }

}

