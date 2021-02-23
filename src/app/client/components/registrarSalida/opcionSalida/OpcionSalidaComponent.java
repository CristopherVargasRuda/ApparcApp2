package app.client.components.registrarSalida.opcionSalida;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import app.client.components.registrarSalida.RegistrarSalidaComponent;

public class OpcionSalidaComponent implements ActionListener, MouseListener, FocusListener {

    private RegistrarSalidaComponent registrarSalidaComponent;
    private OpcionSalidaTemplate opcionSalidaTemplate;

    private JButton boton;

    public OpcionSalidaComponent(RegistrarSalidaComponent registrarSalidaComponent) {

        this.registrarSalidaComponent = registrarSalidaComponent;

        opcionSalidaTemplate = new OpcionSalidaTemplate(this);

    }

    public OpcionSalidaTemplate getOpcionSalidaTemplate() {
        return opcionSalidaTemplate;
    }

    @Override
    public void focusGained(FocusEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void focusLost(FocusEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            boton.setBackground(opcionSalidaTemplate.getsRecursos().getColorSeleccion());
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            boton.setBackground(opcionSalidaTemplate.getsRecursos().getColorNaranja());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        opcionSalidaTemplate.removeAll();

        /*Registrar salida servicio en la BD*/
        opcionSalidaTemplate.repaint();

    }

}
