package negocio.logic;

import DAO.ParqueaderoDAO;
import negocio.models.Parqueadero;
import util.CaException;

public class ControlEstadosParqueadero {
    private ParqueaderoDAO parqueaderoDAO;
    private Parqueadero parqueadero;

    public ControlEstadosParqueadero() {
        parqueaderoDAO = new ParqueaderoDAO();
        parqueadero = new Parqueadero();
    }
    
    public void buscarParqueadero(String nombreParqueadero) throws CaException{
        parqueaderoDAO.setParqueadero(parqueadero);
        parqueaderoDAO.traerParqueadero(nombreParqueadero);
                
        System.out.println(parqueadero.getNombre()+" control 2");
        System.out.println(parqueadero.getLocalidad());
        System.out.println(parqueadero.isEstado());
    }

    public Parqueadero getParqueadero() {
        return parqueadero;
    }
    
    
}
