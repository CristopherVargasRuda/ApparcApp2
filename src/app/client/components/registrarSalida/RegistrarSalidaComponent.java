package app.client.components.registrarSalida;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class RegistrarSalidaComponent implements ActionListener, MouseListener {
    
    private RegistrarSalidaTemplate registrarSalidaTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    
    private JButton botonSeleccionado;

    public RegistrarSalidaComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        registrarSalidaTemplate = new RegistrarSalidaTemplate(this);
    }

    public RegistrarSalidaTemplate getRegistrarSalidaTemplate() {
        return registrarSalidaTemplate;
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
