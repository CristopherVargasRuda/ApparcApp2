package app.client.components.navegacionFuncionario;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class NavegacionFuncionarioComponent implements ActionListener, MouseListener{

    private NavegacionFuncionarioTemplate navegacionFuncionarioTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    
    private String comando;
    private JButton botonSeleccionado;

    public NavegacionFuncionarioComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        comando = "";
        navegacionFuncionarioTemplate = new NavegacionFuncionarioTemplate(this);
    }

    public NavegacionFuncionarioTemplate getNavegacionFuncionarioTemplate() {
        return navegacionFuncionarioTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(
                    navegacionFuncionarioTemplate.getsRecursos().getColorSeleccion()
            );
            if (!comando.equals(e.getActionCommand().trim())) {
                comando = e.getActionCommand().trim();
                botonSeleccionado = boton;
                this.vistaPrincipalComponent.mostrarComponente(e.getActionCommand().trim());
            } else {
                comando = "";
                botonSeleccionado = null;
                this.vistaPrincipalComponent.mostrarComponente("Principal");
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
                    navegacionFuncionarioTemplate.getsRecursos().getColorSeleccion()
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
    
    public void quitarSeleccion () {
        if (navegacionFuncionarioTemplate.getbCerrarSesion()!= botonSeleccionado){
            navegacionFuncionarioTemplate.getbCerrarSesion().setBackground(navegacionFuncionarioTemplate.getsRecursos().getColorNaranja()
            );
        }
        if (navegacionFuncionarioTemplate.getbRegistrarContrato()!= botonSeleccionado){
            navegacionFuncionarioTemplate.getbRegistrarContrato().setBackground(navegacionFuncionarioTemplate.getsRecursos().getColorNaranja()
            );
        }
        if (navegacionFuncionarioTemplate.getbRegistrarSalida()!= botonSeleccionado){
            navegacionFuncionarioTemplate.getbRegistrarSalida().setBackground(navegacionFuncionarioTemplate.getsRecursos().getColorNaranja()
            );
        }
        if (navegacionFuncionarioTemplate.getbRegistrarIngreso()!= botonSeleccionado){
            navegacionFuncionarioTemplate.getbRegistrarIngreso().setBackground(navegacionFuncionarioTemplate.getsRecursos().getColorNaranja()
            );
        }        
    }
 
}
