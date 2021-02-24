package app.client.components.consultaEstadisticas.entradasySalidas;

import app.client.components.consultaEstadisticas.ConsultaEstadisticasComponent;
import app.client.components.consultaEstadisticas.entradasYSalidas.EstadisticaEntradasYSalidasTemplate;
import negocio.models.Servicio;
import negocio.logic.controlTablas.ControlTablaEntradasYSalidas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import util.CaException;

public class EstadisticaEntradasYSalidasComponent implements ActionListener, MouseListener, FocusListener {

    private EstadisticaEntradasYSalidasTemplate estadisticaEntradasYSalidasTemplate;
    private ConsultaEstadisticasComponent consultaEstadisticasComponent;
    private Servicio servicio;
    private ControlTablaEntradasYSalidas control;

    private String texto;
    private JButton boton;
    private JTextField textField;
    private JComboBox comboBox;

    public EstadisticaEntradasYSalidasComponent(ConsultaEstadisticasComponent consultaEstadisticasComponent) {
        this.consultaEstadisticasComponent = consultaEstadisticasComponent;
        servicio = new Servicio();
        control = new ControlTablaEntradasYSalidas();
        estadisticaEntradasYSalidasTemplate = new EstadisticaEntradasYSalidasTemplate(this);
    }

    public EstadisticaEntradasYSalidasTemplate getEstadisticaEntradasYSalidasTemplate() {
        return estadisticaEntradasYSalidasTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (cargarDatos()) {
            try {
                control.cargarContrato();
                //montarDatos();
            } catch (CaException ex) {
                Logger.getLogger(EstadisticaEntradasYSalidasComponent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(EstadisticaEntradasYSalidasComponent.class.getName()).log(Level.SEVERE, null, ex);
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
                    estadisticaEntradasYSalidasTemplate.getsRecursos().getColorSeleccion()
            );
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(
                    estadisticaEntradasYSalidasTemplate.getsRecursos().getColorNaranja()
            );
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            textField = ((JTextField) e.getSource());
            textField.setBorder(
                    estadisticaEntradasYSalidasTemplate.getsRecursos().getBordeSeleccion()
            );
            if (e.getSource() == estadisticaEntradasYSalidasTemplate.gettIngresarPlaca()
                    && textField.getText().equals("Placa")) {
                estadisticaEntradasYSalidasTemplate.gettIngresarPlaca().setText("");
            }
        }
        if (e.getSource() instanceof JComboBox) {
            comboBox = ((JComboBox) e.getSource());
            comboBox.setBorder(BorderFactory.createLineBorder(
                    estadisticaEntradasYSalidasTemplate.getsRecursos().getColorSeleccion(), 2)
            );
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof JTextField) {
            textField = ((JTextField) e.getSource());
            textField.setBorder(
                    estadisticaEntradasYSalidasTemplate.getsRecursos().getBordeNaranja()
            );
            if (e.getSource() == estadisticaEntradasYSalidasTemplate.gettIngresarPlaca()
                    && textField.getText().equals("")) {
                estadisticaEntradasYSalidasTemplate.gettIngresarPlaca().setText("Placa");
            }
        }
        if (e.getSource() instanceof JComboBox) {
            comboBox = ((JComboBox) e.getSource());
            comboBox.setBorder(BorderFactory.createLineBorder(
                    estadisticaEntradasYSalidasTemplate.getsRecursos().getColorNaranja(), 1)
            );
        }
    }

    public boolean cargarDatos() {

        // VERIVICACIÓN PLACA -----------------------------------------------
        texto = estadisticaEntradasYSalidasTemplate.gettIngresarPlaca().getText();
        if (!texto.equals("Placa")
                && !texto.equals("")) {
            control.setPlaca(texto);
        } else {
            estadisticaEntradasYSalidasTemplate.gettIngresarPlaca().setBorder(
                    estadisticaEntradasYSalidasTemplate.getsRecursos().getBordeRojo()
            );
            JOptionPane.showMessageDialog(null, "Ingrese un valor para Placa", "Advertencia", 1);
            return false;
        }

        // VERIVICACIÓN PERIODO -----------------------------------------------
        texto = (String) estadisticaEntradasYSalidasTemplate.getCbPeriodo().getSelectedItem();
        if (!texto.equals("Periodo")) {
            control.setPeriodo(texto);
        } else {
            estadisticaEntradasYSalidasTemplate.getCbPeriodo().setBorder(
                    BorderFactory.createLineBorder(
                            estadisticaEntradasYSalidasTemplate.getsRecursos().getColorRojo(), 2
                    )
            );
            JOptionPane.showMessageDialog(null, "Seleccione un Periodo", "Advertencia", 1);
            return false;
        }

        // VERIVICACIÓN DIA -----------------------------------------------
        texto = (String) estadisticaEntradasYSalidasTemplate.getCbDiaInicio().getSelectedItem();
        if (!texto.equals("Día")) {
            control.setDia(texto);
        } else {
            estadisticaEntradasYSalidasTemplate.getCbDiaInicio().setBorder(
                    BorderFactory.createLineBorder(
                            estadisticaEntradasYSalidasTemplate.getsRecursos().getColorRojo(), 2
                    )
            );
            JOptionPane.showMessageDialog(null, "Seleccione un Día", "Advertencia", 1);
            return false;
        }

        // VERIVICACIÓN MES -----------------------------------------------
        texto = (String) estadisticaEntradasYSalidasTemplate.getCbMesInicio().getSelectedItem();
        if (!texto.equals("Mes")) {
            control.setMes(texto);
        } else {
            estadisticaEntradasYSalidasTemplate.getCbMesInicio().setBorder(
                    BorderFactory.createLineBorder(
                            estadisticaEntradasYSalidasTemplate.getsRecursos().getColorRojo(), 2
                    )
            );
            JOptionPane.showMessageDialog(null, "Seleccione un Mes", "Advertencia", 1);
            return false;
        }

        // VERIVICACIÓN AÑO -----------------------------------------------
        texto = (String) estadisticaEntradasYSalidasTemplate.getCbAnioInicio().getSelectedItem();
        if (!texto.equals("Año")) {
            control.setAnio(texto);
        } else {
            estadisticaEntradasYSalidasTemplate.getCbAnioInicio().setBorder(
                    BorderFactory.createLineBorder(
                            estadisticaEntradasYSalidasTemplate.getsRecursos().getColorRojo(), 2
                    )
            );
            JOptionPane.showMessageDialog(null, "Seleccione un Año", "Advertencia", 1);
            return false;
        }

        return true;
    }

    public void montarDatos() {
        /*consultaEntradasYSalidasTemplate.gettPlaca().setText(control.getPlaca());
        consultaEntradasYSalidasTemplate.gettCantidadEntradas().setText(
                control.getCantidadEntradas() + ""
        );
        consultaEntradasYSalidasTemplate.gettCantidadSalidas().setText(
                control.getCantidadSalidas() + ""
        );
        this.mostrarRegistrosTabla();*/
        estadisticaEntradasYSalidasTemplate.gettIngresarPlaca().setText("");
        estadisticaEntradasYSalidasTemplate.getCbPeriodo().setSelectedIndex(0);
        estadisticaEntradasYSalidasTemplate.getCbDiaInicio().setSelectedIndex(0);
        estadisticaEntradasYSalidasTemplate.getCbMesInicio().setSelectedIndex(0);
        estadisticaEntradasYSalidasTemplate.getCbAnioInicio().setSelectedIndex(0);
    }

    public void mostrarRegistrosTabla() {
        for (int i = 0; i < control.devolverCantidadServicios(); i++) {
            servicio = control.devolverServicio(i);
            this.agregarRegistro(servicio);
        }
    }

    public void agregarRegistro(Servicio servicio) {
        String parqueadero, idServicio, coste, fechaIngreso, horaIngreso,
                fechaSalida, horaSalida;
        parqueadero = servicio.getParqueadero().getNombre();
        /*idServicio = servicio.getIdServicio();
        coste = servicio.getValorPago() + "";
        fechaIngreso = servicio.getDiaIngreso() + " / "
                + servicio.getMesIngreso() + " / " + servicio.getAnioIngreso();
        horaIngreso = servicio.getHoraIngreso() + "";
        fechaSalida = servicio.getDiaSalida() + " / "
                + servicio.getMesSalida() + " / " + servicio.getAnioSalida();
        horaSalida = servicio.getHoraSalida() + "";_
        estadisticaEntradasYSalidasTemplate.getModelo().addRow(
                new Object[]{
                    parqueadero, idServicio, coste, fechaIngreso, horaIngreso,
                    fechaSalida, horaSalida
                }
        );*/
    }

}
