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

import negocio.models.Area;
import negocio.models.Espacio;
import negocio.models.Parqueadero;
import negocio.models.Servicio;
import util.CaException;
import util.ServiceLocator;

public class ServicioDAO {

    private Servicio servicio;
    private Parqueadero parqueadero;
    private ArrayList<Servicio> servicios;
    private int cantidadIngresos, cantidadSalidas, cantidadServicios,
            recaudoTotal, recaudoParcial;
    private ServiceLocator cn;

    public ServicioDAO() {
        servicio = new Servicio();
        parqueadero = new Parqueadero();
        cn = ServiceLocator.getInstance();
    }

    //Actualizar servicio con fecha y hora de salida
    public void actualizarSalidaDAO(String fecha, String hora, String placa) throws CaException, ParseException {
        servicio = new Servicio();

        //Fecha
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
        Date fechaNueva;
        java.util.Date fechaFinal = formato.parse(fecha);
        fechaNueva = new java.sql.Date(fechaFinal.getTime());

        //Hora
        Time horaFinal = Time.valueOf(hora);

        String sql = "UPDATE servicio SET f_salida = ?, o_horasalida = ?"
                + " WHERE k_placa= ?";
        try {
            PreparedStatement pstm;
            pstm = cn.tomarConexion().prepareStatement(sql);
            pstm.setDate(1, fechaNueva);
            pstm.setTime(2, horaFinal);
            pstm.setString(3, placa);
            pstm.executeUpdate();
            pstm.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            System.out.println("Error en DB Cliente: " + e);
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void cargarValorMax(int valMax, int codigoParqueadero, String placa) {
        String sql = "UPDATE servicio SET v_pagototal = ?"
                + " WHERE k_placa= ?"
                + " AND k_codigoparqueadero = ?";
        try {
            PreparedStatement pstm;
            pstm = cn.tomarConexion().prepareStatement(sql);
            pstm.setInt(1, valMax);
            pstm.setString(2, placa);
            pstm.setInt(3, codigoParqueadero);
            pstm.executeUpdate();
            pstm.close();
            ServiceLocator.getInstance().commit();
        } catch (SQLException e) {
            System.out.println("Error en DB Cliente: " + e);
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void cargarFechaInicial(int codigoParqueadero, String placa) {
        ResultSet rs = null;
        String sql = "SELECT o_horaingreso FROM servicio se, parqueadero pa, vehiculo ve"
                + " WHERE ve.k_placa = ?"
                + " AND pa.k_codigoparqueadero = ?; ";
        try {
            PreparedStatement pstm;
            pstm = cn.tomarConexion().prepareStatement(sql);
            pstm.setString(1, placa);
            pstm.setInt(2, codigoParqueadero);
            rs = pstm.executeQuery();
            while (rs.next()) {

            }
        } catch (SQLException e) {
            System.out.println("Error en DB Cliente: " + e);
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void buscarCount() throws CaException {
        String sql = "SELECT k_idservicio FROM servicio ORDER BY k_idservicio DESC limit 1";
        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                servicio = new Servicio();
                servicio.setIdServicio(rs.getInt("k_idservicio"));
            }
        } catch (SQLException e) {
            System.out.println("error: " + e);
            throw new CaException("ServicioDAO", "No se pudo cargar los datos del  Servicio" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

    public void insertar() throws CaException {
        Date fechaIng = Date.valueOf(servicio.getFechaIngreso());
        Time timeIng = Time.valueOf(servicio.getHoraIngreso());

        String sql = "INSERT INTO "
                + " servicio (k_idservicio, f_ingreso, o_horaingreso, f_salida, o_horasalida, v_pagototal, k_placa, k_idespacio, k_codigoparqueadero, k_idarea)"
                + " VALUES"
                + "( ?, ?,?, null, null, null, ?, ?, ?, ?);";
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setInt(1, servicio.getIdServicio());
            prepStmt.setDate(2, fechaIng);
            prepStmt.setTime(3, timeIng);
            prepStmt.setString(4, servicio.getPlaca());
            prepStmt.setInt(5, servicio.getCodigoEspacio());
            prepStmt.setInt(6, parqueadero.getCodigo());
            prepStmt.setInt(7, servicio.getCodigoArea());

            prepStmt.executeUpdate();
            prepStmt.close();
            ServiceLocator.getInstance().commit();

        } catch (SQLException e) {
            throw new CaException("ParqueaderoDAO", "No se pudo insertar la información del vehiculo." + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }

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

    public Parqueadero getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }
}

