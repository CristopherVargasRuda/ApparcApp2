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
    private int cantidadIngresos, cantidadSalidas, cantidadServicios,
            recaudoTotal, recaudoParcial;

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

    public void cargarCantidadServiciosPorPlaca(String placa, String fechaIngreso, String fechaSalida) throws CaException, ParseException {
        Date fechaIngresoDate = Date.valueOf(fechaIngreso);
        Date fechaSalidaDate = Date.valueOf(fechaSalida);
        String sql = "SELECT COUNT(f_ingreso) AS entradas, "
                + "COUNT(f_salida) AS salidas FROM servicio "
                + "WHERE k_placa = ? AND f_ingreso BETWEEN ? AND ?;";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setString(1, placa);
            prepStmt.setDate(2, fechaIngresoDate);
            prepStmt.setDate(3, fechaSalidaDate);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                cantidadIngresos = rs.getInt("entradas");
                cantidadSalidas = rs.getInt("salidas");
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
            throw new CaException("ServicioDAO", "No se pudo cargar los datos del  Servicio" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void cargarTodosLosServiciosPorPeriodo(String fechaIngreso, String fechaSalida) throws CaException, ParseException {
        Date fechaIngresoDate = Date.valueOf(fechaIngreso);
        Date fechaSalidaDate = Date.valueOf(fechaSalida);
        String sql = "SELECT * FROM servicio "
                + "WHERE f_ingreso BETWEEN ? AND ?;";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setDate(1, fechaIngresoDate);
            prepStmt.setDate(2, fechaSalidaDate);
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

    public void cargarCantidadTotalServicios(String fechaIngreso, String fechaSalida) throws CaException, ParseException {
        Date fechaIngresoDate = Date.valueOf(fechaIngreso);
        Date fechaSalidaDate = Date.valueOf(fechaSalida);
        String sql = "SELECT COUNT(k_idservicio) AS cantidad "
                + "FROM servicio WHERE f_ingreso BETWEEN ? AND ?;";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setDate(1, fechaIngresoDate);
            prepStmt.setDate(2, fechaSalidaDate);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                cantidadServicios = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
            throw new CaException("ServicioDAO", "No se pudo cargar los datos del  Servicio" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void calcularTotalParcial(String fechaIngreso, String fechaSalida, int codigoParqueadero) throws CaException, ParseException {
        Date fechaIngresoDate = Date.valueOf(fechaIngreso);
        Date fechaSalidaDate = Date.valueOf(fechaSalida);
        String sql = "SELECT SUM(v_pagototal) AS cantidad"
                + " FROM servicio se, parqueadero pa"
                + " WHERE pa.k_codigoparqueadero = se.k_codigoparqueadero"
                + " AND pa.k_codigoparqueadero = ?"
                + " AND se.f_salida BETWEEN ? AND ?;";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setInt(1, codigoParqueadero);
            prepStmt.setDate(2, fechaIngresoDate);
            prepStmt.setDate(3, fechaSalidaDate);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                recaudoParcial = rs.getInt("cantidad");
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
            throw new CaException("ServicioDAO", "No se pudo cargar los datos del  Servicio" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void calcularTotal(String fechaIngreso, String fechaSalida) throws CaException, ParseException {
        Date fechaIngresoDate = Date.valueOf(fechaIngreso);
        Date fechaSalidaDate = Date.valueOf(fechaSalida);
        String sql = "SELECT SUM(v_pagototal) AS cantidad FROM servicio se"
                + " WHERE se.f_salida BETWEEN ? AND ?;";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setDate(1, fechaIngresoDate);
            prepStmt.setDate(2, fechaSalidaDate);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                recaudoTotal = rs.getInt("cantidad");
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

    public int getCantidadIngresos() {
        return cantidadIngresos;
    }

    public void setCantidadIngresos(int cantidadIngresos) {
        this.cantidadIngresos = cantidadIngresos;
    }

    public int getCantidadSalidas() {
        return cantidadSalidas;
    }

    public void setCantidadSalidas(int cantidadSalidas) {
        this.cantidadSalidas = cantidadSalidas;
    }

    public int getCantidadServicios() {
        return cantidadServicios;
    }

    public void setCantidadServicios(int cantidadServicios) {
        this.cantidadServicios = cantidadServicios;
    }

    public int getRecaudoTotal() {
        return recaudoTotal;
    }

    public void setRecaudoTotal(int recaudoTotal) {
        this.recaudoTotal = recaudoTotal;
    }

    public int getRecaudoParcial() {
        return recaudoParcial;
    }

    public void setRecaudoParcial(int recaudoParcial) {
        this.recaudoParcial = recaudoParcial;
    }
    
    

}
