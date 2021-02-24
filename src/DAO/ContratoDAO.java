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
    
    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
    
    public Contrato getContrato() {
        return contrato;
    }

    public void buscarContrato(int k_idcontrato, String i_periodo, 
            int v_valorpago) throws CaException {
        
        try{
            String staSQL ="SELECT * FROM contrato WHERE k_idcontrato = ? "
                    + "AND i_periodo = ? AND v_valorpago = ? ";
            
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(staSQL);
            
            prepStmt.setInt(1, k_idcontrato);
            prepStmt.setString(2, i_periodo);
            prepStmt.setInt(3, v_valorpago);
            
            ResultSet rs = prepStmt.executeQuery();
            
            while (rs.next()) {
                contrato.setIdContrato(rs.getInt(1));
                contrato.setPeriodo(rs.getString(2));
                contrato.setFechaInicio(rs.getString(3));
                contrato.setFechaFin(rs.getString(4));
                contrato.setValorPago(rs.getInt(5));
                contrato.setEstadoContrato(rs.getBoolean(6));
            }
        } catch (SQLException e) {
            throw new CaException("ContratoDAO", "¡Consulta Fallida!. No se consultaron los datos del  contrato" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }   
    }

    public void insertarContrato() throws CaException {
        try{
            String staSQL = "INSERT INTO contrato (k_idcontrato, i_periodo,"
                    + "f_inicio, f_fin, v_valorpago, i_estado) VALUES (?,?,?,?,?,?)";
            
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(staSQL);
            
            prepStmt.setInt(1, contrato.getIdContrato());
            prepStmt.setString(2, contrato.getPeriodo());
            prepStmt.setString(3, contrato.getFechaInicio());
            prepStmt.setString(4, contrato.getFechaFin());
            prepStmt.setInt(5, contrato.getValorPago());
            prepStmt.setBoolean(6, contrato.isEstadoContrato());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            
            ServiceLocator.getInstance().commit();
            
        } catch (SQLException e) {
            throw new CaException("ContratoDAO", "¡Creación Fallida!.No se creo el contrato" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
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
    
   public void actualizarContrato() throws CaException {
       
    }

    public ArrayList<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(ArrayList<Contrato> contratos) {
        this.contratos = contratos;
    }

}
