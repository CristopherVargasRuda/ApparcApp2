package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.models.Contrato;
import negocio.models.Vehiculo;
import util.CaException;
import util.ServiceLocator;

public class ContratoDAO {

    private Contrato contrato;
    private ArrayList<Contrato> contratos;

    public ContratoDAO() {
        contrato = new Contrato();
    }

    public void insertar() throws CaException {

    }

    public void modificar() {

    }

    public void eliminar() {

    }

    public void buscar() throws CaException {

    }

    public void actualizar() throws CaException {

    }

    public void cargarDatosTablaContratos() throws CaException {
        String sql = "SELECT * FROM contrato;";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            rs = prepStmt.executeQuery();
            
            while (rs.next()) {
                contrato = new Contrato();
                contrato.setIdContrato(rs.getInt("k_idcontrato"));
                contrato.setPeriodo(rs.getString("i_periodo"));
                contrato.setFechaInicio(rs.getString("f_inicio"));
                contrato.setFechaFin(rs.getString("f_fin"));
                contrato.setValorPago(rs.getInt("v_valorpago"));
                contrato.setEstadoContrato(rs.getBoolean("i_estado"));
                contrato.setCodigoParqueadero(rs.getInt("k_codigoparqueadero"));
                contrato.setCedulaCliente(rs.getInt("k_identificacioncliente"));
                contrato.setPlaca(rs.getString("k_placa"));
                contratos.add(contrato);
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
            throw new CaException("AreaDAO", "No se pudo cargar los datos del  Vehiculo" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarContratosParqueadero(int codigoParqueadero) throws CaException {
        String sql = "SELECT * FROM contrato WHERE k_codigoparqueadero = ?;";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setInt(1, codigoParqueadero);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                contrato = new Contrato();
                contrato.setIdContrato(rs.getInt("k_idcontrato"));
                contrato.setPeriodo(rs.getString("i_periodo"));
                contrato.setFechaInicio(rs.getString("f_inicio"));
                contrato.setFechaFin(rs.getString("f_fin"));
                contrato.setValorPago(rs.getInt("v_valorpago"));
                contrato.setEstadoContrato(rs.getBoolean("i_estado"));
                contrato.setCodigoParqueadero(rs.getInt("k_codigoparqueadero"));
                contrato.setCedulaCliente(rs.getInt("k_identificacioncliente"));
                contrato.setPlaca(rs.getString("k_placa"));
                contratos.add(contrato);
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
            throw new CaException("AreaDAO", "No se pudo cargar los datos del  Vehiculo" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public ArrayList<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(ArrayList<Contrato> contratos) {
        this.contratos = contratos;
    }

}
