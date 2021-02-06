package app.client.components.registrarContrato;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class RegistrarContratoComponent implements ActionListener, MouseListener {
    
    private RegistrarContratoTemplate registrarContratoTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    
    private JButton botonSeleccionado;

    public RegistrarContratoComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        registrarContratoTemplate = new RegistrarContratoTemplate(this);
    }

    public RegistrarContratoTemplate getVistaPrincipalComponent() {
        return registrarContratoTemplate;
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
