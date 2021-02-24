package negocio.logic.controlTablas;

import DAO.ClienteDAO;
import DAO.ContratoDAO;
import DAO.VehiculoDAO;
import java.util.ArrayList;
import negocio.models.Cliente;
import negocio.models.Contrato;
import negocio.models.Vehiculo;
import util.CaException; 

public class ControlTablaContratos {

    private ArrayList<Contrato> contratos;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private ContratoDAO contratoDAO;
    private VehiculoDAO vehiculoDAO;
    private ClienteDAO clienteDAO;

    public ControlTablaContratos() {
        contratoDAO = new ContratoDAO();
        clienteDAO = new ClienteDAO();
        vehiculoDAO = new VehiculoDAO();
        contratos = new ArrayList<>();
    }

    public Contrato devolverContrato(int posicion) {
        try {
            return contratos.get(posicion);
        } catch (Exception e) {
            return null;
        }
    }

    public void cargarContrato() throws CaException {
        contratos.clear();
        contratoDAO.setContratos(contratos);
        contratoDAO.cargarDatosTablaContratos();
        contratos = contratoDAO.getContratos();
        for (Contrato contrato: contratos){
            cliente = new Cliente();
            clienteDAO.setCliente(cliente);
            clienteDAO.cargarDatosTablaContratosSeccionCliente(contrato.getCedulaCliente());
            contrato.setCliente(cliente);
        }
    }

    public int devolverCantidadContratos() {
        return contratos.size();
    }

}
