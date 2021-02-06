package app.client.components.consultaEstadisticas;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import app.client.components.consultaEstadisticas.recaudo.EstadisticaRecaudoComponent;
import app.client.components.consultaEstadisticas.cantidadServicios.EstadisticaCantidadServiciosComponent;
import app.client.components.consultaEstadisticas.entradasySalidas.EstadisticaEntradasYSalidasComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class ConsultaEstadisticasComponent implements ActionListener, MouseListener {

    private ConsultaEstadisticasTemplate consultaEstadisticasTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private EstadisticaRecaudoComponent estadisticaRecaudoComponent;
    private EstadisticaEntradasYSalidasComponent estadisticaEntradasYSalidasComponent;
    private EstadisticaCantidadServiciosComponent estadisticaCantidadVehiculosComponent;

    private JButton botonSeleccionado;
    private String comando;

    public ConsultaEstadisticasComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        comando = "";
        consultaEstadisticasTemplate = new ConsultaEstadisticasTemplate(this);
    }

    public ConsultaEstadisticasTemplate getConsultaEstadisticasTemplate() {
        return consultaEstadisticasTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = ((JButton) e.getSource());
        boton.setBackground(
                consultaEstadisticasTemplate.getsRecursos().getColorSeleccion()
        );
        if (!comando.equals(e.getActionCommand().trim())) {
            comando = e.getActionCommand().trim();
            botonSeleccionado = boton;
            consultaEstadisticasTemplate.getpInferior().removeAll();
            if (boton == consultaEstadisticasTemplate.getbRecaudo()) {
                estadisticaRecaudoComponent = new EstadisticaRecaudoComponent(this);
                consultaEstadisticasTemplate.crearScrollpane(
                        estadisticaRecaudoComponent.getEstadisticaRecaudoTemplate()
                );
            }
            if (boton == consultaEstadisticasTemplate.getbCantidadServicios()) {
                estadisticaCantidadVehiculosComponent = new EstadisticaCantidadServiciosComponent(this);
                consultaEstadisticasTemplate.crearScrollpane(
                        estadisticaCantidadVehiculosComponent.getEstadisticaCantidadServiciosTemplate()
                );
            }
            if (boton == consultaEstadisticasTemplate.getbEntradasYSalidas()) {
                estadisticaEntradasYSalidasComponent = new EstadisticaEntradasYSalidasComponent(this);
                consultaEstadisticasTemplate.crearScrollpane(
                        estadisticaEntradasYSalidasComponent.getEstadisticaEntradasYSalidasTemplate()
                );
            }
            consultaEstadisticasTemplate.getpInferior().repaint();
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
                    consultaEstadisticasTemplate.getsRecursos().getColorSeleccion()
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
        if (consultaEstadisticasTemplate.getbRecaudo() != botonSeleccionado) {
            consultaEstadisticasTemplate.getbRecaudo().setBackground(
                    consultaEstadisticasTemplate.getsRecursos().getColorNaranja()
            );
        }
        if (consultaEstadisticasTemplate.getbEntradasYSalidas() != botonSeleccionado) {
            consultaEstadisticasTemplate.getbEntradasYSalidas().setBackground(
                    consultaEstadisticasTemplate.getsRecursos().getColorNaranja()
            );
        }
        if (consultaEstadisticasTemplate.getbCantidadServicios()!= botonSeleccionado) {
            consultaEstadisticasTemplate.getbCantidadServicios().setBackground(
                    consultaEstadisticasTemplate.getsRecursos().getColorNaranja()
            );
        }
    }

}
