package app.client.components.estadoParqueadero;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class EstadoParqueaderoComponent implements ActionListener, MouseListener {
    
    private EstadoParqueaderoTemplate estadoParqueaderoTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    
    private JButton botonSeleccionado;

    public EstadoParqueaderoComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        estadoParqueaderoTemplate = new EstadoParqueaderoTemplate(this);
    }

    public EstadoParqueaderoTemplate getEstadoParqueaderoTemplate() {
        return estadoParqueaderoTemplate;
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
    
}
