package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.models.Tarifa;
import util.CaException;
import util.ServiceLocator;

public class TarifaDAO {

    private Tarifa tarifa;
    private ArrayList<Tarifa> tarifas;

    public TarifaDAO() {
        tarifa = new Tarifa();
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

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public ArrayList<Tarifa> getTarifas() {
        return tarifas;
    }

}
