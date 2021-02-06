package negocio.models;

public class Cliente {
    
    private String primerNombre, segundoNombre, primerApellido, segundoApellido, 
            direccion;
    private int cedula, celular;

    public Cliente() {
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getCedula() {
        return cedula;
    }

    public int getCelular() {
        return celular;
    }
    
    
    
}
