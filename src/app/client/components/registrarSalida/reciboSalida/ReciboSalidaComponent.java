package app.client.components.registrarSalida.reciboSalida;

import app.services.ParqueaderoLogueadoService;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import negocio.models.Servicio;

public class ReciboSalidaComponent implements ActionListener, MouseListener, FocusListener {

    private ReciboSalidaTemplate reciboSalidaTemplate;
    private ParqueaderoLogueadoService parqueaderoLogueadoService;

    public ReciboSalidaComponent() {
        parqueaderoLogueadoService = ParqueaderoLogueadoService.getService();
        reciboSalidaTemplate = new ReciboSalidaTemplate(this);
    }

    public void MostrarRecibo(Servicio servicio) {
        reciboSalidaTemplate.getlParqueaderoTexto().setText(
                parqueaderoLogueadoService.getParqueadero().getCodigo() + ""
        );
        reciboSalidaTemplate.getlPlacaTexto().setText(servicio.getPlaca());
        reciboSalidaTemplate.getlCodigoTexto().setText(servicio.getIdServicio() + "");
        reciboSalidaTemplate.getLfechaIngresoTexto().setText(servicio.getFechaIngreso());
        reciboSalidaTemplate.getlHoraIngresoTexto().setText(servicio.getHoraIngreso());
        reciboSalidaTemplate.getLfechaSalidaTexto().setText(servicio.getFechaSalida());
        reciboSalidaTemplate.getlHoraSalidaTexto().setText(servicio.getHoraSalida());
        reciboSalidaTemplate.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        reciboSalidaTemplate.setVisible(false);
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
                    reciboSalidaTemplate.getsRecursos().getColorSeleccion()
            );
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton boton = ((JButton) e.getSource());
            boton.setBackground(
                    reciboSalidaTemplate.getsRecursos().getColorNaranja()
            );
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

}