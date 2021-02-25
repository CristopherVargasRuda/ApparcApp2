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
import java.sql.SQLException;
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
                control.cargarDatosEntradasYSalidas();
                actualizarTabla();
                montarDatos();
            } catch (CaException | ParseException ex) {
                Logger.getLogger(EstadisticaEntradasYSalidasComponent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
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
            switch (texto) {
                case "Enero":
                    control.setMes("1");
                    break;
                case "Febrero":
                    control.setMes("2");
                    break;
                case "Marzo":
                    control.setMes("3");
                    break;
                case "Abril":
                    control.setMes("4");
                    break;
                case "Mayo":
                    control.setMes("5");
                    break;
                case "Junio":
                    control.setMes("6");
                    break;
                case "Julio":
                    control.setMes("7");
                    break;
                case "Agosto":
                    control.setMes("8");
                    break;
                case "Setptiembre":
                    control.setMes("9");
                    break;
                case "Octubre":
                    control.setMes("10");
                    break;
                case "Noviembre":
                    control.setMes("11");
                    break;
                case "Diciembre":
                    control.setMes("12");
                    break;
                default:
                    break;
            }

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
        estadisticaEntradasYSalidasTemplate.gettPlaca().setText(control.getPlaca());
        estadisticaEntradasYSalidasTemplate.gettCantidadEntradas().setText(
                control.getCantidadEntradas() + ""
        );
        estadisticaEntradasYSalidasTemplate.gettCantidadSalidas().setText(
                control.getCantidadSalidas() + ""
        );
        estadisticaEntradasYSalidasTemplate.gettIngresarPlaca().setText("");
        estadisticaEntradasYSalidasTemplate.getCbPeriodo().setSelectedIndex(0);
        estadisticaEntradasYSalidasTemplate.getCbDiaInicio().setSelectedIndex(0);
        estadisticaEntradasYSalidasTemplate.getCbMesInicio().setSelectedIndex(0);
        estadisticaEntradasYSalidasTemplate.getCbAnioInicio().setSelectedIndex(0);
    }
    
    public void actualizarTabla() throws CaException, SQLException, ParseException {
        limpiarTabla();
        this.mostrarRegistrosTabla();
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
        idServicio = servicio.getIdServicio() + "";
        coste = servicio.getValorPago() + "";
        fechaIngreso = servicio.getFechaIngreso();
        horaIngreso = servicio.getHoraIngreso();
        fechaSalida = servicio.getFechaSalida();
        horaSalida = servicio.getHoraSalida();
        estadisticaEntradasYSalidasTemplate.getModelo().addRow(
                new Object[]{
                    parqueadero, idServicio, coste, fechaIngreso, horaIngreso,
                    fechaSalida, horaSalida
                }
        );
    }
    
    public void limpiarTabla() {
        int a = estadisticaEntradasYSalidasTemplate.getModelo().getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            estadisticaEntradasYSalidasTemplate.getModelo().removeRow(
                    estadisticaEntradasYSalidasTemplate.getModelo().getRowCount() - 1
            );
        }
        estadisticaEntradasYSalidasTemplate.repaint();
    }

}
