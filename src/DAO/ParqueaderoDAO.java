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

    }

    public void modificar() {

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

    public Parqueadero getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public ArrayList<Parqueadero> getParqueaderos() {
        return parqueaderos;
    }

}
