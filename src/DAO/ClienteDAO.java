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

    public void cargarDatosTablaContratosSeccionCliente(int cedula) throws CaException {
        String sql = "SELECT * FROM cliente cl, contrato co WHERE "
                + "cl.k_identificacioncliente = co.k_identificacioncliente "
                + "AND cl.k_identificacioncliente = ?;";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setInt(1, cedula);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                cliente.setCedulaCliente(rs.getInt("k_identificacioncliente"));
                cliente.setTipoDocumento(rs.getString("n_tipoidentificacion"));
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
    
   

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

}
