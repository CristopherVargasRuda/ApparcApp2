package app.client.components.consultaProcesos.parqueaderos;

import app.client.components.consultaProcesos.ConsultarProcesosComponent;
import negocio.logic.controlTablas.ControlTablaParqueaderos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.JButton;
import negocio.models.Parqueadero;
import util.CaException;

public class ConsultaParqueaderosComponent implements ActionListener, MouseListener, FocusListener {

    private ConsultaParqueaderosTemplate consultaParqueaderosTemplate;
    private ConsultarProcesosComponent consultarProcesosComponent;
    private ControlTablaParqueaderos controlParqueaderos;
    private Parqueadero parqueadero;

    private JButton boton;

    public ConsultaParqueaderosComponent(ConsultarProcesosComponent consultarProcesosComponent) {
        controlParqueaderos = new ControlTablaParqueaderos();
        this.consultarProcesosComponent = consultarProcesosComponent;
        consultaParqueaderosTemplate = new ConsultaParqueaderosTemplate(this);
    }

    public ConsultaParqueaderosTemplate getConsultaParqueaderosTemplate() {
        return consultaParqueaderosTemplate;
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
        controlParqueaderos.cargarParqueadero();
        this.mostrarRegistrosTabla();
    }
    
    public void mostrarRegistrosTabla() {
        for (int i = 0; i < controlParqueaderos.devolverCantidadParqueaderos(); i++) {
            parqueadero = controlParqueaderos.devolverParqueadero(i);
            this.agregarRegistro(parqueadero);
        }
    }

    public void agregarRegistro(Parqueadero parqueadero) {
        String nombre, clave, estado, direccion, localidad, tipoParqueadero,
                factorDemandaZonal, tipoSuelo, cantidadNiveles;
        nombre = parqueadero.getNombre();
        clave = parqueadero.getDireccion();
        if (parqueadero.isEstado()) {
            estado = "Abierto";
        } else {
            estado = "Cerrado";
        }
        direccion = parqueadero.getDireccion();
        localidad = parqueadero.getLocalidad();
        if (parqueadero.isSubterraneo()) {
            tipoParqueadero = "Subterraneo";
        } else {
            tipoParqueadero = "A Nivel";
        }
        factorDemandaZonal = parqueadero.getFactorDemandaZonal() + "";
        tipoSuelo = parqueadero.getTipoSuelo();
        cantidadNiveles = parqueadero.getCantidadNiveles() + "";
        consultaParqueaderosTemplate.getModelo().addRow(
                new Object[]{nombre, clave, estado, direccion, localidad,
                    tipoParqueadero, factorDemandaZonal, tipoSuelo,
                    cantidadNiveles
                }
        );
    }

}
