package app.client.components.consultaEstadisticas.recaudo;

import app.client.components.consultaEstadisticas.ConsultaEstadisticasComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import negocio.logic.controlTablas.ControlTablaRecaudo;
import negocio.models.Servicio;
import util.CaException;

public class EstadisticaRecaudoComponent implements ActionListener, MouseListener, FocusListener {

    private EstadisticaRecaudoTemplate estadisticaRecaudoTemplate;
    private ConsultaEstadisticasComponent consultaEstadisticasComponent;
    private ControlTablaRecaudo controlTablaRecaudo;

    private String texto;
    private JButton boton;
    private JTextField textField;
    private JComboBox comboBox;

    public EstadisticaRecaudoComponent(ConsultaEstadisticasComponent consultaEstadisticasComponent) {
        controlTablaRecaudo = new ControlTablaRecaudo();
        this.consultaEstadisticasComponent = consultaEstadisticasComponent;
        estadisticaRecaudoTemplate = new EstadisticaRecaudoTemplate(this);
    }

    public EstadisticaRecaudoTemplate getEstadisticaRecaudoTemplate() {
        return estadisticaRecaudoTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (cargarDatos()) {
            try {
                controlTablaRecaudo.cargarCantidadServicios();
                actualizarTabla();
            } catch (CaException | ParseException | SQLException ex) {
                Logger.getLogger(EstadisticaRecaudoComponent.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            controlTablaRecaudo.setDia(texto);
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
            switch (texto) {
                case "Enero":
                    controlTablaRecaudo.setMes("1");
                    break;
                case "Febrero":
                    controlTablaRecaudo.setMes("2");
                    break;
                case "Marzo":
                    controlTablaRecaudo.setMes("3");
                    break;
                case "Abril":
                    controlTablaRecaudo.setMes("4");
                    break;
                case "Mayo":
                    controlTablaRecaudo.setMes("5");
                    break;
                case "Junio":
                    controlTablaRecaudo.setMes("6");
                    break;
                case "Julio":
                    controlTablaRecaudo.setMes("7");
                    break;
                case "Agosto":
                    controlTablaRecaudo.setMes("8");
                    break;
                case "Setptiembre":
                    controlTablaRecaudo.setMes("9");
                    break;
                case "Octubre":
                    controlTablaRecaudo.setMes("10");
                    break;
                case "Noviembre":
                    controlTablaRecaudo.setMes("11");
                    break;
                case "Diciembre":
                    controlTablaRecaudo.setMes("12");
                    break;
                default:
                    break;
            }
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
            controlTablaRecaudo.setAnio(texto);
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

    public void actualizarTabla() throws CaException, SQLException, ParseException {
        limpiarTabla();
        this.mostrarRegistrosTabla();
    }

    public void mostrarRegistrosTabla() {
        String parqueadero;
        String recaudo;
        estadisticaRecaudoTemplate.gettTotal().setText(
                controlTablaRecaudo.getTotalRecaudo() + ""
        );
        for (int i = 0; i < controlTablaRecaudo.devolverCantidadParqueaderos(); i++) {
            parqueadero = controlTablaRecaudo.devolverParqueadero(i);
            recaudo = controlTablaRecaudo.devolverRecaudo(i) + "";
            estadisticaRecaudoTemplate.getModelo().addRow(
                    new Object[]{
                        parqueadero, recaudo
                    }
            );
        }
    }

    public void limpiarTabla() {
        int a = estadisticaRecaudoTemplate.getModelo().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            estadisticaRecaudoTemplate.getModelo().removeRow(
                    estadisticaRecaudoTemplate.getModelo().getRowCount() - 1
            );
        }
        estadisticaRecaudoTemplate.repaint();
    }

}
