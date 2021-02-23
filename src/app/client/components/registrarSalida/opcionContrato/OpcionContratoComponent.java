package app.client.components.registrarSalida.opcionContrato;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import app.client.components.registrarSalida.RegistrarSalidaComponent;
import app.client.components.registrarSalida.RegistrarSalidaTemplate;

public class OpcionContratoComponent implements ActionListener, MouseListener, FocusListener {

    private RegistrarSalidaComponent registrarSalidaComponent;
    private OpcionContratoTemplate opcionContratoTemplate;

    private JButton boton;

    public OpcionContratoComponent(RegistrarSalidaComponent registrarSalidaComponent) {

        this.registrarSalidaComponent = registrarSalidaComponent;

        opcionContratoTemplate = new OpcionContratoTemplate(this);

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
            boton.setBackground(opcionContratoTemplate.getsRecursos().getColorSeleccion());
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            boton.setBackground(opcionContratoTemplate.getsRecursos().getColorNaranja());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        opcionContratoTemplate.removeAll();

        /*Registrar salida contrato en la BD*/
        opcionContratoTemplate.repaint();

    }

    public RegistrarSalidaComponent getRegistrarSalidaComponent() {
        return registrarSalidaComponent;
    }

    public OpcionContratoTemplate getOpcionContratoTemplate() {
        return opcionContratoTemplate;
    }

}
