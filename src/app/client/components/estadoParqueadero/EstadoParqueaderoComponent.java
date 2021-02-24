package app.client.components.estadoParqueadero;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import negocio.logic.ControlEstadosParqueadero;
import negocio.models.Parqueadero;
import util.CaException;

public class EstadoParqueaderoComponent implements ActionListener, MouseListener, FocusListener {

    private EstadoParqueaderoTemplate estadoParqueaderoTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private JTextField textField;
    private ControlEstadosParqueadero controlEstadosP;
    private Parqueadero parqueadero;

    private JButton botonSeleccionado;

    public EstadoParqueaderoComponent(VistaPrincipalComponent vistaPrincipalComponent) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        estadoParqueaderoTemplate = new EstadoParqueaderoTemplate(this);
        controlEstadosP = new ControlEstadosParqueadero();
    }

    public EstadoParqueaderoTemplate getEstadoParqueaderoTemplate() {
        return estadoParqueaderoTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Buscar")) {
            String nombreParqueadero = "";
            if (estadoParqueaderoTemplate.gettNombreParqueadero().getText() != null
                    && !estadoParqueaderoTemplate.gettNombreParqueadero().getText().equals("Nombre del parqueadero")) {
                try {
                    nombreParqueadero = estadoParqueaderoTemplate.gettNombreParqueadero().getText();
                    controlEstadosP.buscarParqueadero(nombreParqueadero);
                    Parqueadero p = controlEstadosP.getParqueadero();
                    estadoParqueaderoTemplate.getlName().setText(p.getNombre());
                    estadoParqueaderoTemplate.getrUbicacion().setText(p.getLocalidad()+" - "+p.getDireccion());
                    String estado = "";
                    if(p.isEstado()){
                        estado = "Activo";
                    }else{
                        estado = "Deshabilitado";
                    }
                    estadoParqueaderoTemplate.getrEstado().setText(estado);
                    
                    estadoParqueaderoTemplate.getlName().setVisible(true);
                    estadoParqueaderoTemplate.getlUbicación().setVisible(true);
                    estadoParqueaderoTemplate.getlEstado().setVisible(true);
                    estadoParqueaderoTemplate.getrEstado().setVisible(true);
                    estadoParqueaderoTemplate.getrUbicacion().setVisible(true);
                    estadoParqueaderoTemplate.getBtnCambiar().setVisible(true);
                } catch (CaException ex) {
                    Logger.getLogger(EstadoParqueaderoComponent.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre valido");
            }
        }
        
        if (e.getActionCommand().equals("Cambiar Estado")) {
            System.out.println("Cambiando estado");
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
            textField.setBorder(estadoParqueaderoTemplate.getRecursos().getBordeSeleccion());
            if (e.getSource() == estadoParqueaderoTemplate.gettNombreParqueadero()
                    && textField.getText().equals("Nombre del parqueadero")) {
                estadoParqueaderoTemplate.gettNombreParqueadero().setText("");
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            textField = ((JTextField) e.getSource());
            textField.setBorder(
                    estadoParqueaderoTemplate.getRecursos().getBordeNaranja()
            );
            if (e.getSource() == estadoParqueaderoTemplate.gettNombreParqueadero()
                    && textField.getText().equals("")) {
                estadoParqueaderoTemplate.gettNombreParqueadero().setText("Nombre del parqueadero");
            }
        }
    }

}
