package negocio.logic;

import DAO.AreaDAO;
import DAO.EspacioDAO;
import DAO.ServicioDAO;
import DAO.VehiculoDAO;
import negocio.models.*;
import util.CaException;

public class ControlRegistrarIngreso {

    private Vehiculo vehiculo;
    private VehiculoDAO vehiculoDAO;
    private Servicio servicio;
    private ServicioDAO servicioDAO;
    private Area area;
    private AreaDAO areaDAO;
    private Espacio espacio;
    private EspacioDAO espacioDAO;

    public ControlRegistrarIngreso(){
        vehiculo = new Vehiculo();
        vehiculoDAO = new VehiculoDAO();
        servicio = new Servicio();
        servicioDAO = new ServicioDAO();
        area = new Area();
        areaDAO = new AreaDAO();
        espacio = new Espacio();
        espacioDAO = new EspacioDAO();
    }

    public int ajustarCount() throws CaException {
        servicioDAO.setServicio(servicio);
        servicioDAO.buscarCount();
        return servicioDAO.getServicio().getIdServicio();
    }
    public void registrarVehiculo(String placa, String tipo) throws CaException {
        vehiculo.setPlaca(placa);
        vehiculo.setTipoVehiculo(tipo);
        vehiculoDAO.setVehiculo(vehiculo);
        vehiculoDAO.insertar();
    }
    public void registrarServicio(Servicio servicio, Parqueadero parqueadero) throws CaException {
        servicioDAO.setServicio(servicio);
        servicioDAO.setParqueadero(parqueadero);
        servicioDAO.insertar();
    }
    public void registrarAreas(Area area) throws CaException {
        areaDAO.setArea(area);
        areaDAO.actualizarCuposDisponibles();
    }
    public void registrarEspacio(Espacio espacio) throws CaException {
        espacioDAO.setEspacio(espacio);
        espacioDAO.actualizarEstado();
    }

}