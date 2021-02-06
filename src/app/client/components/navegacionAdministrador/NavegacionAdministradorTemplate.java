package app.client.components.navegacionAdministrador;

import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NavegacionAdministradorTemplate extends JPanel {

    private NavegacionAdministradorComponent navegacionAdministradorComponent;

    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private JButton bRegistrarParqueadero, bRegistrarCoordinador,
            bConsultaProcesos, bConsultaEstadisticas, bCerrarSesion;
    private ImageIcon iDimAux;

    public NavegacionAdministradorTemplate(NavegacionAdministradorComponent navegacionAdministradorComponent) {
        this.navegacionAdministradorComponent = navegacionAdministradorComponent;

        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();

        this.crearJButtons();

        this.setBorder(sRecursos.getBordeNegro());
        this.setBackground(sRecursos.getColorNavegacionFondo());
        this.setSize(300, 530);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void crearJButtons() {
        //BOTÓN REGISTRAR PARQUEADERO ------------------------------------------
        bRegistrarParqueadero = sObjGraficos.construirJButton(
                "Registrar Parqueadero", 30, 30, 240, 70, sRecursos.getcMano(),
                null, sRecursos.getFontNavegacion(),
                sRecursos.getColorNaranja(), Color.BLACK, null, "c", true
        );
        this.bRegistrarParqueadero.addActionListener(navegacionAdministradorComponent);
        this.bRegistrarParqueadero.addMouseListener(navegacionAdministradorComponent);
        this.add(bRegistrarParqueadero);

        //BOTÓN REGISTRAR COORDINADOR ------------------------------------------
        bRegistrarCoordinador = sObjGraficos.construirJButton(
                "Estado Parqueadero", 30, 130, 240, 70, sRecursos.getcMano(),
                null, sRecursos.getFontNavegacion(),
                sRecursos.getColorNaranja(), Color.BLACK, null, "c", true
        );
        this.bRegistrarCoordinador.addActionListener(navegacionAdministradorComponent);
        this.bRegistrarCoordinador.addMouseListener(navegacionAdministradorComponent);
        this.add(bRegistrarCoordinador);

        //BOTÓN CONSULTAR PROCESOS ------------------------------------------
        bConsultaProcesos = sObjGraficos.construirJButton(
                "Consultar Procesos", 30, 230, 240, 70, sRecursos.getcMano(),
                null, sRecursos.getFontNavegacion(),
                sRecursos.getColorNaranja(), Color.BLACK, null, "c", true
        );
        this.bConsultaProcesos.addActionListener(navegacionAdministradorComponent);
        this.bConsultaProcesos.addMouseListener(navegacionAdministradorComponent);
        this.add(bConsultaProcesos);

        //BOTÓN CONSULTAR ESTADÍSTICAS ----------------------------------------
        bConsultaEstadisticas = sObjGraficos.construirJButton(
                "Consultar Estadísticas", 30, 330, 240, 70, sRecursos.getcMano(),
                null, sRecursos.getFontNavegacion(),
                sRecursos.getColorNaranja(), Color.BLACK, null, "c", true
        );
        this.bConsultaEstadisticas.addActionListener(navegacionAdministradorComponent);
        this.bConsultaEstadisticas.addMouseListener(navegacionAdministradorComponent);
        this.add(bConsultaEstadisticas);

        //BOTÓN CERRAR SESIÓN ------------------------------------------------
        bCerrarSesion = sObjGraficos.construirJButton(
                "Cerrar Sesión", 30, 430, 240, 70, sRecursos.getcMano(),
                null, sRecursos.getFontNavegacion(),
                sRecursos.getColorNaranja(), Color.BLACK, null, "c", true
        );
        this.bCerrarSesion.addActionListener(navegacionAdministradorComponent);
        this.bCerrarSesion.addMouseListener(navegacionAdministradorComponent);
        this.add(bCerrarSesion);
    }

    public ObjGraficosService getsObjGraficos() {
        return sObjGraficos;
    }

    public RecursosService getsRecursos() {
        return sRecursos;
    }

    public JButton getbRegistrarParqueadero() {
        return bRegistrarParqueadero;
    }

    public JButton getbRegistrarCoordinador() {
        return bRegistrarCoordinador;
    }

    public JButton getbConsultaProcesos() {
        return bConsultaProcesos;
    }

    public JButton getbConsultaEstadisticas() {
        return bConsultaEstadisticas;
    }

    public JButton getbCerrarSesion() {
        return bCerrarSesion;
    }

}
