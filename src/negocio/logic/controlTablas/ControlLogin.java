package negocio.logic.controlTablas;

import DAO.*;
import java.util.ArrayList;
import negocio.models.Area;
import negocio.models.Espacio;
import negocio.models.Parqueadero;
import util.CaException;

public class ControlLogin {

    private Parqueadero parqueadero;
    private ArrayList<Area> areas;
    private ArrayList<Espacio> espacios;
    private ParqueaderoDAO parqueaderoDAO;
    private AreaDAO areaDAO;
    private EspacioDAO espacioDAO;

    public ControlLogin() {
        parqueadero = new Parqueadero();
        parqueaderoDAO = new ParqueaderoDAO();
        areaDAO = new AreaDAO();
        espacioDAO = new EspacioDAO();
                
    }

    public boolean verificarParqueadero(String nombre, String clave) throws CaException {
        parqueadero.setNombre("");
        parqueaderoDAO.setParqueadero(parqueadero);
        parqueaderoDAO.buscarLogin(nombre, clave);
        parqueadero = parqueaderoDAO.getParqueadero();
        if (parqueadero.getNombre().equals(nombre) && parqueadero.isEstado()) {
            areas = new ArrayList<Area>();
            areaDAO.setAreas(areas);
            areaDAO.buscarAreas(parqueadero.getCodigo());
            areas = areaDAO.getAreas();
            parqueadero.setAreas(areas);
            for (Area area : areas) {
                espacios = new ArrayList<Espacio>();
                espacioDAO.setEspacios(espacios);
                espacioDAO.buscarEspacios(parqueadero.getCodigo(), area.getIdArea());
                espacios = espacioDAO.getEspacios();
                area.setEspacios(espacios);
            }
            return true;
        }
        return false;
    }

    public Parqueadero getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

}
