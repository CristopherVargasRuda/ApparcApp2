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
