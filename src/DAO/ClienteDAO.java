package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.models.Cliente;
import util.CaException;
import util.ServiceLocator;

public class ClienteDAO {

    private Cliente cliente;
    private ArrayList<Cliente> clientes;

    public ClienteDAO() {
        cliente = new Cliente();
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void buscarCliente(int k_identificacioncliente, String n_tipoidentificacion, String n_primernombre, 
            String n_segundonombre, String n_primerapellido, String 
            n_segundoapellido) throws CaException {
        
        try{
            String staSQL ="SELECT * FROM cliente WHERE k_identificacioncliente = ? "
                    + "AND n_tipoidentificacion = ? AND n_primernombre = ? "
                    + "AND n_segundonombre = ? AND n_primerapellido = ? "
                    + "AND n_segundoapellido = ?";
            
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(staSQL);
            
            prepStmt.setInt(1, k_identificacioncliente);
            prepStmt.setString(2, n_tipoidentificacion);
            prepStmt.setString(3, n_primernombre);
            prepStmt.setString(4, n_segundoapellido);
            prepStmt.setString(5, n_primerapellido);
            prepStmt.setString(6, n_segundoapellido);
            
            ResultSet rs = prepStmt.executeQuery();
            
            while (rs.next()) {
                cliente.setIdentificacionCliente(rs.getInt(1));
                cliente.setTipoIdentificacion(rs.getString(2));
                cliente.setPrimerNombre(rs.getString(3));
                cliente.setSegundoNombre(rs.getString(4));
                cliente.setPrimerApellido(rs.getString(5));
                cliente.setSegundoApellido(rs.getString(6));
                cliente.setSexo(rs.getString(7));
                cliente.setDireccion(rs.getString(8));
                cliente.setTelefono(rs.getFloat(9));
            }
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "¡Consulta Fallida!. No se consultaron los datos del  cliente" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void insertarCliente() throws CaException {
        try{
            String staSQL = "INSERT INTO cliente (k_identificacioncliente, n_tipoidentificacion,"
                    + "n_primernombre, n_segundonombre, n_primerapellido, n_segundoapellido,"
                    + "i_sexo, n_direccion, o_telefonocliente) VALUES (?,?,?,?,?,?,?,?,?)";
            
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(staSQL);
            
            prepStmt.setInt(1, cliente.getIdentificacionCliente());
            prepStmt.setString(2, cliente.getTipoIdentificacion());
            prepStmt.setString(3, cliente.getPrimerNombre());
            prepStmt.setString(4, cliente.getSegundoNombre());
            prepStmt.setString(5, cliente.getPrimerApellido());
            prepStmt.setString(6, cliente.getSegundoApellido());
            prepStmt.setString(7, cliente.getSexo());
            prepStmt.setString(8, cliente.getDireccion());
            prepStmt.setFloat(9, cliente.getTelefono());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            
            ServiceLocator.getInstance().commit();
            
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "¡Creación Fallida!.No se creo el cliente" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
        
    }

    public void cargarDatosTablaContratosSeccionCliente(int id) throws CaException {
        String sql = "SELECT * FROM cliente cl, contrato co WHERE "
                + "cl.k_identificacioncliente = co.k_identificacioncliente "
                + "AND cl.k_identificacioncliente = ?;";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setInt(1, id);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                cliente.setIdentificacionCliente(rs.getInt("k_identificacioncliente"));
                cliente.setTipoIdentificacion(rs.getString("n_tipoidentificacion"));
                cliente.setPrimerNombre(rs.getString("n_primernombre"));
                cliente.setSegundoNombre(rs.getString("n_segundonombre"));
                cliente.setPrimerApellido(rs.getString("n_primerapellido"));
                cliente.setSegundoApellido(rs.getString("n_segundoapellido"));
                cliente.setSexo(rs.getString("i_sexo"));
                cliente.setDireccion(rs.getString("n_direccion"));
                cliente.setTelefono(rs.getFloat("o_telefonocliente"));
            }   
            
        } catch (SQLException e) {
            System.out.println("error: " + e);
            throw new CaException("AreaDAO", "No se pudo cargar los datos del  Vehiculo" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void actualizarCliente() throws CaException {
        try{
            String staSQL = "UPDATE cliente SET n_primernombre = ? , n_segundonombre = ?, "
                    + "n_primerapellido = ?, n_segundoapellido = ?,i_sexo = ?,"
                    + "n_direccion = ?, o_telefonocliente = ? "
                    + "WHERE k_identificacioncliente = ? AND n_tipoidentificacion = ?";
            
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(staSQL);
            
            prepStmt.setString(1, cliente.getPrimerNombre());
            prepStmt.setString(2, cliente.getSegundoNombre());
            prepStmt.setString(3, cliente.getPrimerApellido());
            prepStmt.setString(4, cliente.getSegundoApellido());
            prepStmt.setString(5, cliente.getSexo());
            prepStmt.setString(6, cliente.getDireccion());
            prepStmt.setFloat(7, cliente.getTelefono());
            prepStmt.setInt(8, cliente.getIdentificacionCliente());
            prepStmt.setString(9, cliente.getTipoIdentificacion());
            
            prepStmt.executeUpdate();
            prepStmt.close();
            
            ServiceLocator.getInstance().commit();
            
        } catch (SQLException e) {
            throw new CaException("ClienteDAO", "¡Actualización Fallida!.No se actualizo el cliente" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }    
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

}
