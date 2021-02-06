package app.client.components.barraSuperior;

import app.services.ObjGraficosService;
import app.services.RecursosService;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BarraSuperiorTemplate extends JPanel{
    
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    
    private String tipoUsuario;
    private ImageIcon iDimAux;
    private JButton bCerrar, bMinimizar;
    private JLabel lTextoUsuario, lLogo;
    
    private BarraSuperiorComponent barraSuperiorComponent;

    public BarraSuperiorTemplate(
            BarraSuperiorComponent barraSuperiorComponent, String tipoUsuario
    ) {
        this.barraSuperiorComponent = barraSuperiorComponent;
        this.tipoUsuario = tipoUsuario;
        
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        
        this.crearJButtons();
        this.crearJLabels();
               
        this.setSize(1200, 120);
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        this.setVisible(true);
        this.setBorder(sRecursos.getBordeNegro());
        
        this.addMouseListener(this.barraSuperiorComponent);
        this.addMouseMotionListener(this.barraSuperiorComponent);        
    }
        
    public void crearJButtons(){
        
        // BOTÓN CERRAR ------------------------------------------------
        iDimAux = new ImageIcon(
                sRecursos.getiCerrar().getImage().getScaledInstance(
                        30,30, Image.SCALE_AREA_AVERAGING
                )
        );        
        bCerrar = sObjGraficos.construirJButton(
                null, 1160, 10, 30, 30, sRecursos.getcMano(), iDimAux, null, 
                null, null, null, "c", false
        );
        this.add(bCerrar);
        bCerrar.addActionListener(barraSuperiorComponent);
        
        // BOTÓN MINIMIZAR ------------------------------------------------
        iDimAux = new ImageIcon(
                sRecursos.getiMinimizar().getImage().getScaledInstance(
                        30, 30, Image.SCALE_AREA_AVERAGING
                )
        );        
        bMinimizar = sObjGraficos.construirJButton(
                null, 1120, 10, 30, 30, sRecursos.getcMano(), iDimAux, null, 
                null, null, null, "c", false
        );
        this.add(bMinimizar);
        bMinimizar.addActionListener(barraSuperiorComponent);
    }
    
    public void crearJLabels(){
        // IMAGEN LOGO ------------------------------------------------
        iDimAux = new ImageIcon(
                sRecursos.getiLogo().getImage().getScaledInstance(
                        350, 98, Image.SCALE_AREA_AVERAGING
                )
        );  
        lLogo = sObjGraficos.construirJLabel(
                null, 0, 11, 350, 98, iDimAux, null, null, null, "c"
        );
        this.add(lLogo);
        
        // TEXTO USUARIO ------------------------------------------------
        lTextoUsuario = sObjGraficos.construirJLabel(
                tipoUsuario, 450, 30, 500, 60, null, 
                sRecursos.getColorGris(), null, 
                sRecursos.getFontTituloUsuario(), "c"
        );
        this.add(lTextoUsuario);
    }

    public JButton getbCerrar() {
        return bCerrar;
    }

    public JButton getbMinimizar() {
        return bMinimizar;
    }
    
    
    
}
