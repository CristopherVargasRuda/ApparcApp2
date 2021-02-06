package negocio.logic.controlTablas;

import java.util.ArrayList;
import negocio.models.Parqueadero;

public class ControlTablaParqueaderos {

    private ArrayList<Parqueadero> parqueaderos;

    public ControlTablaParqueaderos() {
    }

    public Parqueadero devolverParqueadero(int posicion) {
        try {
            return parqueaderos.get(posicion);
        } catch (Exception e) {
            return null;
        }
    }

    public void agregarParqueadero(Parqueadero parqueadero) {
        this.parqueaderos.add(parqueadero);
    }

    public int devolverCantidadParqueaderos() {
        return parqueaderos.size();
    }
}
