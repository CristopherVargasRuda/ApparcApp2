package negocio.logic;

import DAO.AreaDAO;
import DAO.EspacioDAO;
import DAO.ParqueaderoDAO;
import DAO.TarifaDAO;
import negocio.models.Area;
import negocio.models.Espacio;
import negocio.models.Parqueadero;
import negocio.models.Tarifa;
import util.CaException;

public class ControlRegistrarParqueadero {

    private ParqueaderoDAO parqueaderoDAO;
    private AreaDAO areaDAO;
    private EspacioDAO espacioDAO;
    private TarifaDAO tarifaDAO;
    private Parqueadero parqueadero;
    private Area area;
    private Espacio espacio;
    private Tarifa tarifa;

    public ControlRegistrarParqueadero() {
        parqueaderoDAO = new ParqueaderoDAO();
        areaDAO = new AreaDAO();
        espacioDAO = new EspacioDAO();
        tarifaDAO = new TarifaDAO();
    }

    public void registrarParqueadero(Parqueadero parqueadero) throws CaException {

        parqueaderoDAO.setParqueadero(parqueadero);
        parqueaderoDAO.insertar();
        for (Area area : parqueadero.getAreas()) {
            areaDAO.setArea(area);
            areaDAO.registrarArea(parqueadero.getCodigo());
            for (Espacio espacio : area.getEspacios()) {
                espacioDAO.setEspacio(espacio);
                espacioDAO.registrarEspacio(parqueadero.getCodigo(), area.getIdArea());
            }
        }
        for (Tarifa tarifa : parqueadero.getTarifas()) {
            tarifaDAO.setTarifa(tarifa);
            tarifaDAO.registrarTarifa(parqueadero.getCodigo());
        }
    }

}
