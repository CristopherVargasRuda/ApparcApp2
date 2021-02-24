package negocio.logic.controlTablas;

import DAO.*;
import java.util.ArrayList;
import negocio.models.Area;
import negocio.models.Espacio;
import negocio.models.Parqueadero;
import negocio.models.Tarifa;
import util.CaException;

public class ControlLogin {

    private Parqueadero parqueadero;
    private ArrayList<Area> areas;
    private ArrayList<Espacio> espacios;
    private ArrayList<Tarifa> tarifas;
    private ParqueaderoDAO parqueaderoDAO;
    private AreaDAO areaDAO;
    private EspacioDAO espacioDAO;
    private TarifaDAO tarifaDAO;

    public ControlLogin() {
        parqueadero = new Parqueadero();
        parqueaderoDAO = new ParqueaderoDAO();
        areaDAO = new AreaDAO();
        espacioDAO = new EspacioDAO();
        tarifaDAO = new TarifaDAO();
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
            
            tarifas = new ArrayList<Tarifa>();
            tarifaDAO.setTarifas(tarifas);
            tarifaDAO.buscarTarifas(parqueadero.getCodigo());
            tarifas = tarifaDAO.getTarifas();
            parqueadero.setTarifas(tarifas);

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
