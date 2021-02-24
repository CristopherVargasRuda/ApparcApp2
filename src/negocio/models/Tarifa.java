package negocio.models;

import java.util.ArrayList;

public class Tarifa {

    private int idTarifa, precioMaximoMinuto;
    private String tipoVehiculo;

    public Tarifa() {
    }

    public int getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    public int getPrecioMaximoMinuto() {
        return precioMaximoMinuto;
    }

    public void setPrecioMaximoMinuto(int precioMaximoMinuto) {
        this.precioMaximoMinuto = precioMaximoMinuto;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public void add(ArrayList<Tarifa> tarifas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
