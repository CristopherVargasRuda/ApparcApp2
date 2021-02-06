package app.client.components.registrarSalida.opcionContrato;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import app.client.components.registrarSalida.opcionSalida.OpcionSalidaComponent;
import app.services.*;

public class OpcionContratoTemplate extends JPanel {

    private OpcionContratoComponent opcionContratoComponent;
    private RecursosService sRecursos;
    private ObjGraficosService sObjGraficos;

    private JPanel pInferior;
    private JLabel lblSalidaRegistrada;
    private JButton btnAceptar;

    public OpcionContratoTemplate(OpcionContratoComponent opcionContratoComponent) {

        this.opcionContratoComponent = opcionContratoComponent;
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
        //ACEPTAR
        btnAceptar = sObjGraficos.construirJButton("Aceptar", 350, 260, 200, 50, sRecursos.getcMano(), null, sRecursos.getFontBoton(), sRecursos.getColorNaranja(), Color.WHITE, null, "c", true);
        btnAceptar.addActionListener(opcionContratoComponent);
        btnAceptar.addMouseListener(opcionContratoComponent);
        this.add(btnAceptar);

    }

    public void crearJCheckBoxes() {

    }

    public void crearJLabels() {
        //MENSAJE SALIDA REGISTRADA
        lblSalidaRegistrada = sObjGraficos.construirJLabel("Registrar salida", 0, 0, 900, 250, null, Color.WHITE, null, sRecursos.getFontTituloUsuario(), "c");
        this.add(lblSalidaRegistrada);

    }

//-------------------------------GETTERS-------------------------------
    public RecursosService getsRecursos() {
        return sRecursos;
    }

    public JPanel getpInferior() {
        return pInferior;
    }

}
