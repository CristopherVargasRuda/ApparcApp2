package app.client.components.estadoParqueadero;

import app.services.ObjGraficosService;
import app.services.RecursosService;
import app.services.GraficosAvanzadosService;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class EstadoParqueaderoTemplate extends JPanel {

    private EstadoParqueaderoComponent estadoParqueaderoComponent;
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    
    private JLabel lTitulo, lNombre, lName, lUbicación, rUbicacion, lEstado, rEstado;
    private JTextField tNombre;
    
    private JButton btnBuscar, btnCambiar;
    
    public EstadoParqueaderoTemplate(EstadoParqueaderoComponent estadoParqueaderoComponent) {
        this.estadoParqueaderoComponent = estadoParqueaderoComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();        

        this.crearObjetosDecoradores();
        this.crearJPanels();
        this.crearJTextFields();
        this.crearJPasswordFields();
        this.crearJButtons();
        this.crearJCheckBoxes();
        this.crearJLabels();

        this.setBorder(sRecursos.getBordeNegro());
        this.setBackground(sRecursos.getColorAzulOscuro());
        this.setLayout(null);
        this.setPreferredSize(new Dimension(880, 500));
        this.setVisible(true);
    }

    

    public void crearObjetosDecoradores() {
        
    }

    public void crearJPanels() {

    }

    public void crearJTextFields() {
        tNombre = sObjGraficos.construirJTextField(
                "Nombre del parqueadero", 270, 150, 350, 40, null, Color.WHITE,
                sRecursos.getColorNaranja(), sRecursos.getFontText(), null, "c"
        );
        tNombre.setBorder(sRecursos.getBordeNaranja());
        tNombre.addFocusListener(estadoParqueaderoComponent);
        this.add(tNombre);
    }

    public void crearJPasswordFields() {

    }

    public void crearJButtons() {
        btnBuscar = sObjGraficos.construirJButton("Buscar", 650, 150, 200, 50, sRecursos.getcMano(), null, sRecursos.getFontBoton(), sRecursos.getColorNaranja(), Color.WHITE, null, "c", true);
        btnBuscar.addActionListener(estadoParqueaderoComponent);
        btnBuscar.addMouseListener(estadoParqueaderoComponent);
        this.add(btnBuscar);
        
        btnCambiar = sObjGraficos.construirJButton("Cambiar Estado", 350, 460, 200, 50, sRecursos.getcMano(), null, sRecursos.getFontBoton(), sRecursos.getColorNaranja(), Color.WHITE, null, "c", true);
        btnCambiar.addActionListener(estadoParqueaderoComponent);
        btnCambiar.addMouseListener(estadoParqueaderoComponent);
        this.add(btnCambiar);
        btnCambiar.setVisible(false);
    }

    public void crearJCheckBoxes() {

    }

    public void crearJLabels() {
        // Creacion TITULO ---------------------------------------------------------------------------------------------
        lTitulo = sObjGraficos.construirJLabel(
                "Estado Parqueaderos", 110, 20, 680, 80, null,
                sRecursos.getColorNaranja(), null,
                sRecursos.getFontTituloUsuario(), "c"
        );
        this.add(lTitulo);
        
        lName = sObjGraficos.construirJLabel(
                "Nombre parqueadero", 20, 250, 880, 40, null, Color.WHITE, null,
                sRecursos.getFontSeccion(), "c"
        );
        this.add(lName);
        lName.setVisible(false);
        
        lNombre = sObjGraficos.construirJLabel(
                "Parqueadero:", 70, 150, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lNombre);
        
        
        lUbicación = sObjGraficos.construirJLabel(
                "Ubicaciónn:", 190, 320, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lUbicación);
        lUbicación.setVisible(false);

        lEstado = sObjGraficos.construirJLabel(
                "Estado:", 190, 370, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(lEstado);
        lEstado.setVisible(false);
        
        
        rUbicacion = sObjGraficos.construirJLabel(
                "Localidad - Direccion", 520, 320, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(rUbicacion);
        rUbicacion.setVisible(false);

        rEstado = sObjGraficos.construirJLabel(
                "Abierto Cerrado", 520, 370, 260, 40, null, Color.WHITE, null,
                sRecursos.getFontComponente(), "l"
        );
        this.add(rEstado);
        rEstado.setVisible(false);
        
    }
    public RecursosService getRecursos() {
        return sRecursos;
    }
    
    public JTextField gettNombreParqueadero() {
        return tNombre;
    }

    public JLabel getlName() {
        return lName;
    }

    public JLabel getlUbicación() {
        return lUbicación;
    }

    public JLabel getrUbicacion() {
        return rUbicacion;
    }

    public JLabel getlEstado() {
        return lEstado;
    }

    public JLabel getrEstado() {
        return rEstado;
    }

    public JButton getBtnCambiar() {
        return btnCambiar;
    }
    
    
}
