package app.client.components.consultaEstadisticas.entradasYSalidas;

import app.services.GraficosAvanzadosService;
import app.client.components.consultaEstadisticas.entradasySalidas.EstadisticaEntradasYSalidasComponent;
import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class EstadisticaEntradasYSalidasTemplate extends JPanel {

    private EstadisticaEntradasYSalidasComponent estadisticaEntradasYSalidasComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private GraficosAvanzadosService sGraficosAvanzados;

    private JTextField tIngresarPlaca, tPlaca, tCantidadEntradas,
            tCantidadSalidas;
    private JLabel lIngresarPlaca, lPlaca, lCantidadEntradas, lCantidadSalidas;
    private JComboBox cbDiaInicio, cbMesInicio, cbAnioInicio, cbPeriodo;
    private JButton bConfirmar;

    //Objetos Tabla
    private JScrollPane pTabla;
    private JPanel pCorner;
    private JTable tabla;
    private JTableHeader header;
    private DefaultTableModel modelo;
    private String[] cabecera = {"Parqueadero", "idServicio", "Coste",
        "Fecha Ingreso", "Hora Ingreso", "Fecha Salida", "Hora Salida"};

    public EstadisticaEntradasYSalidasTemplate(EstadisticaEntradasYSalidasComponent estadisticaEntradasYSalidasComponent) {
        this.estadisticaEntradasYSalidasComponent = estadisticaEntradasYSalidasComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        sGraficosAvanzados = GraficosAvanzadosService.getService();

        this.crearJTextFields();
        this.crearJButtons();
        this.crearJComboBoxes();
        this.crearJLabels();
        this.crearJTable();

        this.setBorder(sRecursos.getBordeNegro());
        this.setBackground(sRecursos.getColorAzulOscuro());
        this.setPreferredSize(new Dimension(880, 900));
        this.setLayout(null);
        this.setVisible(true);
    }

    public void crearJTextFields() {
        // INGRESE PLACA ----------------------------------------------
        tIngresarPlaca = sObjGraficos.construirJTextField(
                "Placa", 440, 50, 180, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(),
                sRecursos.getBordeNaranja(), "c"
        );
        tIngresarPlaca.addFocusListener(estadisticaEntradasYSalidasComponent);
        this.add(tIngresarPlaca);

        // PLACA ----------------------------------------------
        tPlaca = sObjGraficos.construirJTextField(
                "", 470, 280, 120, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(),
                sRecursos.getBordeNaranja(), "c"
        );
        tPlaca.setEnabled(false);
        this.add(tPlaca);

        // ENTRADAS ----------------------------------------------
        tCantidadEntradas = sObjGraficos.construirJTextField(
                "", 470, 350, 120, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(),
                sRecursos.getBordeNaranja(), "c"
        );
        tCantidadEntradas.setEnabled(false);
        this.add(tCantidadEntradas);

        // SALIDAS ----------------------------------------------
        tCantidadSalidas = sObjGraficos.construirJTextField(
                "", 470, 420, 120, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(),
                sRecursos.getBordeNaranja(), "c"
        );
        tCantidadSalidas.setEnabled(false);
        this.add(tCantidadSalidas);
    }

    public void crearJButtons() {
        // BOTÓN CONFIRMAR ---------------------------------------------------
        bConfirmar = sObjGraficos.construirJButton(
                "Confirmar", 700, 145, 150, 50, sRecursos.getcMano(), null,
                sRecursos.getFontBoton(), sRecursos.getColorNaranja(),
                Color.white, null, "c", true
        );
        bConfirmar.addMouseListener(estadisticaEntradasYSalidasComponent);
        bConfirmar.addActionListener(estadisticaEntradasYSalidasComponent);
        this.add(bConfirmar);
    }

    public void crearJComboBoxes() {
        // PERIODO ------------------------------------------------
        cbPeriodo = sObjGraficos.construirJComboBox(
                "Periodo_Día_Mes_Año", 450, 150, 150, 40, Color.WHITE,
                Color.BLACK, "c"
        );
        cbPeriodo.setFont(sRecursos.getFontText());
        cbPeriodo.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbPeriodo.addFocusListener(estadisticaEntradasYSalidasComponent);
        this.add(cbPeriodo);
        
        String texto = "";
        for (int i = 0; i < 31; i++) {
            texto = texto + "_" + i;
        }

        // DIA ------------------------------------------------
        cbDiaInicio = sObjGraficos.construirJComboBox(
                "Día" + texto, 50, 150, 100, 40, Color.WHITE,
                Color.BLACK, "c"
        );
        cbDiaInicio.setFont(sRecursos.getFontText());
        cbDiaInicio.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbDiaInicio.addFocusListener(estadisticaEntradasYSalidasComponent);
        this.add(cbDiaInicio);

        // MES ------------------------------------------------
        cbMesInicio = sObjGraficos.construirJComboBox(
                "Mes_Enero_Febrero_Marzo_Abril_Mayo_Junio_Julio_Agosto_"
                + "Setptiembre_Octubre_Noviembre_Diciembre", 150, 150,
                150, 40, Color.WHITE, Color.BLACK, "c"
        );
        cbMesInicio.setFont(sRecursos.getFontText());
        cbMesInicio.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbMesInicio.addFocusListener(estadisticaEntradasYSalidasComponent);
        this.add(cbMesInicio);

        // AÑO ------------------------------------------------
        cbAnioInicio = sObjGraficos.construirJComboBox(
                "Año_2017_2018_2019_2020_2021", 300, 150, 100, 40, Color.WHITE,
                Color.BLACK, "c"
        );
        cbAnioInicio.setFont(sRecursos.getFontText());
        cbAnioInicio.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbAnioInicio.addFocusListener(estadisticaEntradasYSalidasComponent);
        this.add(cbAnioInicio);
    }

    public void crearJLabels() {
        // INGRESAR PLACA ----------------------------------------------------
        lIngresarPlaca = sObjGraficos.construirJLabel(
                "Ingrese la placa:", 250, 50, 160, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lIngresarPlaca);

        // VEHICULO ----------------------------------------------------
        lPlaca = sObjGraficos.construirJLabel(
                "Vehículo con placa:", 250, 280, 200, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lPlaca);

        // INGRESOS ----------------------------------------------------
        lCantidadEntradas = sObjGraficos.construirJLabel(
                "Cantidad de entradas:", 250, 350, 200, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lCantidadEntradas);

        // SALIDAS ----------------------------------------------------
        lCantidadSalidas = sObjGraficos.construirJLabel(
                "Cantidad de salidas:", 250, 420, 200, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lCantidadSalidas);
    }

    public void crearJTable() {
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(cabecera);

        tabla = new JTable();
        tabla.setModel(modelo);
        tabla.addMouseListener(estadisticaEntradasYSalidasComponent);
        tabla.setRowHeight(40);
        tabla.setShowHorizontalLines(false);
        tabla.setShowVerticalLines(false);

        header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(800, 30));

        pTabla = sObjGraficos.construirPanelBarra(
                tabla, 50, 550, 780, 300, Color.WHITE, null
        );

        header.setDefaultRenderer(
                sGraficosAvanzados.devolverTablaPersonalizada(
                        sRecursos.getColorNaranja(), null, null, Color.WHITE,
                        sRecursos.getFontLigera()
                )
        );

        tabla.setDefaultRenderer(
                Object.class,
                sGraficosAvanzados.devolverTablaPersonalizada(
                        Color.WHITE, sRecursos.getColorGrisClaro(),
                        sRecursos.getColorNaranja(),
                        sRecursos.getColorGrisOscuro(),
                        sRecursos.getFontLigera()
                )
        );

        pTabla.getVerticalScrollBar().setUI(
                sGraficosAvanzados.devolverScrollPersonalizado(
                        7, 10, Color.WHITE, sRecursos.getColorNaranja(),
                        sRecursos.getColorSeleccion()
                )
        );

        pCorner = new JPanel();
        pCorner.setBackground(sRecursos.getColorNaranja());
        pTabla.setCorner(JScrollPane.UPPER_RIGHT_CORNER, pCorner);

        this.add(pTabla);
    }

    public RecursosService getsRecursos() {
        return sRecursos;
    }

    public JTextField gettIngresarPlaca() {
        return tIngresarPlaca;
    }

    public JTextField gettPlaca() {
        return tPlaca;
    }

    public JTextField gettCantidadEntradas() {
        return tCantidadEntradas;
    }

    public JTextField gettCantidadSalidas() {
        return tCantidadSalidas;
    }

    public JComboBox getCbPeriodo() {
        return cbPeriodo;
    }

    public JButton getbConfirmar() {
        return bConfirmar;
    }

    public JScrollPane getpTabla() {
        return pTabla;
    }

    public JPanel getpCorner() {
        return pCorner;
    }

    public JTable getTabla() {
        return tabla;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public JComboBox getCbDiaInicio() {
        return cbDiaInicio;
    }

    public JComboBox getCbMesInicio() {
        return cbMesInicio;
    }

    public JComboBox getCbAnioInicio() {
        return cbAnioInicio;
    }
    
    

}
