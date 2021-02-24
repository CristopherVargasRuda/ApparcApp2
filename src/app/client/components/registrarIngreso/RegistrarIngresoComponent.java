package app.client.components.registrarIngreso;

import app.client.vistaPrincipal.VistaPrincipalComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import java.awt.event.*;

public class RegistrarIngresoComponent implements ActionListener, MouseListener, FocusListener {

    private RegistrarIngresoTemplate registrarIngresoTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private JTextField textField;

    public RegistrarIngresoComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        registrarIngresoTemplate = new RegistrarIngresoTemplate(this);
    }

    public RegistrarIngresoTemplate getRegistrarIngresoTemplate() {
        return registrarIngresoTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Buscar")){
            registrarIngresoTemplate.getlTipo().setVisible(true);
            registrarIngresoTemplate.getCbTipo().setVisible(true);
            registrarIngresoTemplate.getlHoraIng().setVisible(true);
            registrarIngresoTemplate.getlHoraIng2().setVisible(true);
            registrarIngresoTemplate.getlFechaIng().setVisible(true);
            registrarIngresoTemplate.getlFechaIng2().setVisible(true);
            registrarIngresoTemplate.getlCuposDisponibles().setVisible(true);
            registrarIngresoTemplate.getlCupo().setVisible(true);
            registrarIngresoTemplate.gettCupo().setVisible(true);
            registrarIngresoTemplate.getBtnRegistrar().setVisible(true);

        }
        if (e.getActionCommand().equals("Registrar")){

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
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            textField = ((JTextField) e.getSource());
            textField.setBorder(registrarIngresoTemplate.getsRecursos().getBordeSeleccion());
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }
}
