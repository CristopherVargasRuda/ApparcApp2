package app.client.components.barraSuperior;

import app.client.vistaPrincipal.VistaPrincipalComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class BarraSuperiorComponent implements ActionListener, MouseListener, 
        MouseMotionListener {

    private BarraSuperiorTemplate barraSuperiorTemplate;
    private VistaPrincipalComponent vistaPrincipalComponent;
    private int posicionInicialX, posicionInicialY;

    public BarraSuperiorComponent(
            VistaPrincipalComponent vistaPrincipalComponent, String tipoUsuario
    ) {
        this.vistaPrincipalComponent = vistaPrincipalComponent;
        barraSuperiorTemplate = new BarraSuperiorTemplate(this, tipoUsuario);
    }

    public BarraSuperiorTemplate getBarraSuperiorTemplate() {
        return barraSuperiorTemplate;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == barraSuperiorTemplate.getbCerrar()){
            System.exit(0);
        }
        if (e.getSource() == barraSuperiorTemplate.getbMinimizar()){
            vistaPrincipalComponent.minimizar();
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
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.vistaPrincipalComponent.moverVentana(
                e.getXOnScreen() - posicionInicialX, e.getYOnScreen() - posicionInicialY
        );
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}
