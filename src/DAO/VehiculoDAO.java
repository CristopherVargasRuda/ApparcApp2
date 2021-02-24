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

    public void cargarDatosTablaVehiculo() throws CaException {
        String sql = "SELECT k_placa, n_tipovehiculo FROM vehiculo;";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                vehiculo = new Vehiculo();
                vehiculo.setPlaca(rs.getString("k_placa"));
                vehiculo.setTipoVehiculo(rs.getString("n_tipovehiculo"));
                vehiculos.add(vehiculo);
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
            throw new CaException("AreaDAO", "No se pudo cargar los datos del  Vehiculo" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public void cargarDatosContrato(String placa) throws CaException {
        String sql = "SELECT * FROM vehiculo ve, contrato co "
                + "WHERE ve.k_placa = co.k_placa "
                + "AND ve.k_placa = ?;";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setString(1, placa);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                vehiculo.setPlaca(rs.getString("k_placa"));
                vehiculo.setTipoVehiculo(rs.getString("n_tipovehiculo"));
                vehiculo.setMarca(rs.getString("n_marca"));
                vehiculo.setColor(rs.getString("n_color"));
                vehiculo.setModelo(rs.getString("n_modelo"));
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
            throw new CaException("AreaDAO", "No se pudo cargar los datos del  Vehiculo" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
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

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

}
