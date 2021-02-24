package app.client.components.consultaEstadisticas.cantidadServicios;

import app.client.components.consultaEstadisticas.ConsultaEstadisticasComponent;
import negocio.logic.controlTablas.ControlTablaCantidadServicios;
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
import negocio.models.Servicio;

public class EstadisticaCantidadServiciosComponent implements ActionListener, MouseListener, FocusListener {

    private EstadisticaCantidadServiciosTemplate estadisticaCantidadServiciosTemplate;
    private ConsultaEstadisticasComponent consultaEstadisticasComponent;
    private ControlTablaCantidadServicios controlTablasCantidadServicios;

    private String texto;
    private JButton boton;
    private JTextField textField;
    private JComboBox comboBox;
    private Servicio servicio;

    public EstadisticaCantidadServiciosComponent(ConsultaEstadisticasComponent consultaEstadisticasComponent) {
        this.consultaEstadisticasComponent = consultaEstadisticasComponent;
        estadisticaCantidadServiciosTemplate = new EstadisticaCantidadServiciosTemplate(this);
    }

    public EstadisticaCantidadServiciosTemplate getEstadisticaCantidadServiciosTemplate() {
        return estadisticaCantidadServiciosTemplate;
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
                    estadisticaCantidadServiciosTemplate.getsRecursos().getColorSeleccion()
            );
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(
                    estadisticaCantidadServiciosTemplate.getsRecursos().getColorNaranja()
            );
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() instanceof JComboBox) {
            comboBox = ((JComboBox) e.getSource());
            comboBox.setBorder(BorderFactory.createLineBorder(estadisticaCantidadServiciosTemplate.getsRecursos().getColorSeleccion(), 2)
            );
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() instanceof JComboBox) {
            comboBox = ((JComboBox) e.getSource());
            comboBox.setBorder(BorderFactory.createLineBorder(estadisticaCantidadServiciosTemplate.getsRecursos().getColorNaranja(), 1)
            );
        }
    }

    public boolean cargarDatos() {
        // VERIVICACIÓN PERIODO -----------------------------------------------
        texto = (String) estadisticaCantidadServiciosTemplate
                .getCbPeriodo().getSelectedItem();
        if (!texto.equals("Periodo")) {
            controlTablasCantidadServicios.setPeriodo(texto);
        } else {
            estadisticaCantidadServiciosTemplate
                    .getCbPeriodo().setBorder(BorderFactory.createLineBorder(estadisticaCantidadServiciosTemplate
                            .getsRecursos().getColorRojo(), 2
                    )
                    );
            JOptionPane.showMessageDialog(null, "Seleccione un Periodo", "Advertencia", 1);
            return false;
        }

        // VERIVICACIÓN DIA -----------------------------------------------
        texto = (String) estadisticaCantidadServiciosTemplate
                .getCbDiaInicio().getSelectedItem();
        if (!texto.equals("Día")) {
            controlTablasCantidadServicios.setDiaInicio(texto);
        } else {
            estadisticaCantidadServiciosTemplate
                    .getCbDiaInicio().setBorder(BorderFactory.createLineBorder(estadisticaCantidadServiciosTemplate
                            .getsRecursos().getColorRojo(), 2
                    )
                    );
            JOptionPane.showMessageDialog(null, "Seleccione un Día", "Advertencia", 1);
            return false;
        }

        // VERIVICACIÓN MES -----------------------------------------------
        texto = (String) estadisticaCantidadServiciosTemplate
                .getCbMesInicio().getSelectedItem();
        if (!texto.equals("Mes")) {
            controlTablasCantidadServicios.setMesInicio(texto);
        } else {
            estadisticaCantidadServiciosTemplate
                    .getCbMesInicio().setBorder(BorderFactory.createLineBorder(estadisticaCantidadServiciosTemplate
                            .getsRecursos().getColorRojo(), 2
                    )
                    );
            JOptionPane.showMessageDialog(null, "Seleccione un Mes", "Advertencia", 1);
            return false;
        }

        // VERIVICACIÓN AÑO -----------------------------------------------
        texto = (String) estadisticaCantidadServiciosTemplate
                .getCbAnioInicio().getSelectedItem();
        if (!texto.equals("Año")) {
            controlTablasCantidadServicios.setAnioInicio(texto);
        } else {
            estadisticaCantidadServiciosTemplate
                    .getCbAnioInicio().setBorder(BorderFactory.createLineBorder(estadisticaCantidadServiciosTemplate
                            .getsRecursos().getColorRojo(), 2
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
        estadisticaCantidadServiciosTemplate.getCbPeriodo().setSelectedIndex(0);
        estadisticaCantidadServiciosTemplate.getCbDiaInicio().setSelectedIndex(0);
        estadisticaCantidadServiciosTemplate.getCbMesInicio().setSelectedIndex(0);
        estadisticaCantidadServiciosTemplate.getCbAnioInicio().setSelectedIndex(0);
        estadisticaCantidadServiciosTemplate.gettTotalVehiculos().setText("123456");
    }
    
    public void mostrarRegistrosTabla() {
        for (int i = 0; i < controlTablasCantidadServicios.devolverCantidadServicios(); i++) {
            servicio = controlTablasCantidadServicios.devolverServicio(i);
            this.agregarRegistro(servicio);
        }
    }

    public void agregarRegistro(Servicio servicio) {
       /* String parqueadero, vehiculo, fechaIngreso, horaIngreso;
        parqueadero = servicio.getParqueadero().getNombre();
        vehiculo = servicio.getVehiculo().getPlaca();        
        fechaIngreso = servicio.getDiaIngreso() + " / "
                + servicio.getMesIngreso() + " / " + servicio.getAnioIngreso();
        horaIngreso = servicio.getHoraIngreso()+ "";
        estadisticaCantidadServiciosTemplate.getModelo().addRow(
                new Object[]{
                    parqueadero, vehiculo, fechaIngreso, horaIngreso
                }
        );*/
    }

}
