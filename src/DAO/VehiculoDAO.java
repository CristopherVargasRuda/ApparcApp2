package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.CaException;
import util.ServiceLocator;
import negocio.models.Vehiculo;

public class VehiculoDAO {

    private Vehiculo vehiculo;
    private ArrayList<Vehiculo> vehiculos;

    public VehiculoDAO() {
        vehiculo = new Vehiculo();
    }

    public void insertar() throws CaException {

    }

    public void modificar() {

    }

    public void buscar() throws CaException {

    }

    public void actualizar() throws CaException {

    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

}
