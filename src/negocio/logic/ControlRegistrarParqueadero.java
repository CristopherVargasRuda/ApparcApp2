package negocio.logic;

import DAO.AreaDAO;
import DAO.EspacioDAO;
import DAO.ParqueaderoDAO;
import negocio.models.Area;
import negocio.models.Espacio;
import negocio.models.Parqueadero;
import util.CaException;

public class ControlRegistrarParqueadero {

    private ParqueaderoDAO parqueaderoDAO;
    private AreaDAO areaDAO;
    private EspacioDAO espacioDAO;
    private Parqueadero parqueadero;
    private Area area;
    private Espacio espacio;

    public ControlRegistrarParqueadero() {
        parqueaderoDAO = new ParqueaderoDAO();
        areaDAO = new AreaDAO();
        espacioDAO = new EspacioDAO();
    }
    
    public void registrarParqueadero(Parqueadero parqueadero) throws CaException{
        parqueaderoDAO.setParqueadero(parqueadero);
        parqueaderoDAO.insertar();
        for (Area area: parqueadero.getAreas()){
            areaDAO.setArea(area);
        }
    }
    
    
            
    
}
