package app.client.components.principalParqueadero;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class PrincipalParqueaderoComponent implements ActionListener, MouseListener {
    
    private PrincipalParqueaderoTemplate principalParqueaderoTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    
    private JButton botonSeleccionado;

    public PrincipalParqueaderoComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        principalParqueaderoTemplate = new PrincipalParqueaderoTemplate(this);
    }

    public PrincipalParqueaderoTemplate getPrincipalParqueaderoTemplate() {
        return principalParqueaderoTemplate;
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
