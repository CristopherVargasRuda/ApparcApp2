package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.models.Parqueadero;
import util.CaException;
import util.ServiceLocator;

public class ParqueaderoDAO {

    private Parqueadero parqueadero;
    private ArrayList<Parqueadero> parqueaderos;

    public ParqueaderoDAO() {
        parqueadero = new Parqueadero();
    }

    public void insertar() throws CaException {
        /*Parqueadero parqueadero = new Parqueadero();
        parqueadero.setNombre("Edilberto");
        parqueadero.setCodigo(1111);
        parqueadero.setClave("holi");
        parqueadero.setCantidadNiveles(2);
        parqueadero.setDireccion("holaaaaaaa");
        parqueadero.setEstado(true);
        parqueadero.setLocalidad("Suba");
        parqueadero.setSubterraneo(true);
        parqueadero.setTipoSuelo("bonito");
        parqueadero.setFactorDemandaZonal((float) 0.8);*/
        String sql = "INSERT INTO parqueadero(k_codigoParqueadero, "
                + "n_nombreParqueadero, n_direccion, n_localidad, "
                + "i_subterraneo, q_cantidadNiveles, i_tipoSuelo, "
                + "i_factorDemandaZonal, o_contrasenaParqueadero, "
                + "i_estadoParqueadero)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setInt(1, parqueadero.getCodigo());
            prepStmt.setString(2, parqueadero.getNombre());
            prepStmt.setString(3, parqueadero.getDireccion());
            prepStmt.setString(4, parqueadero.getLocalidad());
            prepStmt.setBoolean(5, parqueadero.isSubterraneo());
            prepStmt.setInt(6, parqueadero.getCantidadNiveles());
            prepStmt.setString(7, parqueadero.getTipoSuelo());
            prepStmt.setFloat(8, parqueadero.getFactorDemandaZonal());
            prepStmt.setString(9, parqueadero.getClave());
            prepStmt.setBoolean(10, parqueadero.isEstado());
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new CaException("ParqueaderoDAO", "No se puede insertar los datos del  parqueadero" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void modificar() {

    }

    public void cargarDatosTablaParqueaderos() throws CaException{
        String sql = "SELECT * FROM parqueadero;";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            rs = prepStmt.executeQuery();
            parqueaderos.clear();
            while (rs.next()) {
                parqueadero = new Parqueadero();
                parqueadero.setCodigo(rs.getInt("k_codigoparqueadero"));
                parqueadero.setNombre(rs.getString("n_nombreparqueadero"));
                parqueadero.setDireccion(rs.getString("n_direccion"));
                parqueadero.setLocalidad(rs.getString("n_localidad"));
                parqueadero.setSubterraneo(rs.getBoolean("i_subterraneo"));
                parqueadero.setCantidadNiveles(rs.getInt("q_cantidadniveles"));
                parqueadero.setTipoSuelo(rs.getString("i_tiposuelo"));
                parqueadero.setFactorDemandaZonal(rs.getFloat("i_factordemandazonal"));
                parqueadero.setClave(rs.getString("o_contrasenaparqueadero"));
                parqueadero.setEstado(rs.getBoolean("i_estadoparqueadero"));
                parqueaderos.add(parqueadero);
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
            throw new CaException("ParqueaderoDAO", "No se pudo cargar los datos del  Parqueadero" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public void buscarLogin(String nombre, String clave) throws CaException {
        String sql = "SELECT * FROM  parqueadero WHERE n_nombreparqueadero = '"
                + nombre + "' AND o_contrasenaparqueadero = '" + clave + "';";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            rs = prepStmt.executeQuery();

            while (rs.next()) {
                parqueadero.setCodigo(rs.getInt("k_codigoparqueadero"));
                parqueadero.setNombre(rs.getString("n_nombreparqueadero"));
                parqueadero.setDireccion(rs.getString("n_direccion"));
                parqueadero.setLocalidad(rs.getString("n_localidad"));
                parqueadero.setSubterraneo(rs.getBoolean("i_subterraneo"));
                parqueadero.setCantidadNiveles(rs.getInt("q_cantidadniveles"));
                parqueadero.setTipoSuelo(rs.getString("i_tiposuelo"));
                parqueadero.setFactorDemandaZonal(rs.getFloat("i_factordemandazonal"));
                parqueadero.setClave(rs.getString("o_contrasenaparqueadero"));
                parqueadero.setEstado(rs.getBoolean("i_estadoparqueadero"));
            }
        } catch (SQLException e) {
            throw new CaException("ParqueaderoDAO", "No se puede consultar los datos del  parqueadero" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public void traerParqueadero(String nombreParqueadero)throws CaException {
        System.out.println(nombreParqueadero+" DAO");
        parqueadero.setNombre(nombreParqueadero);
        
        String sql = "SELECT k_codigoparqueadero, n_nombreparqueadero, n_direccion, n_localidad, i_estadoparqueadero "
                    + "FROM parqueadero "
                    + "where n_nombreparqueadero = ?;";
        
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setString(1, nombreParqueadero);
            rs = prepStmt.executeQuery();
            System.out.println(rs);
            while (rs.next()) {
                parqueadero.setCodigo(rs.getInt("k_codigoparqueadero"));
                parqueadero.setNombre(rs.getString("n_nombreparqueadero"));
                parqueadero.setDireccion(rs.getString("n_direccion"));
                parqueadero.setLocalidad(rs.getString("n_localidad"));
                parqueadero.setEstado(rs.getBoolean("i_estadoparqueadero"));
            }
        } catch (SQLException e) {
            throw new CaException("ParqueaderoDAO", "No se pudo cargar los datos del espacio" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }
    
    public Parqueadero getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public ArrayList<Parqueadero> getParqueaderos() {
        return parqueaderos;
    }

    public void setParqueaderos(ArrayList<Parqueadero> parqueaderos) {
        this.parqueaderos = parqueaderos;
    }

    
}
