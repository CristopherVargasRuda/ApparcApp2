package negocio.logic.controlTablas;

import DAO.*;
import java.util.ArrayList;
import negocio.models.Area;
import negocio.models.Cliente;
import negocio.models.Contrato;
import negocio.models.Espacio;
import negocio.models.Parqueadero;
import negocio.models.Tarifa;
import negocio.models.Vehiculo;
import util.CaException;

public class ControlLogin {

    private Parqueadero parqueadero;
    private ArrayList<Area> areas;
    private ArrayList<Espacio> espacios;
    private ArrayList<Tarifa> tarifas;
    private ArrayList<Contrato> contratos;
    private ParqueaderoDAO parqueaderoDAO;
    private AreaDAO areaDAO;
    private EspacioDAO espacioDAO;
    private TarifaDAO tarifaDAO;
    private ContratoDAO contratoDAO;
    private VehiculoDAO vehiculoDAO;
    private ClienteDAO clienteDAO;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Contrato contrato;

    public ControlLogin() {
        parqueadero = new Parqueadero();
        parqueaderoDAO = new ParqueaderoDAO();
        areaDAO = new AreaDAO();
        espacioDAO = new EspacioDAO();
        tarifaDAO = new TarifaDAO();
        contratoDAO = new ContratoDAO();
        vehiculoDAO = new VehiculoDAO();
        clienteDAO = new ClienteDAO();
    }

    public boolean verificarParqueadero(String nombre, String clave) throws CaException {
        parqueadero.setNombre("");
        parqueaderoDAO.setParqueadero(parqueadero);
        parqueaderoDAO.buscarLogin(nombre, clave);
        parqueadero = parqueaderoDAO.getParqueadero();
        if (parqueadero.getNombre().equals(nombre) && parqueadero.isEstado()) {
            areas = new ArrayList<>();
            areaDAO.setAreas(areas);
            areaDAO.buscarAreas(parqueadero.getCodigo());
            areas = areaDAO.getAreas();
            parqueadero.setAreas(areas);
            for (Area area : areas) {
                espacios = new ArrayList<>();
                espacioDAO.setEspacios(espacios);
                espacioDAO.buscarEspacios(parqueadero.getCodigo(), area.getIdArea());
                espacios = espacioDAO.getEspacios();
                area.setEspacios(espacios);
            }
            
            tarifas = new ArrayList<>();
            tarifaDAO.setTarifas(tarifas);
            tarifaDAO.buscarTarifas(parqueadero.getCodigo());
            tarifas = tarifaDAO.getTarifas();
            parqueadero.setTarifas(tarifas);
            
            contratos = new ArrayList<>();
            contratoDAO.setContratos(contratos);
            contratoDAO.buscarContratosParqueadero(parqueadero.getCodigo());
            contratos = contratoDAO.getContratos();
            parqueadero.setContratos(contratos);
            for(Contrato contratoi: contratos){
                
                cliente = new Cliente();
                clienteDAO.setCliente(cliente);
                clienteDAO.cargarDatosTablaContratosSeccionCliente(contratoi.getCedulaCliente());
                cliente = clienteDAO.getCliente();
                contratoi.setCliente(cliente);
                
                
                vehiculo = new Vehiculo();
                vehiculoDAO.setVehiculo(vehiculo);
                vehiculoDAO.cargarDatosContrato(contratoi.getPlaca());
                vehiculo = vehiculoDAO.getVehiculo();
                contratoi.setVehiculo(vehiculo);
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
