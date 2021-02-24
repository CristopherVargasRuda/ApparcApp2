package app.client.components.consultaProcesos.contratos;

import app.client.components.consultaProcesos.ConsultarProcesosComponent;
import negocio.logic.controlTablas.ControlTablaContratos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.JButton;
import negocio.models.Contrato;
import util.CaException;

public class ConsultaContratosComponent implements ActionListener, MouseListener, FocusListener {

    private ConsultaContratosTemplate consultaContratosTemplate;
    private ConsultarProcesosComponent consultarProcesosComponent;
    private ControlTablaContratos controlTablaContratos;
    private Contrato contrato;

    private JButton boton;

    public ConsultaContratosComponent(ConsultarProcesosComponent consultarProcesosComponent) {
        controlTablaContratos = new ControlTablaContratos();
        this.consultarProcesosComponent = consultarProcesosComponent;
        consultaContratosTemplate = new ConsultaContratosTemplate(this);
    }

    public ConsultaContratosTemplate getConsultaContratosTemplate() {
        return consultaContratosTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    public void actualizarTabla() throws CaException, SQLException {
        limpiarTabla();
        controlTablaContratos.cargarContrato();
        this.mostrarRegistrosTabla();
    }
    
    public void mostrarRegistrosTabla() {
        for (int i = 0; i < controlTablaContratos.devolverCantidadContratos(); i++) {
            contrato = controlTablaContratos.devolverContrato(i);
            this.agregarRegistro(contrato);
        }
    }

    public void agregarRegistro(Contrato contrato) {
        String idContrato, valorPago, fechaInicio, fechaFinal, periodo, identificacionCliente,
        nombreCliente, placaVehiculo;
        idContrato = contrato.getIdContrato()+"";
        valorPago = contrato.getValorPago()+"";
        fechaInicio = contrato.getFechaInicio();
        fechaFinal = contrato.getFechaFin();
        periodo = contrato.getPeriodo();
        nombreCliente = contrato.getCliente().getPrimerNombre()
                + " " + contrato.getCliente().getPrimerApellido();
        identificacionCliente = contrato.getCliente().getIdentificacionCliente()+"";
        placaVehiculo = contrato.getPlaca();
        consultaContratosTemplate.getModelo().addRow(
                new Object[]{idContrato, valorPago, fechaInicio, fechaFinal, 
                    periodo, nombreCliente, identificacionCliente, placaVehiculo                    
                }
        );
    }
    
    public void limpiarTabla() {
        int a = consultaContratosTemplate.getModelo().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            consultaContratosTemplate.getModelo().removeRow(
                    consultaContratosTemplate.getModelo().getRowCount() - 1
            );
        }
    }
}
