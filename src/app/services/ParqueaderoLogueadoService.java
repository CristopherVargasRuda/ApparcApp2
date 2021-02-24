package app.services;

import negocio.logic.controlTablas.ControlLogin;
import negocio.models.Parqueadero;
import util.CaException;

public class ParqueaderoLogueadoService {

    private static ParqueaderoLogueadoService servicio;
    private ControlLogin parqueaderoLogueado;
    private Parqueadero parqueadero;

    private ParqueaderoLogueadoService() {
        parqueaderoLogueado = new ControlLogin();
    }

    public boolean verificarDatosUsuario(String nombre, String clave) throws CaException {
        if (parqueaderoLogueado.verificarParqueadero(nombre, clave)) {
            parqueadero = parqueaderoLogueado.getParqueadero();
            return true;
        }
        return false;
    }

    public Parqueadero getParqueadero() {
        return parqueadero;
    }

    public static ParqueaderoLogueadoService getService() {
        if (servicio == null) {
            servicio = new ParqueaderoLogueadoService();
        }
        return servicio;
    }

}
