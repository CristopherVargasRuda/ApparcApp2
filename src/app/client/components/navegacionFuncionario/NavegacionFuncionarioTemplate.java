package app.client.components.navegacionFuncionario;

import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NavegacionFuncionarioTemplate extends JPanel {
    
    private NavegacionFuncionarioComponent navegacionFuncionarioComponent;
    
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private JButton bRegistrarIngreso, bRegistrarSalida, bRegistrarContrato, 
            bCerrarSesion;
    private ImageIcon iDimAux;
        
    public NavegacionFuncionarioTemplate(NavegacionFuncionarioComponent navegacionFuncionarioComponent) {
        this.navegacionFuncionarioComponent = navegacionFuncionarioComponent;
        
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
        //BOTÓN REGISTRAR INGRESO ------------------------------------------
        bRegistrarIngreso = sObjGraficos.construirJButton(
                "Registrar Ingreso", 30, 50, 240, 70, sRecursos.getcMano(), 
                null, sRecursos.getFontNavegacion(), 
                sRecursos.getColorNaranja(), Color.BLACK, null, "c", true
        );
        this.bRegistrarIngreso.addActionListener(navegacionFuncionarioComponent);
        this.bRegistrarIngreso.addMouseListener(navegacionFuncionarioComponent);
        this.add(bRegistrarIngreso);
        
        //BOTÓN GENERAR FACTURA ------------------------------------------
        bRegistrarSalida = sObjGraficos.construirJButton(
                "Registrar Salida", 30, 170, 240, 70, sRecursos.getcMano(), 
                null, sRecursos.getFontNavegacion(), 
                sRecursos.getColorNaranja(), Color.BLACK, null, "c", true
        );
        this.bRegistrarSalida.addActionListener(navegacionFuncionarioComponent);
        this.bRegistrarSalida.addMouseListener(navegacionFuncionarioComponent);
        this.add(bRegistrarSalida);
        
        //BOTÓN REGISTRAR CONTRATO ----------------------------------------
        bRegistrarContrato = sObjGraficos.construirJButton(
                "Registrar Contrato", 30, 290, 240, 70, sRecursos.getcMano(), 
                null, sRecursos.getFontNavegacion(), 
                sRecursos.getColorNaranja(), Color.BLACK, null, "c", true
        );
        this.bRegistrarContrato.addActionListener(navegacionFuncionarioComponent);
        this.bRegistrarContrato.addMouseListener(navegacionFuncionarioComponent);
        this.add(bRegistrarContrato);
        
        //BOTÓN CERRAR SESIÓN ------------------------------------------------
        bCerrarSesion = sObjGraficos.construirJButton(
                "Cerrar Sesión", 30, 410, 240, 70, sRecursos.getcMano(), 
                null, sRecursos.getFontNavegacion(), 
                sRecursos.getColorNaranja(), Color.BLACK, null, "c", true
        );
        this.bCerrarSesion.addActionListener(navegacionFuncionarioComponent);
        this.bCerrarSesion.addMouseListener(navegacionFuncionarioComponent);
        this.add(bCerrarSesion);
    }

    public ObjGraficosService getsObjGraficos() {
        return sObjGraficos;
    }

    public RecursosService getsRecursos() {
        return sRecursos;
    }

    public JButton getbRegistrarIngreso() {
        return bRegistrarIngreso;
    }

    public JButton getbRegistrarSalida() {
        return bRegistrarSalida;
    }

    public JButton getbRegistrarContrato() {
        return bRegistrarContrato;
    }

    public JButton getbCerrarSesion() {
        return bCerrarSesion;
    }
    
    
    
    
}
