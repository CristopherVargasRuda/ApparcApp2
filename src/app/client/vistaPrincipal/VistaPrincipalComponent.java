package app.client.vistaPrincipal;

import app.client.components.barraSuperior.BarraSuperiorComponent;
import app.client.components.navegacionAdministrador.NavegacionAdministradorComponent;
import app.client.components.navegacionFuncionario.NavegacionFuncionarioComponent;
import app.client.components.consultaEstadisticas.ConsultaEstadisticasComponent;
import app.client.components.consultaProcesos.ConsultarProcesosComponent;
import app.client.components.principalParqueadero.PrincipalParqueaderoComponent;
import app.client.components.registrarSalida.RegistrarSalidaComponent;
import app.client.components.registrarContrato.RegistrarContratoComponent;
import app.client.components.estadoParqueadero.EstadoParqueaderoComponent;
import app.client.components.registrarFuncionario.RegistrarFuncionarioComponent;
import app.client.components.registrarIngreso.RegistrarIngresoComponent;
import app.client.components.registrarParqueadero.RegistrarParqueaderoComponent;
import app.client.login.LoginComponent;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

import java.awt.Frame;

public class VistaPrincipalComponent {

    private VistaPrincipalTemplate vistaPrincipalTemplate;

    private BarraSuperiorComponent barraSuperiorComponent;
    private LoginComponent loginComponent;
    private NavegacionAdministradorComponent navegacionAdministradorComponent;
    private NavegacionFuncionarioComponent navegacionFuncionarioComponent;
    private ConsultaEstadisticasComponent consultaEstadisticasComponent;
    private ConsultarProcesosComponent consultarProcesosComponent;
    private RegistrarSalidaComponent generarFacturaComponent;
    private RegistrarContratoComponent registrarContratoComponent;
    private EstadoParqueaderoComponent EstadoParqueaderoComponent;
    private RegistrarFuncionarioComponent registrarFuncionarioComponent;
    private RegistrarIngresoComponent registrarIngresoComponent;
    private RegistrarParqueaderoComponent registrarParqueaderoComponent;
    private PrincipalParqueaderoComponent principalParqueaderoComponent;

    public VistaPrincipalComponent(String tipoIngreso) {
        vistaPrincipalTemplate = new VistaPrincipalTemplate(this);

        barraSuperiorComponent = new BarraSuperiorComponent(this, tipoIngreso);
        vistaPrincipalTemplate.getpBarraSuperior().add(
                barraSuperiorComponent.getBarraSuperiorTemplate()
        );

        if (tipoIngreso.equals("Administrador")) {
            navegacionAdministradorComponent = new NavegacionAdministradorComponent(this);
            vistaPrincipalTemplate.getpNavegacion().add(
                    navegacionAdministradorComponent.getNavegacionAdministradorTemplate()
            );
        } else {
            vistaPrincipalTemplate.getpPrincipal().removeAll();
            navegacionFuncionarioComponent = new NavegacionFuncionarioComponent(this);
            vistaPrincipalTemplate.getpNavegacion().add(
                    navegacionFuncionarioComponent.getNavegacionFuncionarioTemplate()
            );
            if (this.principalParqueaderoComponent == null) {
                this.registrarContratoComponent = new RegistrarContratoComponent(this);
            }
            vistaPrincipalTemplate.crearScrollpane(
                    registrarContratoComponent.getVistaPrincipalComponent()
            );
        }

        vistaPrincipalTemplate.repaint();
    }

    public void mostrarComponente(String comando) {
        vistaPrincipalTemplate.getpPrincipal().removeAll();
        switch (comando) {
            case "Registrar Parqueadero":
                if (this.registrarParqueaderoComponent == null) {
                    this.registrarParqueaderoComponent = new RegistrarParqueaderoComponent(this);
                }
                registrarParqueaderoComponent.limpiarDatos();
                vistaPrincipalTemplate.crearScrollpane(
                        registrarParqueaderoComponent.getRegistrarParqueaderoTemplate()
                );
                break;
            case "Estado Parqueadero":
                if (this.EstadoParqueaderoComponent == null) {
                    this.EstadoParqueaderoComponent = new EstadoParqueaderoComponent(this);
                }
                vistaPrincipalTemplate.crearScrollpane(EstadoParqueaderoComponent.getEstadoParqueaderoTemplate()
                );
                break;
            case "Consultar Procesos":
                this.consultarProcesosComponent = new ConsultarProcesosComponent(this);
                vistaPrincipalTemplate.getpPrincipal().add(
                        consultarProcesosComponent.getConsultarProcesosTemplate()
                );

                break;
            case "Consultar Estadísticas":
                this.consultaEstadisticasComponent = new ConsultaEstadisticasComponent(this);

                vistaPrincipalTemplate.crearScrollpane(
                        consultaEstadisticasComponent.getConsultaEstadisticasTemplate()
                );
                break;
            case "Registrar Funcionario":
                if (this.registrarFuncionarioComponent == null) {
                    this.registrarFuncionarioComponent = new RegistrarFuncionarioComponent(this);
                }
                vistaPrincipalTemplate.crearScrollpane(
                        registrarFuncionarioComponent.getRegistrarFuncionarioTemplate()
                );
                break;
            case "Registrar Ingreso":
                if (this.registrarIngresoComponent == null) {
                    this.registrarIngresoComponent = new RegistrarIngresoComponent(this);
                }
                vistaPrincipalTemplate.crearScrollpane(
                        registrarIngresoComponent.getRegistrarIngresoTemplate()
                );
                break;
            case "Registrar Salida":
                if (this.generarFacturaComponent == null) {
                    this.generarFacturaComponent = new RegistrarSalidaComponent(this);
                }
                vistaPrincipalTemplate.crearScrollpane(
                        generarFacturaComponent.getRegistrarSalidaTemplate()
                );
                break;
            case "Registrar Contrato":
                if (this.registrarContratoComponent == null) {
                    this.registrarContratoComponent = new RegistrarContratoComponent(this);
                }
                vistaPrincipalTemplate.crearScrollpane(
                        registrarContratoComponent.getVistaPrincipalComponent()
                );
                break;
            case "Principal":
                if (this.principalParqueaderoComponent == null) {
                    this.registrarContratoComponent = new RegistrarContratoComponent(this);
                }
                vistaPrincipalTemplate.crearScrollpane(
                        registrarContratoComponent.getVistaPrincipalComponent()
                );
                break;
            case "Cerrar Sesión":
                this.loginComponent = new LoginComponent();
                this.vistaPrincipalTemplate.setVisible(false);
                break;
            default:
                vistaPrincipalTemplate.crearJLabels();
                break;
        }
        vistaPrincipalTemplate.repaint();
    }

    public boolean validarNumeros(String texto, int tamanio) {
        return texto.matches("[0-9]{1," + tamanio + "}");
    }

    public void minimizar() {
        this.vistaPrincipalTemplate.setExtendedState(Frame.ICONIFIED);
    }

    public void moverVentana(int posicionX, int posicionY) {
        this.vistaPrincipalTemplate.setLocation(posicionX, posicionY);
    }

    public VistaPrincipalTemplate getVistaPrincipalTemplate() {
        return vistaPrincipalTemplate;
    }
}
