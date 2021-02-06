package negocio.logic.controlTablas;

import java.util.ArrayList;
import negocio.models.Parqueadero;
import negocio.models.Vehiculo;



public class ControlTablaVehiculos {
    
    private ArrayList<Vehiculo> vehiculos;

    public ControlTablaVehiculos() {
    }

    public Vehiculo devolverVehiculo(int posicion) {
        try {
            return vehiculos.get(posicion);
        } catch (Exception e) {
            return null;
        }
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    public int devolverCantidadVehiculos() {
        return vehiculos.size();
    }
    
    
}
