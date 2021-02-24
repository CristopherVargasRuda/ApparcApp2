package negocio.logic.controlTablas;

import DAO.VehiculoDAO;
import java.util.ArrayList;
import negocio.models.Parqueadero;
import negocio.models.Vehiculo;
import util.CaException;



public class ControlTablaVehiculos {
    
    private ArrayList<Vehiculo> vehiculos;
    private VehiculoDAO vehiculoDAO;

    public ControlTablaVehiculos() {
        vehiculos = new ArrayList<>();
        vehiculoDAO = new VehiculoDAO();
    }

    public Vehiculo devolverVehiculo(int posicion) {
        try {
            return vehiculos.get(posicion);
        } catch (Exception e) {
            return null;
        }
    }

    public void cargarVehiculo() throws CaException {
        vehiculos.clear();
        vehiculoDAO.setVehiculos(vehiculos);
        vehiculoDAO.cargarDatosTablaVehiculo();
        vehiculos = vehiculoDAO.getVehiculos();
    }

    public int devolverCantidadVehiculos() {
        return vehiculos.size();
    }
    
    
}
