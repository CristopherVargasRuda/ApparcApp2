package app.client.components.consultaProcesos;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import app.client.components.consultaProcesos.contratos.ConsultaContratosComponent;
import app.client.components.consultaProcesos.vehiculos.ConsultaVehiculosComponent;
import app.client.components.consultaProcesos.parqueaderos.ConsultaParqueaderosComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import util.CaException;

public class ConsultarProcesosComponent implements ActionListener, MouseListener {

    private ConsultarProcesosTemplate consultarProcesosTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private ConsultaContratosComponent consultaContratosComponent;
    private ConsultaVehiculosComponent consultaVehiculosComponent;
    private ConsultaParqueaderosComponent consultaParqueaderosComponent;

    private JButton botonSeleccionado;
    private String comando;

    public ConsultarProcesosComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        comando = "";
        consultarProcesosTemplate = new ConsultarProcesosTemplate(this);
    }

    public ConsultarProcesosTemplate getConsultarProcesosTemplate() {
        return consultarProcesosTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = ((JButton) e.getSource());
        boton.setBackground(
                consultarProcesosTemplate.getsRecursos().getColorSeleccion()
        );
        if (!comando.equals(e.getActionCommand().trim())) {
            comando = e.getActionCommand().trim();
            botonSeleccionado = boton;
            consultarProcesosTemplate.getpInferior().removeAll();            
            if (boton == consultarProcesosTemplate.getbVehiculos()) {
                if (consultaVehiculosComponent == null) {
                    consultaVehiculosComponent = new ConsultaVehiculosComponent(this);
                }
                try {
                    consultaVehiculosComponent.actualizarTabla();
                } catch (CaException | SQLException ex) {
                    Logger.getLogger(ConsultarProcesosComponent.class.getName()).log(Level.SEVERE, null, ex);
                }
                consultarProcesosTemplate.getpInferior().add(
                        consultaVehiculosComponent.getConsultaVehiculosTemplate()
                );
            }
            if (boton == consultarProcesosTemplate.getbParqueaderos()) {
                if (consultaParqueaderosComponent == null) {
                    consultaParqueaderosComponent = new ConsultaParqueaderosComponent(this);
                }
                try {
                    consultaParqueaderosComponent.actualizarTabla();
                } catch (CaException | SQLException ex) {
                    Logger.getLogger(ConsultarProcesosComponent.class.getName()).log(Level.SEVERE, null, ex);
                }
                consultarProcesosTemplate.crearScrollpane(
                        consultaParqueaderosComponent.getConsultaParqueaderosTemplate()
                );
            }
            if (boton == consultarProcesosTemplate.getbContratos()) {
                if (consultaContratosComponent == null) {
                    consultaContratosComponent = new ConsultaContratosComponent(this);
                }
                try {
                    consultaContratosComponent.actualizarTabla();
                } catch (CaException | SQLException ex) {
                    Logger.getLogger(ConsultarProcesosComponent.class.getName()).log(Level.SEVERE, null, ex);
                }
                consultarProcesosTemplate.crearScrollpane(
                        consultaContratosComponent.getConsultaContratosTemplate()
                );
            }
            consultarProcesosTemplate.getpInferior().repaint();
        }
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
        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(
                    consultarProcesosTemplate.getsRecursos().getColorSeleccion()
            );
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            quitarSeleccion();
        }
    }

    public void quitarSeleccion() {
        if (consultarProcesosTemplate.getbContratos() != botonSeleccionado) {
            consultarProcesosTemplate.getbContratos().setBackground(
                    consultarProcesosTemplate.getsRecursos().getColorNaranja()
            );
        }
        if (consultarProcesosTemplate.getbVehiculos() != botonSeleccionado) {
            consultarProcesosTemplate.getbVehiculos().setBackground(
                    consultarProcesosTemplate.getsRecursos().getColorNaranja()
            );
        }
        if (consultarProcesosTemplate.getbParqueaderos() != botonSeleccionado) {
            consultarProcesosTemplate.getbParqueaderos().setBackground(
                    consultarProcesosTemplate.getsRecursos().getColorNaranja()
            );
        }
    }

}
