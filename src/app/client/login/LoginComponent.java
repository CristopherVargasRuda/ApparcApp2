package app.client.login;

import app.client.vistaPrincipal.VistaPrincipalComponent;
import app.services.ParqueaderoLogueadoService;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import util.CaException;

public class LoginComponent implements ActionListener, FocusListener, MouseListener,
        MouseMotionListener {

    private LoginTemplate loginTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private ParqueaderoLogueadoService parqueaderoService;
    private int posicionInicialX, posicionInicialY;
    private JButton boton;

    public LoginComponent() {
        parqueaderoService = ParqueaderoLogueadoService.getService();
        loginTemplate = new LoginTemplate(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre;
        String clave;
        nombre = loginTemplate.gettNombreUsuario().getText().trim();
        clave = new String(loginTemplate.gettClaveUsuario().getPassword()).trim();
        if (e.getSource() == loginTemplate.getbCerrar()) {
            System.exit(0);
        }
        if (e.getSource() == loginTemplate.getbMinimizar()) {
            minimizar();
        }        
        if (e.getSource() == loginTemplate.getbIngresar()) {
            if (loginTemplate.getCheckAdministrador().isSelected()) {
                if (nombre.equals("administrador")) {
                    if (clave.equals("123456789")) {
                        entrar("Administrador");
                    } else {
                        ingresoFallido("Contraseña Incorrecta");
                    }
                } else {
                    ingresoFallido("Usuario Incorrecto");
                }
            } else {

                try {
                    if (parqueaderoService.verificarDatosUsuario(nombre, clave)) {
                        entrar("Parqueadero");
                    } else {
                        ingresoFallido("Usuario o Contraseña Incorrecta");
                    }
                } catch (CaException ex) {
                    Logger.getLogger(LoginComponent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == loginTemplate.gettNombreUsuario()) {
            loginTemplate.gettNombreUsuario().setBorder(loginTemplate.getsRecursos().getBordeSeleccion());
            if (loginTemplate.gettNombreUsuario().getText().equals("Nombre de usuario")) {
                loginTemplate.gettNombreUsuario().setText("");
            }
        }
        if (e.getSource() == loginTemplate.gettClaveUsuario()) {
            loginTemplate.gettClaveUsuario().setBorder(loginTemplate.getsRecursos().getBordeSeleccion());
            if (new String(loginTemplate.gettClaveUsuario().getPassword()).equals("Clave Usuario")) {
                loginTemplate.gettClaveUsuario().setText("");
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == loginTemplate.gettNombreUsuario()) {
            loginTemplate.gettNombreUsuario().setBorder(loginTemplate.getsRecursos().getBordeNaranja());
            if (loginTemplate.gettNombreUsuario().getText().equals("")) {
                loginTemplate.gettNombreUsuario().setText("Nombre de usuario");
            }
        }
        if (e.getSource() == loginTemplate.gettClaveUsuario()) {
            loginTemplate.gettClaveUsuario().setBorder(loginTemplate.getsRecursos().getBordeNaranja());
            if (new String(loginTemplate.gettClaveUsuario().getPassword()).equals("")) {
                loginTemplate.gettClaveUsuario().setText("Clave Usuario");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        posicionInicialX = e.getX();
        posicionInicialY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            boton.setBackground(
                    loginTemplate.getsRecursos().getColorSeleccion()
            );
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() instanceof JButton) {
            boton = ((JButton) e.getSource());
            boton.setBackground(
                    loginTemplate.getsRecursos().getColorNaranja()
            );
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        moverVentana(
                e.getXOnScreen() - posicionInicialX, e.getYOnScreen() - posicionInicialY
        );
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public void moverVentana(int posicionX, int posicionY) {
        this.loginTemplate.setLocation(posicionX, posicionY);
    }

    public void minimizar() {
        this.loginTemplate.setExtendedState(Frame.ICONIFIED);
    }

    public void entrar(String tipoIngreso) {
        if (vistaPrincipalComponent == null) {
            this.vistaPrincipalComponent = new VistaPrincipalComponent(tipoIngreso);
        } else {
            this.vistaPrincipalComponent.getVistaPrincipalTemplate().setVisible(true);
        }
        loginTemplate.setVisible(false);
    }

    public void ingresoFallido(String texto) {
        JOptionPane.showMessageDialog(null, texto, "Advertencia", 2);
    }
}
