package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.models.Tarifa;
import util.CaException;
import util.ServiceLocator;

public class TarifaDAO {

    private Tarifa tarifa;
    private ArrayList<Tarifa> tarifas;

    public TarifaDAO() {
        tarifa = new Tarifa();
    }
    
    public void registrarTarifa(int codigoParqueadero) throws CaException {
        String sql = "INSERT INTO tarifa(k_idTarifa, n_tipoVehiculo, "
                + "v_valorMaxMinuto, k_codigoParqueadero) VALUES (?, ?, ?, ?)";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setInt(1, tarifa.getIdTarifa());
            prepStmt.setString(2, tarifa.getTipoVehiculo());
            prepStmt.setInt(3, tarifa.getPrecioMaximoMinuto());
            prepStmt.setInt(4, codigoParqueadero);
            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new CaException("ParqueaderoDAO", "No se puede insertar los datos del  parqueadero" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void insertar() throws CaException {

    }

    public void modificar() {

    }

    public void eliminar() {

    }

    public void buscar() throws CaException {

    }

    public void buscarTarifas(int codigoParqueadero) throws CaException {
        String sql = "SELECT t.k_idtarifa, t.n_tipovehiculo, "
                + "t.v_valormaxminuto, t.k_codigoparqueadero "
                + "FROM tarifa t, parqueadero p "
                + "WHERE t.k_codigoparqueadero = p.k_codigoparqueadero "
                + "AND t.k_codigoparqueadero = ?;";

        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setInt(1, codigoParqueadero);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                tarifa = new Tarifa();
                tarifa.setIdTarifa(rs.getInt("k_idtarifa"));
                tarifa.setTipoVehiculo(rs.getString("n_tipovehiculo"));
                tarifa.setPrecioMaximoMinuto(rs.getInt("v_valormaxminuto"));
                tarifas.add(tarifa);
            }
        } catch (SQLException e) {
            throw new CaException("AreaDAO", "No se pudo cargar los datos del  Area" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void actualizar() throws CaException {

    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public ArrayList<Tarifa> getTarifas() {
        return tarifas;
    }

    public void setTarifas(ArrayList<Tarifa> tarifas) {
        this.tarifas = tarifas;
    }
    
    

}
