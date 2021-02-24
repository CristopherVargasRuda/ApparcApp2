package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.models.Area;
import negocio.models.Espacio;
import util.CaException;
import util.ServiceLocator;

public class EspacioDAO {

    private Espacio espacio;
    private ArrayList<Espacio> espacios;

    public EspacioDAO() {
        espacio = new Espacio();
    }

 
    public void buscarEspacios(int codigoParqueadero, int codigoArea) throws CaException {
        String sql = "SELECT k_idespacio, i_estado FROM area a, parqueadero p, "
                + "espacio c WHERE a.k_codigoparqueadero = p.k_codigoparqueadero "
                + "AND a.k_idarea = c.k_idarea "
                + "AND p.k_codigoparqueadero = ? "
                + "AND c.k_idarea = ?;";

        ResultSet rs;
        try {
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(sql);
            prepStmt.setInt(1, codigoParqueadero);
            prepStmt.setInt(2, codigoArea);
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                espacio = new Espacio();
                espacio.setIdEspacio(rs.getInt("k_idespacio"));
                espacio.setEstado(rs.getBoolean("i_estado"));
                espacios.add(espacio);
            }
        } catch (SQLException e) {
            throw new CaException("EspacioDAO", "No se pudo cargar los datos del espacio" + e.getMessage());
        } finally {
            ServiceLocator.getInstance().liberarConexion();
        }
    }

 
    public Espacio getEspacio() {
        return espacio;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }

    public ArrayList<Espacio> getEspacios() {
        return espacios;
    }

    public void setEspacios(ArrayList<Espacio> espacios) {
        this.espacios = espacios;
    }

}
