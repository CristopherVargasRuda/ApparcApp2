package negocio.models;

import java.util.Date;

public class Contrato {

    private int idContrato;
    private int valorPago;
    private int codigoParqueadero;
    private int cedulaCliente;
    private String placa;
    private String fechaInicio;
    private String fechaFin;
    private String periodo;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private boolean estadoContrato;

    public Contrato() {
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public int getCodigoParqueadero() {
        return codigoParqueadero;
    }

    public void setCodigoParqueadero(int codigoParqueadero) {
        this.codigoParqueadero = codigoParqueadero;
    }

    public int getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(int cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getValorPago() {
        return valorPago;
    }

    public void setValorPago(int valorPago) {
        this.valorPago = valorPago;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public boolean isEstadoContrato() {
        return estadoContrato;
    }

    public void setEstadoContrato(boolean estadoContrato) {
        this.estadoContrato = estadoContrato;
    }

}
