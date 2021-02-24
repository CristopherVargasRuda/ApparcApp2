package negocio.models;

public class Servicio {

    private String fechaIngreso, fechaSalida, horaIngreso, horaSalida, placa;
    private int idServicio, valorPago, codigoContrato, codigoParqueadero,
            codigoEspacio, codigoArea;
    private Vehiculo vehiculo;
    private Parqueadero parqueadero;

    public Servicio() {
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getCodigoContrato() {
        return codigoContrato;
    }

    public int getCodigoParqueadero() {
        return codigoParqueadero;
    }

    public void setCodigoParqueadero(int codigoParqueadero) {
        this.codigoParqueadero = codigoParqueadero;
    }

    public void setCodigoContrato(int codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCodigoEspacio() {
        return codigoEspacio;
    }

    public void setCodigoEspacio(int codigoEspacio) {
        this.codigoEspacio = codigoEspacio;
    }

    public int getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(int codigoArea) {
        this.codigoArea = codigoArea;
    }

    public int getValorPago() {
        return valorPago;
    }

    public void setValorPago(int valorPago) {
        this.valorPago = valorPago;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Parqueadero getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

}
