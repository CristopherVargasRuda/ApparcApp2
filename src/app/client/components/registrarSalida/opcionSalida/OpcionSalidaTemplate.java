package app.client.components.registrarSalida.opcionSalida;

import java.awt.Color;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import app.services.*;

public class OpcionSalidaTemplate extends JPanel {

    private OpcionSalidaComponent opcionSalidaComponent;
    private RecursosService sRecursos;
    private ObjGraficosService sObjGraficos;

    private JLabel lblServicio, lblHora, lblDia, lblFormatoHora, lblFormatoDia;
    private JButton btnRegistrar;
    private Date hora, fecha;
    private DateFormat formatoHora, formatoFecha;

    public OpcionSalidaTemplate(OpcionSalidaComponent opcionSalidaComponent) {

        this.opcionSalidaComponent = opcionSalidaComponent;
        sRecursos = RecursosService.getService();
        sObjGraficos = ObjGraficosService.getService();

        this.crearObjetosDecoradores();
        this.crearJPanels();
        this.crearJTextFields();
        this.crearJPasswordFields();
        this.crearJButtons();
        this.crearJCheckBoxes();
        this.crearJLabels();

        this.setBorder(sRecursos.getBordeNegro());
        this.setBackground(sRecursos.getColorAzulOscuro());
        this.setSize(900, 400);
        this.setLayout(null);
        this.setVisible(true);

    }

    public void crearObjetosDecoradores() {
        BorderFactory.createMatteBorder(0, 2, 2, 2, Color.BLACK);
    }

    public void crearJPanels() {

    }

    public void crearJTextFields() {

    }

    public void crearJPasswordFields() {

    }

    public void crearJButtons() {
        btnRegistrar = sObjGraficos.construirJButton("Registrar", 350, 300, 200, 50, sRecursos.getcMano(), null, sRecursos.getFontBoton(), sRecursos.getColorNaranja(), Color.WHITE, null, "c", true);
        btnRegistrar.addActionListener(opcionSalidaComponent);
        btnRegistrar.addMouseListener(opcionSalidaComponent);
        this.add(btnRegistrar);
    }

    public void crearJCheckBoxes() {

    }

    public void crearJLabels() {
        //SERVICIO PARQUEADERO
        lblServicio = sObjGraficos.construirJLabel("Servicio parqueadero", 5, 10, 500, 40, null, Color.WHITE, null, sRecursos.getFontSeccion(), "c");
        this.add(lblServicio);

        //HORA
        lblHora = sObjGraficos.construirJLabel("Hora:", 5, 100, 200, 40, null, Color.WHITE, null, sRecursos.getFontNavegacion(), "c");
        this.add(lblHora);

        //FORMATO HORA
        lblFormatoHora = sObjGraficos.construirJLabel(setHora(), 120, 100, 200, 40, null, Color.WHITE, null, sRecursos.getFontNavegacion(), "c");
        this.add(lblFormatoHora);

        //DIA
        lblDia = sObjGraficos.construirJLabel("Fecha:", 5, 190, 200, 40, null, Color.WHITE, null, sRecursos.getFontNavegacion(), "c");
        this.add(lblDia);

        //FORMATO DIA
        lblFormatoDia = sObjGraficos.construirJLabel(setFecha(), 120, 190, 200, 40, null, Color.WHITE, null, sRecursos.getFontNavegacion(), "c");
        this.add(lblFormatoDia);

    }

    public String setHora() {

        hora = new Date();
        formatoHora = new SimpleDateFormat("HH:mm:ss");

        return formatoHora.format(hora);

    }

    public String setFecha() {

        fecha = new Date();
        formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        return formatoFecha.format(fecha);

    }

//----------------------------GETTERS----------------------------
    public RecursosService getsRecursos() {
        return sRecursos;
    }

}
