package app.client.components.registrarSalida;

import app.client.components.registrarSalida.opcionContrato.OpcionContratoComponent;
import app.client.components.registrarSalida.opcionSalida.OpcionSalidaComponent;
import app.client.vistaPrincipal.VistaPrincipalComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegistrarSalidaComponent implements ActionListener, MouseListener, FocusListener {

    private RegistrarSalidaTemplate registrarSalidaTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;

    private OpcionSalidaComponent opcionSalidaComponent;
    private OpcionContratoComponent opcionContratoComponent;

    private JTextField textField;
    private JButton boton;
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

        if (registrarSalidaTemplate.getTxtPlaca().getText().equals("Placa del veh�culo") || registrarSalidaTemplate.getTxtPlaca().getText().equals("")) {

            //Confirmar con la BD si la placa esta registrada...
            registrarSalidaTemplate.getTxtPlaca().setBorder(registrarSalidaTemplate.getsRecursos().getBordeRojo());
            JOptionPane.showMessageDialog(null, "Ingrese una placa valida", "Advertencia", JOptionPane.WARNING_MESSAGE);

        } else {

            registrarSalidaTemplate.getpInferior().removeAll();

            //Info BD necesaria... 
            opcionSalidaComponent = new OpcionSalidaComponent(this);

            registrarSalidaTemplate.crearScrollpane(opcionSalidaComponent.getOpcionSalidaTemplate());

            //opcionContratoComponent = new OpcionContratoComponent(this);
            //registrarSalidaTemplate.crearScrollpane(opcionContratoComponent.getOpcionContratoTemplate());
            registrarSalidaTemplate.getpInferior().repaint();

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            boton.setBackground(
                    registrarSalidaTemplate.getsRecursos().getColorSeleccion());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            boton.setBackground(
                    registrarSalidaTemplate.getsRecursos().getColorNaranja());
        }
    }

    @Override
    public void focusGained(FocusEvent e) {

        if (e.getSource() instanceof JTextField) {
            textField = ((JTextField) e.getSource());
            textField.setBorder(registrarSalidaTemplate.getsRecursos().getBordeSeleccion());
            if (e.getSource() == registrarSalidaTemplate.getTxtPlaca() && textField.getText().equals("Placa del veh�culo")) {
                registrarSalidaTemplate.getTxtPlaca().setText("");
            }

        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            textField = ((JTextField) e.getSource());
            textField.setBorder(
                    registrarSalidaTemplate.getsRecursos().getBordeNaranja()
            );
            if (e.getSource() == registrarSalidaTemplate.getTxtPlaca() && textField.getText().equals("")) {
                registrarSalidaTemplate.getTxtPlaca().setText("Placa del veh�culo");
            }

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

}
