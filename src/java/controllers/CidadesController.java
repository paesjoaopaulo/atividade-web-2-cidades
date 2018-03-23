package controllers;

import java.util.ArrayList;
import model.Cidade;
import persistency.CidadePersistency;

public class CidadesController {

    private final CidadePersistency persistency = new CidadePersistency();

    public ArrayList<Cidade> index() {
        return this.persistency.index();
    }

}
