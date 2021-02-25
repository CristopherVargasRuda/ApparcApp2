package negocio.logic;

import DAO.VehiculoDAO;
import negocio.models.Parqueadero;
import negocio.models.Vehiculo;
import util.CaException;

public class ControlPlaca {

    private Vehiculo vehiculo;
    private VehiculoDAO vehiculoDAO;

    public ControlPlaca(){
        vehiculo = new Vehiculo();
        vehiculoDAO = new VehiculoDAO();
    }

    public boolean verificarExistencia(String placa) throws CaException {
        vehiculo.setPlaca("");
        vehiculo.setTipoVehiculo("");
        vehiculoDAO.setVehiculo(vehiculo);
        vehiculoDAO.buscarPlacaIngreso(placa);
        if(vehiculoDAO.getVehiculo().getPlaca().equals(placa) && !placa.equals("")){
            vehiculo = vehiculoDAO.getVehiculo();
            return true;
        }else{
            return false;
        }
    }

    public boolean verificarContrato(String parqueadero, String placa) throws CaException {
        vehiculo.setPlaca("");
        vehiculo.setTipoVehiculo("");
        vehiculoDAO.setVehiculo(vehiculo);
        vehiculoDAO.buscarContrato(parqueadero,placa);
        if(vehiculoDAO.getVehiculo().getPlaca().equals(placa) && !placa.equals("")){
            vehiculo = vehiculoDAO.getVehiculo();
            return true;
        }else{
            return false;
        }
    }

    public void modificarTipoVehiculo(String placa) throws CaException {
        vehiculo.setPlaca("");
        vehiculo.setTipoVehiculo("");
        vehiculoDAO.setVehiculo(vehiculo);
        vehiculoDAO.buscarTipoVehiculo(placa);
        if(vehiculoDAO.getVehiculo().getPlaca().equals(placa)){
            vehiculo.setTipoVehiculo(vehiculoDAO.getVehiculo().getTipoVehiculo());
        }
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public VehiculoDAO getVehiculoDAO() {
        return vehiculoDAO;
    }

    public void setVehiculoDAO(VehiculoDAO vehiculoDAO) {
        this.vehiculoDAO = vehiculoDAO;
    }
}