package negocio.logic.controlTablas;

import java.util.ArrayList;
import negocio.models.Contrato;

public class ControlTablaContratos {

    private ArrayList<Contrato> contratos;

    public ControlTablaContratos() {
    }

    public Contrato devolverContrato(int posicion) {
        try {
            return contratos.get(posicion);
        } catch (Exception e) {
            return null;
        }
    }

    public void agregarContrato(Contrato contratos) {
        this.contratos.add(contratos);
    }

    public int devolverCantidadContratos() {
        return contratos.size();
    }

}
