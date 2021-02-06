package negocio.models;

public class Servicio {

    private String idServicio;
    private int valorPago, diaIngreso, mesIngreso, anioIngreso, diaSalida,
            mesSalida, anioSalida, horaIngreso, horaSalida;
    private Vehiculo vehiculo;
    private Parqueadero parqueadero;

    public Servicio() {
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public int getValorPago() {
        return valorPago;
    }

    public void setValorPago(int valorPago) {
        this.valorPago = valorPago;
    }

    public int getDiaIngreso() {
        return diaIngreso;
    }

    public void setDiaIngreso(int diaIngreso) {
        this.diaIngreso = diaIngreso;
    }

    public int getMesIngreso() {
        return mesIngreso;
    }

    public void setMesIngreso(int mesIngreso) {
        this.mesIngreso = mesIngreso;
    }

    public int getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnioIngreso(int anioIngreso) {
        this.anioIngreso = anioIngreso;
    }

    public int getDiaSalida() {
        return diaSalida;
    }

    public void setDiaSalida(int diaSalida) {
        this.diaSalida = diaSalida;
    }

    public int getMesSalida() {
        return mesSalida;
    }

    public void setMesSalida(int mesSalida) {
        this.mesSalida = mesSalida;
    }

    public int getAnioSalida() {
        return anioSalida;
    }

    public void setAnioSalida(int anioSalida) {
        this.anioSalida = anioSalida;
    }

    public int getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(int horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
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

}
