package com.solution.categorias;

import com.solution.Prenda;
import com.solution.enums.Material;
import com.solution.enums.Color;
import com.solution.enums.TipoParteInferior;

public class ParteInferior extends Prenda {

    final private TipoParteInferior tipo;

    public ParteInferior(Material material, Color colorPrimario, TipoParteInferior tipo) {

        super(material, colorPrimario);
        this.tipo=tipo;

    }

}

