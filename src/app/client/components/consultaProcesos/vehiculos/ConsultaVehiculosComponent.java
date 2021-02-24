package app.client.components.consultaProcesos.vehiculos;

import app.client.components.consultaProcesos.ConsultarProcesosComponent;
import app.client.vistaPrincipal.VistaPrincipalComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.JButton;
import negocio.logic.controlTablas.ControlTablaVehiculos;
import negocio.models.Vehiculo;
import util.CaException;

public class ConsultaVehiculosComponent implements ActionListener, MouseListener, FocusListener {

    private ConsultaVehiculosTemplate consultaVehiculosTemplate;
    private ConsultarProcesosComponent consultarProcesosComponent;
    private ControlTablaVehiculos controlTablaVehiculos;

    private Vehiculo vehiculo;
    private JButton boton;

    public ConsultaVehiculosComponent(ConsultarProcesosComponent consultarProcesosComponent) {
        this.consultarProcesosComponent = consultarProcesosComponent;
        controlTablaVehiculos = new ControlTablaVehiculos();
        consultaVehiculosTemplate = new ConsultaVehiculosTemplate(this);
    }

    public ConsultaVehiculosTemplate getConsultaVehiculosTemplate() {
        return consultaVehiculosTemplate;
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
        controlTablaVehiculos.cargarVehiculo();
        this.mostrarRegistrosTabla();
    }

    public void mostrarRegistrosTabla() {
        for (int i = 0; i < controlTablaVehiculos.devolverCantidadVehiculos(); i++) {
            vehiculo = controlTablaVehiculos.devolverVehiculo(i);
            this.agregarRegistro(vehiculo);
        }
    }

    public void agregarRegistro(Vehiculo vehiculo) {
        String placa, tipo;
        placa = vehiculo.getPlaca();
        tipo = vehiculo.getTipoVehiculo();
        consultaVehiculosTemplate.getModelo().addRow(
                new Object[]{placa, tipo}
        );
    }
    
    public void limpiarTabla() {
        int a = consultaVehiculosTemplate.getModelo().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            consultaVehiculosTemplate.getModelo().removeRow(
                    consultaVehiculosTemplate.getModelo().getRowCount() - 1
            );
        }
    }

}
