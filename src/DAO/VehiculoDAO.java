package DAO;

import negocio.models.Parqueadero;
import negocio.models.Vehiculo;
import util.CaException;
import util.ServiceLocator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VehiculoDAO {

    private Parqueadero parqueadero;
    private Vehiculo vehiculo;
    private int cantidadVehiculos;
    private ArrayList<Vehiculo> vehiculos;
    private ServiceLocator cn;

    public VehiculoDAO() {
        parqueadero = new Parqueadero();
        vehiculo = new Vehiculo();
        cn = ServiceLocator.getInstance();
    }

    public void verificarPlacaSalidaDAO(String placa, int codigoParqueadero) {
        ResultSet rs = null;
        vehiculo = new Vehiculo();
        parqueadero = new Parqueadero();

        String sql = "SELECT ve.k_placa FROM vehiculo ve, parqueadero pa, servicio se, area a, espacio es "
                + " WHERE se.k_idespacio=es.k_idespacio"
                + " AND es.k_idarea=a.k_idarea"
                + " AND se.k_placa=ve.k_placa"
                + " AND pa.k_codigoparqueadero=a.k_codigoparqueadero"
                + " AND pa.k_codigoparqueadero=se.k_codigoparqueadero"
                + " AND se.k_idarea = es.k_idarea"
                + " AND f_salida IS NULL"
                + " AND es.i_estado = false"
                + " AND pa.k_codigoparqueadero=?"
                + " AND ve.k_placa=?;";
        try {
            PreparedStatement pstm;
            pstm = cn.tomarConexion().prepareStatement(sql);
            pstm.setInt(1, codigoParqueadero);
            pstm.setString(2, placa);
            rs = pstm.executeQuery();
            while (rs.next()) {
                vehiculo.setPlaca(rs.getString("k_placa"));
            }
        } catch (SQLException e) {
            System.out.println("Error en DB Cliente: " + e);
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }

    public void verificarTipoDAO(String placa, int codigoParqueadero) {
        ResultSet rs = null;
        vehiculo = new Vehiculo();
        parqueadero = new Parqueadero();

        String sql = "SELECT ve.k_placa, co.k_idcontrato"
                + " FROM parqueadero pa, vehiculo ve, contrato co"
                + " WHERE pa.k_codigoparqueadero = co.k_codigoparqueadero"
                + " AND ve.k_placa = co.k_placa"
                + " AND pa.k_codigoparqueadero = ?"
                + " AND ve.k_placa = ?;";
        try {
            PreparedStatement pstm;
            pstm = cn.tomarConexion().prepareStatement(sql);
            pstm.setInt(1, codigoParqueadero);
            pstm.setString(2, placa);
            rs = pstm.executeQuery();
            while (rs.next()) {
                vehiculo.setPlaca(rs.getString("k_placa"));
            }
        } catch (SQLException e) {
            System.out.println("Error en DB Cliente: " + e);
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    //Buscar vehiculo en el sistema
    public void buscarPlaca(String placa) throws CaException {
        ResultSet rs = null;
        vehiculo = new Vehiculo();

        String sql = "SELECT * FROM vehiculo WHERE k_placa = ? ";
        try {
            PreparedStatement pstm;
            pstm = cn.tomarConexion().prepareStatement(sql);
            pstm.setString(1, placa);
            rs = pstm.executeQuery();
            while (rs.next()) {
                vehiculo.setPlaca(rs.getString("k_placa"));
            }
        } catch (SQLException e) {
            System.out.println("Error en DB Cliente: " + e);
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    //Buscar tipo de salida del vehiculo
    public void buscarTipoSalida(String placa) throws CaException {
        ResultSet rs = null;
        vehiculo = new Vehiculo();

        String sql = "SELECT * FROM vehiculo ve, contrato co WHERE ve.k_placa=co.k_placa AND ve.k_placa = ? ";
        try {
            PreparedStatement pstm = cn.tomarConexion().prepareStatement(sql);
            pstm.setString(1, placa);
            rs = pstm.executeQuery();
            while (rs.next()) {
                vehiculo.setPlaca(rs.getString("k_placa"));
            }
        } catch (SQLException e) {
            System.out.println("Error en DB Cliente: " + e);
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void insertar() throws CaException {
        String sql = "INSERT INTO vehiculo (k_placa,n_tipovehiculo) VALUES (?, ?);";
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setString(1, vehiculo.getPlaca());
            prepStmt.setString(2, vehiculo.getTipoVehiculo());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new CaException("ParqueaderoDAO", "No se pudo insertar la información del vehiculo." + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

    }

    public void modificar() {

    }

    public void buscar() throws CaException {

    }

    public void actualizar() throws CaException {

    }

    public void buscarPlacaIngreso(String placa) throws CaException {
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

    public void buscarContrato(String placa, String nombreParqueadero) throws CaException {
        String sql = "SELECT ve.k_placa, co.k_idcontrato, pa.n_nombreparqueadero"
                + " FROM parqueadero pa, vehiculo ve, contrato co"
                + " WHERE pa.k_codigoparqueadero = co.k_codigoparqueadero"
                + " AND ve.k_placa = co.k_placa AND pa.n_nombreparqueadero = ? AND ve.k_Placa = ?;";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setString(1, nombreParqueadero);
            prepStmt.setString(2, placa);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                vehiculo.setPlaca(rs.getString("k_placa"));
                parqueadero.setNombre("n_nombreparqueadero");
            }
        } catch (SQLException e) {
            throw new CaException("VehiculoDao", "No se encontro la placa" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarTipoVehiculo(String placa) throws CaException {
        String sql = "SELECT ve.k_placa, ve.n_tipovehiculo FROM vehiculo ve"
                + " WHERE ve.k_placa = ?;";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setString(1, placa);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                vehiculo.setPlaca(rs.getString("k_placa"));
                String str = rs.getString("n_tipovehiculo");
                vehiculo.setTipoVehiculo(primeraMayus(str));
            }
            System.out.println("TIPO VEHICULO DAO: " + vehiculo.getTipoVehiculo());
        } catch (SQLException e) {
            throw new CaException("VehiculoDao", "No se encontro el tipo de vehiculo" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarTipoVehiculoTarifa(String placa, int codigoParqueadero) throws CaException {
        String sql = "SELECT ve.k_placa, ve.n_tipovehiculo FROM parqueadero pa, vehiculo ve"
                + " WHERE ve.k_placa = ?"
                + " AND pa.k_codigoparqueadero = ?;";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setString(1, placa);
            prepStmt.setInt(2, codigoParqueadero);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                String str = rs.getString("n_tipovehiculo");
                vehiculo.setTipoVehiculo(primeraMayus(str));
            }
        } catch (SQLException e) {
            throw new CaException("VehiculoDao", "No se encontro el tipo de vehiculo" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public static String primeraMayus(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        } else {
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

    public void cargarCantidadTotalVehiculos() throws CaException {
        String sql = "SELECT COUNT(k_placa) AS total FROM vehiculo;";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                cantidadVehiculos = rs.getInt("total");
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
            throw new CaException("VehiculoDAO", "No se pudo cargar los datos del  Vehiculo" + e.getMessage());
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

    public int getCantidadVehiculos() {
        return cantidadVehiculos;
    }

    public void setCantidadVehiculos(int cantidadVehiculos) {
        this.cantidadVehiculos = cantidadVehiculos;
    }

}
