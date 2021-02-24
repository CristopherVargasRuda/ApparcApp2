package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import util.CaException;
import util.ServiceLocator;
import negocio.models.Vehiculo;
import java.util.Locale;
import negocio.models.Espacio;
import negocio.models.Parqueadero;

public class VehiculoDAO {

    private Parqueadero parqueadero;
    private Vehiculo vehiculo;
    private ArrayList<Vehiculo> vehiculos;

    public VehiculoDAO() {
        parqueadero = new Parqueadero();
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

    public void buscarPlacaIngreso(String placa) throws CaException{
        String sql = "SELECT ve.k_placa FROM vehiculo ve WHERE ve.k_placa = ?;";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setString(1, placa);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                vehiculo.setPlaca(rs.getString("k_placa"));
            }
        } catch (SQLException e) {
            throw new CaException("VehiculoDao", "No se encontro la placa" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarTipoVehiculo(String placa) throws CaException {
        String sql = "SELECT ve.k_placa, ve.n_tipovehiculo FROM vehiculo ve, contrato co"
                +" WHERE ve.k_placa = co.k_placa"
                +" AND ve.k_placa = ?;";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setString( 1, placa);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                vehiculo.setPlaca(rs.getString("k_placa"));
                String str = rs.getString("n_tipovehiculo");
                vehiculo.setTipoVehiculo(primeraMayus(str));
            }
        } catch (SQLException e) {
            throw new CaException("VehiculoDao", "No se encontro el tipo de vehiculo" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public static String primeraMayus(String str){
        if(str == null || str.isEmpty()){
            return "";
        }else{
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
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
