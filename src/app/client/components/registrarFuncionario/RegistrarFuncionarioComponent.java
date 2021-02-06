package app.client.components.registrarFuncionario;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class RegistrarFuncionarioComponent implements ActionListener, MouseListener {
    
    private RegistrarFuncionarioTemplate registrarFuncionarioTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    
    private JButton botonSeleccionado;

    public RegistrarFuncionarioComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        registrarFuncionarioTemplate = new RegistrarFuncionarioTemplate(this);
    }

    public RegistrarFuncionarioTemplate getRegistrarFuncionarioTemplate() {
        return registrarFuncionarioTemplate;
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
