package app.client.login;

import app.services.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class LoginTemplate extends JFrame {

    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;
    private GraficosAvanzadosService gAService;
    private JPanel pBarraSuperior, pDerecha, pIzquierda;
    private ImageIcon iUsuario, iContrasena, iDimAux;
    private JTextField tNombreUsuario;
    private JPasswordField tClaveUsuario;
    private JLabel lLogin, lBienvenido, lUsuario, lContrasena, lLogoPanel, 
            lTextoLogo, lLogo;
    private JButton bCerrar, bMinimizar, bIngresar;
    private Border borderIzquierdo, borderDerecho;
    private JCheckBox checkAdministrador;
    private Font fontBienvenido;

    private LoginComponent loginComponent;

    public LoginTemplate(LoginComponent loginComponent) {
        this.loginComponent = loginComponent;

        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();
        gAService = GraficosAvanzadosService.getService();

        this.crearObjetosDecoradores();
        this.crearJPanels();
        this.crearJTextFields();
        this.crearJPasswordFields();        
        this.crearJButtons();
        this.crearJCheckBoxes();
        
        this.crearJLabels();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 650);
        setUndecorated(true);
        setLayout(null);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    public void crearObjetosDecoradores() {
        iUsuario = new ImageIcon("resources/img/usuario.png");
        iContrasena = new ImageIcon("resources/img/contraseña.png");
        
        borderIzquierdo = BorderFactory.createMatteBorder(2, 2, 2, 0, Color.BLACK);
        borderDerecho = BorderFactory.createMatteBorder(2, 0, 2, 2, Color.BLACK);

        fontBienvenido = new Font("Arial", Font.PLAIN, 50);
    }

    public void crearJPanels() {
        pBarraSuperior = sObjGraficos.construirJPanel(
                0, 0, 1200, 130, Color.WHITE, sRecursos.getBordeNegro()
        );
        this.add(pBarraSuperior);
        pBarraSuperior.addMouseListener(loginComponent);
        pBarraSuperior.addMouseMotionListener(loginComponent);

        pIzquierda = sObjGraficos.construirJPanel(0, 130, 700, 520,
                sRecursos.getColorAzulOscuro(), borderIzquierdo);
        this.add(pIzquierda);

        pDerecha = sObjGraficos.construirJPanel(700, 130, 500, 520,
                sRecursos.getColorAzulOscuro(), borderDerecho);
        this.add(pDerecha);
    }

    public void crearJTextFields() {
        tNombreUsuario = sObjGraficos.construirJTextField(
                "Nombre de usuario", (pDerecha.getWidth() - 420) / 2, 150, 420, 
                40, null, Color.WHITE, sRecursos.getColorNaranja(), 
                sRecursos.getFontText(), null, "c"
        );
        tNombreUsuario.setBorder(sRecursos.getBordeNaranja());
        tNombreUsuario.addFocusListener(loginComponent);
        pDerecha.add(tNombreUsuario);
    }

    public void crearJPasswordFields() {
        tClaveUsuario = sObjGraficos.construirJPasswordField("Clave Usuario",
                (pDerecha.getWidth() - 420) / 2, 250, 420, 40, null,
                Color.WHITE, sRecursos.getColorNaranja(),
                sRecursos.getFontText(), null, "c"
        );
        tClaveUsuario.setBorder(sRecursos.getBordeNaranja());
        tClaveUsuario.addFocusListener(loginComponent);
        pDerecha.add(tClaveUsuario);
    }

    public void crearJButtons() {
        // BOTÓN CERRAR ------------------------------------------------
        iDimAux = new ImageIcon(
                sRecursos.getiCerrar().getImage().getScaledInstance(
                        30, 30, Image.SCALE_AREA_AVERAGING
                )
        );
        bCerrar = sObjGraficos.construirJButton(
                null, 1160, 10, 30, 30, sRecursos.getcMano(), iDimAux, null,
                null, null, null, "c", false
        );
        pBarraSuperior.add(bCerrar);
        bCerrar.addActionListener(loginComponent);        

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
        pBarraSuperior.add(bMinimizar);
        bMinimizar.addActionListener(loginComponent);

        // BOTÓN INGRESAR ---------------------------------------------------
        bIngresar = sObjGraficos.construirJButton(
                "INICIAR SESIÓN", (pDerecha.getWidth() - 250) / 2, 420, 250, 50,
                sRecursos.getcMano(), null, sRecursos.getFontBoton(),
                sRecursos.getColorNaranja(), Color.white, null,
                "C", true
        );
        bIngresar.addActionListener(loginComponent);
        bIngresar.addMouseListener(loginComponent);
        pDerecha.add(bIngresar);
    }

    public void crearJCheckBoxes() {
        checkAdministrador = sObjGraficos.construirJCheckBox(
                "  ¿Eres Administrador?", (pDerecha.getWidth() - 300) / 2, 345, 300, 25,
                sRecursos.getcMano(), sRecursos.getFontNavegacion(), Color.WHITE
        );
        checkAdministrador.setHorizontalAlignment(SwingConstants.CENTER);        
        pDerecha.add(checkAdministrador);
    }

    public void crearJLabels() {
        // TITULO -------------------------------------------------------------
        lLogin = sObjGraficos.construirJLabel(
                "LOGIN", 700 + (pDerecha.getWidth() - 320) / 2, 35, 320, 60,
                null, sRecursos.getColorNaranja(), null, sRecursos.getFontTituloUsuario(), "c"
        );
        pBarraSuperior.add(lLogin);

        // BIENVENIDO ---------------------------------------------------------
        lBienvenido = sObjGraficos.construirJLabel(
                "BIENVENIDO", (pDerecha.getWidth() - 320) / 2, 40, 320, 50,
                null, Color.WHITE, null, fontBienvenido, "c"
        );
        pDerecha.add(lBienvenido);

        // IMAGEN LOGO ------------------------------------------------
        iDimAux = new ImageIcon(
                sRecursos.getiCarro().getImage().getScaledInstance(
                        350, 350, Image.SCALE_AREA_AVERAGING
                )
        );
        lLogoPanel = sObjGraficos.construirJLabel(
                null, (pIzquierda.getWidth() - 350) / 2, 20, 350, 350,
                iDimAux, null, null, null, "c"
        );
        pIzquierda.add(lLogoPanel);

        // ICONO USUARIO ------------------------------------------------
        iDimAux = new ImageIcon(
                iUsuario.getImage().getScaledInstance(
                        30, 30, Image.SCALE_AREA_AVERAGING)
        );
        lUsuario = sObjGraficos.construirJLabel(
                null, 0, 155, 30, 30, iDimAux, null, null, null, "c"
        );
        pDerecha.add(lUsuario);

        // ICONO CONTRASEÑA ------------------------------------------------
        iDimAux = new ImageIcon(
                iContrasena.getImage().getScaledInstance(
                        30, 30, Image.SCALE_AREA_AVERAGING)
        );
        lContrasena = sObjGraficos.construirJLabel(
                null, 0, 255, 30, 30, iDimAux, null, null, null, "c"
        );
        pDerecha.add(lContrasena);
        
        // TEXTO LOGO ------------------------------------------------
        lTextoLogo = sObjGraficos.construirJLabel(
                "AparcApp", (pIzquierda.getWidth() - 500) / 2, 320, 500, 100,
                null, Color.WHITE, null, sRecursos.getFontLogo(), "c"
        );
        pIzquierda.add(lTextoLogo);
        
        // IMAGEN LOGO ------------------------------------------------
        iDimAux = new ImageIcon(
                sRecursos.getiLogo().getImage().getScaledInstance(
                        465, 130, Image.SCALE_AREA_AVERAGING
                )
        );  
        lLogo = sObjGraficos.construirJLabel(
                null, (pIzquierda.getWidth() - 500) / 2, 0, 465, 130, iDimAux, 
                null, null, null, "c"
        );
        pBarraSuperior.add(lLogo);
    }

    public RecursosService getsRecursos() {
        return sRecursos;
    }

    public JPanel getpBarraSuperior() {
        return pBarraSuperior;
    }

    public JPanel getpDerecha() {
        return pDerecha;
    }

    public JPanel getpIzquierda() {
        return pIzquierda;
    }

    public ImageIcon getiUsuario() {
        return iUsuario;
    }

    public ImageIcon getiContrasena() {
        return iContrasena;
    }

    public ImageIcon getiDimAux() {
        return iDimAux;
    }

    public JTextField gettNombreUsuario() {
        return tNombreUsuario;
    }

    public JPasswordField gettClaveUsuario() {
        return tClaveUsuario;
    }

    public JLabel getlLogin() {
        return lLogin;
    }

    public JLabel getlBienvenido() {
        return lBienvenido;
    }

    public JLabel getlUsuario() {
        return lUsuario;
    }

    public JLabel getlContrasena() {
        return lContrasena;
    }

    public JLabel getlLogoPanel() {
        return lLogoPanel;
    }

    public JButton getbCerrar() {
        return bCerrar;
    }

    public JButton getbMinimizar() {
        return bMinimizar;
    }

    public JButton getbIngresar() {
        return bIngresar;
    }

    public Border getBorderIzquierdo() {
        return borderIzquierdo;
    }

    public Border getBorderDerecho() {
        return borderDerecho;
    }

    public JCheckBox getCheckAdministrador() {
        return checkAdministrador;
    }

    public Font getFontBienvenido() {
        return fontBienvenido;
    }

    public LoginComponent getLoginComponent() {
        return loginComponent;
    }

}
