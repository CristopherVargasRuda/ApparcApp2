package app.client.components.consultaEstadisticas.recaudo;

import app.services.GraficosAvanzadosService;
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

public class EstadisticaRecaudoTemplate extends JPanel {

    private EstadisticaRecaudoComponent estadisticaRecaudoComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private GraficosAvanzadosService sGraficosAvanzados;

    private JTextField tTotal;
    private JComboBox cbDiaInicio, cbMesInicio, cbAnioInicio, cbPeriodo;
    private JLabel lTotal;
    private JButton bConfirmar;

    //Objetos Tabla
    private JScrollPane pTabla;
    private JPanel pCorner;
    private JTable tabla;
    private JTableHeader header;
    private DefaultTableModel modelo;
    private String[] cabecera = {"Parqueadero", "Recaudo"};

    public EstadisticaRecaudoTemplate(EstadisticaRecaudoComponent estadisticaRecaudoComponent) {
        this.estadisticaRecaudoComponent = estadisticaRecaudoComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        sGraficosAvanzados = GraficosAvanzadosService.getService();

        this.crearJTextFields();
        this.crearJButtons();
        this.crearJComboBox();
        this.crearJLabels();
        this.crearJTable();

        this.setBorder(sRecursos.getBordeNegro());
        this.setBackground(sRecursos.getColorAzulOscuro());
        this.setPreferredSize(new Dimension(880, 650));
        this.setLayout(null);
        this.setVisible(true);
    }

    public void crearJTextFields() {
        // TOTAL ----------------------------------------------
        tTotal = sObjGraficos.construirJTextField(
                "", 430, 200, 200, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(),
                sRecursos.getBordeNaranja(), "c"
        );
        tTotal.setEnabled(false);
        this.add(tTotal);
    }

    public void crearJButtons() {
        // BOTÓN CONFIRMAR ---------------------------------------------------
        bConfirmar = sObjGraficos.construirJButton(
                "Confirmar", 700, 45, 150, 50, sRecursos.getcMano(), null,
                sRecursos.getFontBoton(), sRecursos.getColorNaranja(),
                Color.white, null, "c", true
        );
        bConfirmar.addMouseListener(estadisticaRecaudoComponent);
        bConfirmar.addActionListener(estadisticaRecaudoComponent);
        this.add(bConfirmar);
    }

    public void crearJComboBox() {
        String texto = "";
        for (int i = 0; i < 31; i++) {
            texto = texto + "_" + i;
        }

        // DIA ------------------------------------------------
        cbDiaInicio = sObjGraficos.construirJComboBox(
                "Día" + texto, 50, 50, 100, 40, Color.WHITE,
                Color.BLACK, "c"
        );
        cbDiaInicio.setFont(sRecursos.getFontText());
        cbDiaInicio.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbDiaInicio.addFocusListener(estadisticaRecaudoComponent);
        this.add(cbDiaInicio);

        // MES ------------------------------------------------
        cbMesInicio = sObjGraficos.construirJComboBox(
                "Mes_Enero_Febrero_Marzo_Abril_Mayo_Junio_Julio_Agosto_"
                + "Setptiembre_Octubre_Noviembre_Diciembre", 150, 50,
                150, 40, Color.WHITE, Color.BLACK, "c"
        );
        cbMesInicio.setFont(sRecursos.getFontText());
        cbMesInicio.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbMesInicio.addFocusListener(estadisticaRecaudoComponent);
        this.add(cbMesInicio);

        // AÑO ------------------------------------------------
        cbAnioInicio = sObjGraficos.construirJComboBox(
                "Año_2017_2018_2019_2020_2021", 300, 50, 100, 40, Color.WHITE,
                Color.BLACK, "c"
        );
        cbAnioInicio.setFont(sRecursos.getFontText());
        cbAnioInicio.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbAnioInicio.addFocusListener(estadisticaRecaudoComponent);
        this.add(cbAnioInicio);

        // PERIODO ------------------------------------------------
        cbPeriodo = sObjGraficos.construirJComboBox(
                "Periodo_Día_Mes_Año", 480, 50, 150, 40, Color.WHITE,
                Color.BLACK, "c"
        );
        cbPeriodo.setFont(sRecursos.getFontText());
        cbPeriodo.setBorder(BorderFactory.createLineBorder(sRecursos.getColorNaranja(), 1));
        cbPeriodo.addFocusListener(estadisticaRecaudoComponent);
        this.add(cbPeriodo);
    }

    public void crearJLabels() {
        // VEHICULO ----------------------------------------------------
        lTotal = sObjGraficos.construirJLabel(
                "Total Recaudo:", 250, 200, 150, 40, null, Color.WHITE,
                null, sRecursos.getFontComponente(), "l"
        );
        this.add(lTotal);
    }

    public void crearJTable() {
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(cabecera);

        tabla = new JTable();
        tabla.setModel(modelo);
        tabla.addMouseListener(estadisticaRecaudoComponent);
        tabla.setRowHeight(40);
        tabla.setShowHorizontalLines(false);
        tabla.setShowVerticalLines(false);

        header = tabla.getTableHeader();
        header.setPreferredSize(new Dimension(800, 30));

        pTabla = sObjGraficos.construirPanelBarra(tabla, 150, 300, 600, 300, Color.WHITE, null);

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

    public JScrollPane getpTabla() {
        return pTabla;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public RecursosService getsRecursos() {
        return sRecursos;
    }

    public JTextField gettTotal() {
        return tTotal;
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

    public JComboBox getCbPeriodo() {
        return cbPeriodo;
    }

    public JLabel getlTotal() {
        return lTotal;
    }

    public JButton getbConfirmar() {
        return bConfirmar;
    }

}
