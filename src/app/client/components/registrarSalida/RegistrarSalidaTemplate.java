package app.client.components.registrarSalida;

import app.services.GraficosAvanzadosService;
import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class RegistrarSalidaTemplate extends JPanel {

    private RegistrarSalidaComponent registrarSalidaComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private GraficosAvanzadosService sGraficosAvanzados;

    private JPanel pSuperior, pInferior;
    private JScrollPane scrollpane;
    private JButton btnBuscar;
    private JTextField txtPlaca;
    private JLabel lblPlaca;

    public RegistrarSalidaTemplate(RegistrarSalidaComponent registrarSalidaComponent) {

        this.registrarSalidaComponent = registrarSalidaComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        sGraficosAvanzados = GraficosAvanzadosService.getService();

        this.crearObjetosDecoradores();
        this.crearJPanels();
        this.setBorder(sRecursos.getBordeNegro());
        this.setBackground(sRecursos.getColorAzulOscuro());
        this.setPreferredSize(new Dimension(880, 1000));
        this.setSize(900, 530);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void crearObjetosDecoradores() {

        BorderFactory.createMatteBorder(2, 2, 0, 2, Color.BLACK);
        BorderFactory.createMatteBorder(0, 2, 2, 2, Color.BLACK);
    }

    public void crearJPanels() {

        pSuperior = sObjGraficos.construirJPanel(0, 0, 900, 130, sRecursos.getColorAzulOscuro(), sRecursos.getBordeNegro());
        this.add(pSuperior);

        pInferior = sObjGraficos.construirJPanel(0, 130, 900, 400, sRecursos.getColorAzulOscuro(), sRecursos.getBordeNegro());
        this.add(pInferior);
    }

    public void crearJTextFields() {

        //PLACA
        txtPlaca = sObjGraficos.construirJTextField("Placa del veh�culo", 200, 50, 400, 40, null, Color.WHITE, sRecursos.getColorNaranja(), sRecursos.getFontText(), null, "c");
        txtPlaca.setBorder(sRecursos.getBordeNaranja());
        txtPlaca.addFocusListener(registrarSalidaComponent);
        pSuperior.add(txtPlaca);
    }

    public void crearJPasswordFields() {

    }

    public void crearJButtons() {

        //BUSCAR
        btnBuscar = sObjGraficos.construirJButton("Buscar", 650, 50, 200, 50, sRecursos.getcMano(), null, sRecursos.getFontBoton(), sRecursos.getColorNaranja(), Color.WHITE, null, "c", true);
        btnBuscar.addActionListener(registrarSalidaComponent);
        btnBuscar.addMouseListener(registrarSalidaComponent);
        pSuperior.add(btnBuscar);

    }

    public void crearJCheckBoxes() {

    }

    public void crearJLabels() {
        //PLACA
        lblPlaca = sObjGraficos.construirJLabel("Placa:", 100, 20, 100, 100, null, Color.WHITE, null, sRecursos.getFontBoton(), "c");
        pSuperior.add(lblPlaca);
    }

    public void crearContenidoProductos(JPanel panel) {

        this.scrollpane = sObjGraficos.construirPanelBarra(panel, 0, 0, 898, 400, null, null);
        this.scrollpane.getVerticalScrollBar().setUI(sGraficosAvanzados.devolverScrollPersonalizado(7, 10, Color.WHITE, sRecursos.getColorNaranja(), sRecursos.getColorAzulOscuro()));
        this.pInferior.add(scrollpane);
        this.scrollpane.revalidate();

    }

//--------------------------------GETTERS--------------------------------
    public RecursosService getsRecursos() {
        return sRecursos;
    }

    public JPanel getpInferior() {
        return pInferior;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JTextField getTxtPlaca() {
        return txtPlaca;
    }

    public JPanel getpSuperior() {
        return pSuperior;
    }

}
