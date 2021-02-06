package app.client.components.navegacionAdministrador;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import app.services.RecursosService;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class NavegacionAdministradorComponent implements ActionListener, MouseListener {

    private NavegacionAdministradorTemplate navegacionAdministradorTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;

    private String comando;
    private JButton botonSeleccionado;

    public NavegacionAdministradorComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        comando = "";
        navegacionAdministradorTemplate = new NavegacionAdministradorTemplate(this);
    }

    public NavegacionAdministradorTemplate getNavegacionAdministradorTemplate() {
        return navegacionAdministradorTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(
                    navegacionAdministradorTemplate.getsRecursos().getColorSeleccion()
            );
            if (!comando.equals(e.getActionCommand().trim())) {
                comando = e.getActionCommand().trim();
                botonSeleccionado = boton;
                this.vistaPrincipalComponent.mostrarComponente(e.getActionCommand().trim());
            } else {
                comando = "";
                botonSeleccionado = null;
                this.vistaPrincipalComponent.mostrarComponente("principal");
            }
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
                    navegacionAdministradorTemplate.getsRecursos().getColorSeleccion()
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
        if (navegacionAdministradorTemplate.getbCerrarSesion() != botonSeleccionado) {
            navegacionAdministradorTemplate.getbCerrarSesion().setBackground(
                    navegacionAdministradorTemplate.getsRecursos().getColorNaranja()
            );
        }
        if (navegacionAdministradorTemplate.getbConsultaEstadisticas() != botonSeleccionado) {
            navegacionAdministradorTemplate.getbConsultaEstadisticas().setBackground(
                    navegacionAdministradorTemplate.getsRecursos().getColorNaranja()
            );
        }
        if (navegacionAdministradorTemplate.getbConsultaProcesos() != botonSeleccionado) {
            navegacionAdministradorTemplate.getbConsultaProcesos().setBackground(
                    navegacionAdministradorTemplate.getsRecursos().getColorNaranja()
            );
        }
        if (navegacionAdministradorTemplate.getbRegistrarCoordinador() != botonSeleccionado) {
            navegacionAdministradorTemplate.getbRegistrarCoordinador().setBackground(
                    navegacionAdministradorTemplate.getsRecursos().getColorNaranja()
            );
        }
        if (navegacionAdministradorTemplate.getbRegistrarParqueadero() != botonSeleccionado) {
            navegacionAdministradorTemplate.getbRegistrarParqueadero().setBackground(
                    navegacionAdministradorTemplate.getsRecursos().getColorNaranja()
            );
        }
    }

}
