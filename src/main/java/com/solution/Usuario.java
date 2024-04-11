package com.solution;

import java.util.List;

public class Usuario {

    /*TIENE SENSIBILIDADES RESPECTO DE FACTORES CLIMATICOS Y GUSTOS - no implementado*/

    protected List<Prenda> guardarropas;

    protected List<Atuendo> atuendos;

    //GETTERS
    public List<Prenda> getGuardarropas(){return guardarropas;}

    /*-------------------------*/

    public void cargarPrenda(Prenda unaPrenda){
        guardarropas.add(unaPrenda);
    }

    public void removerPrenda(Prenda unaPrenda){
        if(guardarropas.remove(unaPrenda)){
            System.out.println("Se removió una prenda.");
        }
        else{
            System.out.println("La prenda no existía en el guardarropas.");
        }
    }

    public void solicitarAtuendo(){
        Atuendo nuevoAtuendo = Servidor.generarAtuendo(this);
        atuendos.add(nuevoAtuendo);
    }

}
