package app.services;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

public class RecursosService {

    private Color colorNaranja, colorAzulOscuro, colorNavegacionFondo,
            colorGris, colorSeleccion, colorRojo, colorGrisOscuro,
            colorGrisClaro;
    private Font fontTituloUsuario, fontTituloPanel, fontNavegacion, fontText,
            fontBoton, fontSeccion, fontComponente, fontLogo, fontLigera;
    private ImageIcon iCerrar, iMinimizar, iCarro, iLogo;
    private Border bordeNaranja, bordeNegro, bordeSeleccion, bordeSeccion,
            bordeRojo;
    private Cursor cMano;

    static private RecursosService servicio;

    public static RecursosService getService() {
        if (servicio == null) {
            servicio = new RecursosService();
        }
        return servicio;
    }

    private RecursosService() {
        iCerrar = new ImageIcon("resources/img/cerrar.png");
        iMinimizar = new ImageIcon("resources/img/minimizar.png");
        iLogo = new ImageIcon("resources/img/logo.png");
        iCarro = new ImageIcon("resources/img/carro.png");

        colorNaranja = new Color(255, 123, 65);
        colorAzulOscuro = new Color(73, 106, 153);
        colorNavegacionFondo = new Color(221, 221, 221);
        colorGris = new Color(129, 129, 129);
        colorSeleccion = new Color(245, 191, 136);
        colorRojo = new Color(255, 26, 26);
        colorGrisOscuro = new Color(80, 80, 80);
        colorGrisClaro = new Color(249, 246, 249);

        fontTituloUsuario = new Font("Arial Rounded MT Bold", Font.PLAIN, 60);
        fontTituloPanel = new Font("Arial Rounded MT Bold", Font.PLAIN, 16);
        fontNavegacion = new Font("book antiqua", Font.PLAIN, 20);
        fontText = new Font("book antiqua", Font.PLAIN, 18);
        fontBoton = new Font("Arial Rounded MT Bold", Font.PLAIN, 20);
        fontSeccion = new Font("book antiqua", Font.PLAIN, 40);
        fontComponente = new Font("book antiqua", Font.PLAIN, 20);
        fontLogo = new Font("Arial", Font.PLAIN, 100);
        fontLigera = new Font("LuzSans-Book", Font.PLAIN, 12);

        cMano = new Cursor(Cursor.HAND_CURSOR);

        bordeNaranja = BorderFactory.createMatteBorder(0, 0, 2, 0, colorNaranja);
        bordeNegro = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK);
        bordeSeleccion = BorderFactory.createMatteBorder(0, 0, 3, 0, colorSeleccion);
        bordeSeccion = BorderFactory.createMatteBorder(0, 0, 1, 0, colorGris);
        bordeRojo = BorderFactory.createMatteBorder(0, 0, 3, 0, colorRojo);
    }

    public Color getColorNaranja() {
        return colorNaranja;
    }

    public Color getColorAzulOscuro() {
        return colorAzulOscuro;
    }

    public Color getColorNavegacionFondo() {
        return colorNavegacionFondo;
    }

    public Font getFontTituloUsuario() {
        return fontTituloUsuario;
    }

    public Font getFontTituloPanel() {
        return fontTituloPanel;
    }

    public Font getFontNavegacion() {
        return fontNavegacion;
    }

    public ImageIcon getiCerrar() {
        return iCerrar;
    }

    public ImageIcon getiMinimizar() {
        return iMinimizar;
    }

    public ImageIcon getiLogo() {
        return iLogo;
    }

    public Border getBordeNaranja() {
        return bordeNaranja;
    }

    public Border getBordeNegro() {
        return bordeNegro;
    }

    public Color getColorGris() {
        return colorGris;
    }

    public Color getColorSeleccion() {
        return colorSeleccion;
    }

    public Cursor getcMano() {
        return cMano;
    }

    public Border getBordeSeleccion() {
        return bordeSeleccion;
    }

    public Font getFontText() {
        return fontText;
    }

    public Font getFontBoton() {
        return fontBoton;
    }

    public Border getBordeSeccion() {
        return bordeSeccion;
    }

    public Font getFontSeccion() {
        return fontSeccion;
    }

    public Font getFontComponente() {
        return fontComponente;
    }

    public ImageIcon getiCarro() {
        return iCarro;
    }

    public Font getFontLogo() {
        return fontLogo;
    }

    public Border getBordeRojo() {
        return bordeRojo;
    }

    public Color getColorRojo() {
        return colorRojo;
    }

    public Font getFontLigera() {
        return fontLigera;
    }

    public Color getColorGrisOscuro() {
        return colorGrisOscuro;
    }

    public Color getColorGrisClaro() {
        return colorGrisClaro;
    }

}
