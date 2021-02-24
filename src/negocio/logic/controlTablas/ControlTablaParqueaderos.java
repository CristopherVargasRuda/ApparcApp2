package negocio.logic.controlTablas;

import DAO.ParqueaderoDAO;
import java.util.ArrayList;
import negocio.models.Parqueadero;
import util.CaException;

public class ControlTablaParqueaderos {

    private ArrayList<Parqueadero> parqueaderos;
    private ParqueaderoDAO parqueaderoDAO;

    public ControlTablaParqueaderos() {
        parqueaderoDAO = new ParqueaderoDAO();
        parqueaderos = new ArrayList<>();
    }

    public Parqueadero devolverParqueadero(int posicion) {
        try {
            return parqueaderos.get(posicion);
        } catch (Exception e) {
            return null;
        }
    }

    public void cargarParqueadero() throws CaException {
        parqueaderos.clear();
        parqueaderoDAO.setParqueaderos(parqueaderos);
        parqueaderoDAO.cargarDatosTablaParqueaderos();
        parqueaderos = parqueaderoDAO.getParqueaderos();
    }

    public int devolverCantidadParqueaderos() {
        return parqueaderos.size();
    }
}
