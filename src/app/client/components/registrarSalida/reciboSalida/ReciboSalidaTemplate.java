package app.client.components.registrarSalida.reciboSalida;

import app.services.GraficosAvanzadosService;
import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ReciboSalidaTemplate extends JFrame {

    private ReciboSalidaComponent reciboSalidaComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private JPanel pBarraSuperior, pInferior;
    private JLabel lLogo, lFactura, lParqueaderoTitulo, lParqueaderoTexto, 
            lPlacaTitulo, lPlacaTexto, lCodigoTitulo, lCodigoTexto, 
            lfechaIngresoTitulo, lfechaIngresoTexto, lHoraIngresoTitulo, 
            lHoraIngresoTexto, lfechaSalidaTitulo, lfechaSalidaTexto, 
            lHoraSalidaTitulo, lHoraSalidaTexto;
    private ImageIcon iDimAux;
    private JButton bConfirmar;

    public ReciboSalidaTemplate(ReciboSalidaComponent reciboSalidaComponent) {
        this.reciboSalidaComponent = reciboSalidaComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();

        this.crearObjetosDecoradores();
        this.crearJPanels();
        this.crearJTextFields();
        this.crearJPasswordFields();
        this.crearJButtons();
        this.crearJLabels();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 600);
        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(this);
    }

    public void crearObjetosDecoradores() {
        
    }

    public void crearJPanels() {
        pBarraSuperior = sObjGraficos.construirJPanel(
                0, 0, 500, 120, Color.WHITE, null
        );
        this.add(pBarraSuperior);
        
        pInferior = sObjGraficos.construirJPanel(
                0, 120, 500, 480, sRecursos.getColorAzulOscuro(), null
        );
        this.add(pInferior);
    }

    public void crearJTextFields() {
        
    }

    public void crearJPasswordFields() {
        
    }

    public void crearJButtons() {
        // BOTÓN CONFIRMAR ---------------------------------------------------
        bConfirmar = sObjGraficos.construirJButton(
                "CONFIRMAR PAGO", 125, 400, 250, 50,
                sRecursos.getcMano(), null, sRecursos.getFontBoton(),
                sRecursos.getColorNaranja(), Color.white, null,
                "C", true
        );
        bConfirmar.addActionListener(reciboSalidaComponent);
        bConfirmar.addMouseListener(reciboSalidaComponent);
        pInferior.add(bConfirmar);
    }

    public void crearJLabels() {
        // IMAGEN LOGO ------------------------------------------------
        iDimAux = new ImageIcon(
                sRecursos.getiLogo().getImage().getScaledInstance(
                        360, 100, Image.SCALE_AREA_AVERAGING
                )
        );  
        lLogo = sObjGraficos.construirJLabel(
                null, 70, 10, 360, 100, iDimAux, 
                null, null, null, "c"
        );
        pBarraSuperior.add(lLogo);
        
        // FACTURA ---------------------------------------------------------
        lFactura = sObjGraficos.construirJLabel(
                "FACTURA", 0, 20, 500, 40,
                null, sRecursos.getColorNaranja(), null, sRecursos.getFontSeccion(), "c"
        );
        pInferior.add(lFactura);
        
        // PARQUEADERO ---------------------------------------------------------
        lParqueaderoTitulo = sObjGraficos.construirJLabel(
                "PARQUEADERO:", 30, 80, 150, 30,
                null, Color.WHITE, null, sRecursos.getFontTituloPanel(), "l"
        );
        pInferior.add(lParqueaderoTitulo);
        
        lParqueaderoTexto = sObjGraficos.construirJLabel(
                "xxxxxxxxxxxxxx", 200, 80, 150, 30,
                null, Color.WHITE, null, sRecursos.getFontTituloPanel(), "l"
        );
        pInferior.add(lParqueaderoTexto);
        
        // VEHÍCULO ---------------------------------------------------------
        lPlacaTitulo = sObjGraficos.construirJLabel(
                "VEHÍCULO:", 30, 120, 150, 30,
                null, Color.WHITE, null, sRecursos.getFontTituloPanel(), "l"
        );
        pInferior.add(lPlacaTitulo);
        
        lPlacaTexto = sObjGraficos.construirJLabel(
                "xxxxxxxxxxxxxx", 200, 120, 150, 30,
                null, Color.WHITE, null, sRecursos.getFontTituloPanel(), "l"
        );
        pInferior.add(lPlacaTexto);
        
        // CÓDIGO ---------------------------------------------------------
        lCodigoTitulo = sObjGraficos.construirJLabel(
                "CÓDIGO:", 30, 160, 150, 30,
                null, Color.WHITE, null, sRecursos.getFontTituloPanel(), "l"
        );
        pInferior.add(lCodigoTitulo);
        
        lCodigoTexto = sObjGraficos.construirJLabel(
                "xxxxxxxxxxxxxx", 200, 160, 150, 30,
                null, Color.WHITE, null, sRecursos.getFontTituloPanel(), "l"
        );
        pInferior.add(lCodigoTexto);
        
        // FECHA INGRESO ---------------------------------------------------------
        lfechaIngresoTitulo = sObjGraficos.construirJLabel(
                "FECHA INGRESO:", 30, 200, 150, 30,
                null, Color.WHITE, null, sRecursos.getFontTituloPanel(), "l"
        );
        pInferior.add(lfechaIngresoTitulo);
        
        lfechaIngresoTexto = sObjGraficos.construirJLabel(
                "xxxxxxxxxxxxxx", 200, 200, 150, 30,
                null, Color.WHITE, null, sRecursos.getFontTituloPanel(), "l"
        );
        pInferior.add(lfechaIngresoTexto);
        
        // HORA INGRESO ---------------------------------------------------------
        lHoraIngresoTitulo = sObjGraficos.construirJLabel(
                "HORA INGRESO:", 30, 240, 150, 30,
                null, Color.WHITE, null, sRecursos.getFontTituloPanel(), "l"
        );
        pInferior.add(lHoraIngresoTitulo);
        
        lHoraIngresoTexto = sObjGraficos.construirJLabel(
                "xxxxxxxxxxxxxx", 200, 240, 150, 30,
                null, Color.WHITE, null, sRecursos.getFontTituloPanel(), "l"
        );
        pInferior.add(lHoraIngresoTexto);
        
        // FECHA SALIDA ---------------------------------------------------------
        lfechaSalidaTitulo = sObjGraficos.construirJLabel(
                "FECHA SALIDA:", 30, 280, 150, 30,
                null, Color.WHITE, null, sRecursos.getFontTituloPanel(), "l"
        );
        pInferior.add(lfechaSalidaTitulo);
        
        lfechaSalidaTexto = sObjGraficos.construirJLabel(
                "xxxxxxxxxxxxxx", 200, 280, 150, 30,
                null, Color.WHITE, null, sRecursos.getFontTituloPanel(), "l"
        );
        pInferior.add(lfechaSalidaTexto);
        
        // HORA SALIDA ---------------------------------------------------------
        lHoraSalidaTitulo = sObjGraficos.construirJLabel(
                "HORA SALIDA:", 30, 320, 150, 30,
                null, Color.WHITE, null, sRecursos.getFontTituloPanel(), "l"
        );
        pInferior.add(lHoraSalidaTitulo);
        
        lHoraSalidaTexto = sObjGraficos.construirJLabel(
                "xxxxxxxxxxxxxx", 200, 320, 150, 30,
                null, Color.WHITE, null, sRecursos.getFontTituloPanel(), "l"
        );
        pInferior.add(lHoraSalidaTexto);
        
        
    }

    public RecursosService getsRecursos() {
        return sRecursos;
    }

    public JButton getbConfirmar() {
        return bConfirmar;
    }

    public JLabel getlParqueaderoTexto() {
        return lParqueaderoTexto;
    }

    public JLabel getlPlacaTexto() {
        return lPlacaTexto;
    }

    public JLabel getlCodigoTexto() {
        return lCodigoTexto;
    }

    public JLabel getLfechaIngresoTexto() {
        return lfechaIngresoTexto;
    }

    public JLabel getlHoraIngresoTexto() {
        return lHoraIngresoTexto;
    }

    public JLabel getLfechaSalidaTexto() {
        return lfechaSalidaTexto;
    }

    public JLabel getlHoraSalidaTexto() {
        return lHoraSalidaTexto;
    }

    
    
}
