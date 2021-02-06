package app.client.components.consultaEstadisticas.recaudo;

import app.client.components.consultaEstadisticas.ConsultaEstadisticasComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import negocio.logic.controlTablas.ControlTablaRecaudo;
import negocio.models.Servicio;

public class EstadisticaRecaudoComponent implements ActionListener, MouseListener, FocusListener {

    private EstadisticaRecaudoTemplate estadisticaRecaudoTemplate;
    private ConsultaEstadisticasComponent consultaEstadisticasComponent;
    private ControlTablaRecaudo controlTablaRecaudo;

    private String texto;
    private JButton boton;
    private JTextField textField;
    private JComboBox comboBox;
    

    public EstadisticaRecaudoComponent(ConsultaEstadisticasComponent consultaEstadisticasComponent) {
        this.consultaEstadisticasComponent = consultaEstadisticasComponent;
        estadisticaRecaudoTemplate = new EstadisticaRecaudoTemplate(this);
    }

    public EstadisticaRecaudoTemplate getEstadisticaRecaudoTemplate() {
        return estadisticaRecaudoTemplate;
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
        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(
                    estadisticaRecaudoTemplate.getsRecursos().getColorSeleccion()
            );
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(
                    estadisticaRecaudoTemplate.getsRecursos().getColorNaranja()
            );
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() instanceof JComboBox) {
            comboBox = ((JComboBox) e.getSource());
            comboBox.setBorder(BorderFactory.createLineBorder(estadisticaRecaudoTemplate.getsRecursos().getColorSeleccion(), 2)
            );
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof JComboBox) {
            comboBox = ((JComboBox) e.getSource());
            comboBox.setBorder(BorderFactory.createLineBorder(estadisticaRecaudoTemplate.getsRecursos().getColorNaranja(), 1)
            );
        }
    }

    public boolean cargarDatos() {
        // VERIVICACIÓN PERIODO -----------------------------------------------
        texto = (String) estadisticaRecaudoTemplate
                .getCbPeriodo().getSelectedItem();
        if (!texto.equals("Periodo")) {
            controlTablaRecaudo.setPeriodo(texto);
        } else {
            estadisticaRecaudoTemplate
                    .getCbPeriodo().setBorder(BorderFactory.createLineBorder(estadisticaRecaudoTemplate
                            .getsRecursos().getColorRojo(), 2
                    )
                    );
            JOptionPane.showMessageDialog(null, "Seleccione un Periodo", "Advertencia", 1);
            return false;
        }

        // VERIVICACIÓN DIA -----------------------------------------------
        texto = (String) estadisticaRecaudoTemplate
                .getCbDiaInicio().getSelectedItem();
        if (!texto.equals("Día")) {
            controlTablaRecaudo.setDiaInicio(texto);
        } else {
            estadisticaRecaudoTemplate
                    .getCbDiaInicio().setBorder(BorderFactory.createLineBorder(estadisticaRecaudoTemplate
                            .getsRecursos().getColorRojo(), 2
                    )
                    );
            JOptionPane.showMessageDialog(null, "Seleccione un Día", "Advertencia", 1);
            return false;
        }

        // VERIVICACIÓN MES -----------------------------------------------
        texto = (String) estadisticaRecaudoTemplate
                .getCbMesInicio().getSelectedItem();
        if (!texto.equals("Mes")) {
            controlTablaRecaudo.setMesInicio(texto);
        } else {
            estadisticaRecaudoTemplate
                    .getCbMesInicio().setBorder(BorderFactory.createLineBorder(estadisticaRecaudoTemplate
                            .getsRecursos().getColorRojo(), 2
                    )
                    );
            JOptionPane.showMessageDialog(null, "Seleccione un Mes", "Advertencia", 1);
            return false;
        }

        // VERIVICACIÓN AÑO -----------------------------------------------
        texto = (String) estadisticaRecaudoTemplate
                .getCbAnioInicio().getSelectedItem();
        if (!texto.equals("Año")) {
            controlTablaRecaudo.setAnioInicio(texto);
        } else {
            estadisticaRecaudoTemplate
                    .getCbAnioInicio().setBorder(BorderFactory.createLineBorder(estadisticaRecaudoTemplate
                            .getsRecursos().getColorRojo(), 2
                    )
                    );
            JOptionPane.showMessageDialog(null, "Seleccione un Año", "Advertencia", 1);
            return false;
        }

        return true;
    }

    public void mostrarRegistrosTabla() {
        String parqueadero;
        String recaudo;
        for (int i = 0; i < controlTablaRecaudo.devolverCantidadParqueaderos(); i++) {
            parqueadero = controlTablaRecaudo.devolverParqueadero(i);
            recaudo = controlTablaRecaudo.devolverRecaudo(i);
            estadisticaRecaudoTemplate.getModelo().addRow(
                    new Object[]{
                        parqueadero, recaudo
                    }
            );
        }
    }

}
