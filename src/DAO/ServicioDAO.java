package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import negocio.models.Servicio;
import util.CaException;
import util.ServiceLocator;

public class ServicioDAO {

    private Servicio servicio;
    private ArrayList<Servicio> servicios;
    private int cantidadIngresos, cantidadSalidas;

    public ServicioDAO() {
        servicio = new Servicio();
    }

    public void insertar() throws CaException {

    }

    public void modificar() {

    }

    public void eliminar() {

    }

    public void buscar() throws CaException {

    }

    public void actualizar() throws CaException {

    }

    public void cargarServiciosPorPlaca(String placa, String fechaIngreso, String fechaSalida) throws CaException, ParseException {
        Date fechaIngresoDate = Date.valueOf(fechaIngreso);
        Date fechaSalidaDate = Date.valueOf(fechaSalida);
        //Time dato = Time.valueOf();
        String sql = "SELECT * FROM servicio "
                + "WHERE k_placa = ? "
                + "AND f_ingreso BETWEEN ? AND ?;";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setString(1, placa);
            prepStmt.setDate(2, fechaIngresoDate);
            prepStmt.setDate(3, fechaSalidaDate);
            rs = prepStmt.executeQuery();
            
            while (rs.next()) {
                servicio = new Servicio();
                servicio.setIdServicio(rs.getInt("k_idservicio"));
                servicio.setFechaIngreso(rs.getString("f_ingreso"));
                servicio.setFechaSalida(rs.getString("f_salida"));
                servicio.setHoraIngreso(rs.getString("o_horaingreso"));
                servicio.setHoraSalida(rs.getString("o_horasalida"));
                servicio.setValorPago(rs.getInt("v_pagototal"));
                servicio.setPlaca(rs.getString("k_placa"));
                servicio.setCodigoEspacio(rs.getInt("k_idespacio"));
                servicio.setCodigoArea(rs.getInt("k_idarea"));
                servicio.setCodigoParqueadero(rs.getInt("k_codigoparqueadero"));
                servicios.add(servicio);
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
            throw new CaException("ServicioDAO", "No se pudo cargar los datos del  Servicio" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

}
