package negocio.models;

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

}
