package cliente;

import utils.POJOCreatorSession;
import entity.ClienteEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public class DataPersonCliente extends DataBundleCliente {

    private ClienteEntity clienteEntity = new ClienteEntity();

    public DataPersonCliente(HttpServletRequest request) throws InvocationTargetException, IllegalAccessException {

        super(request);

        new POJOCreatorSession(session,clienteEntity);
    }

    public ClienteEntity getClienteEntity() {
        return clienteEntity;
    }


    @Column(name = "NifCliente", nullable = false, length = 9)
    @Basic
    public String getNifCliente() {
        return clienteEntity.getNifCliente();
    }

    @Column(name = "ApellidosCliente", nullable = false, length = 100)
    @Basic
    public String getApellidosCliente() {
        return clienteEntity.getApellidosCliente();
    }

    @Column(name = "NombreCliente", nullable = false, length = 50)
    @Basic
    public String getNombreCliente() {
        return clienteEntity.getNombreCliente();
    }

    @Column(name = "DomicilioCliente", nullable = false, length = 100)
    @Basic
    public String getDomicilioCliente() {
        return clienteEntity.getDomicilioCliente();
    }

    @Column(name = "FechaNacimiento", nullable = false)
    @Basic
    public String getFechaNacimiento() {
        return clienteEntity.getFechaNacimiento();
    }

    @Column(name = "TelefonoCliente", nullable = false, length = 20)
    @Basic
    public String getTelefonoCliente() {
        return clienteEntity.getTelefonoCliente();
    }

    @Column(name = "MovilCliente", nullable = false, length = 20)
    @Basic
    public String getMovilCliente() {
        return clienteEntity.getMovilCliente();
    }

    @Column(name = "SexoCliente", nullable = false, length = 1)
    @Basic
    public String getSexoCliente() {
        return clienteEntity.getSexoCliente();
    }

    @Column(name = "EmailCliente", nullable = false, length = 150)
    @Basic
    public String getEmailCliente() {
        return clienteEntity.getEmailCliente();
    }

    @Column(name = "ImagenCliente", nullable = false, length = 15)
    @Basic
    public String getImagenCliente() {
        return clienteEntity.getImagenCliente();
    }

    public void setImagenCliente(String imagenCliente) {
        clienteEntity.setImagenCliente(imagenCliente);
    }

    @Column(name = "UsuarioCliente", nullable = false, length = 30)
    @Basic
    public String getUsuarioCliente() {
        return clienteEntity.getUsuarioCliente();
    }

    @Column(name = "PasswordCliente", nullable = false, length = 50)
    @Basic
    public String getPasswordCliente() {
        return clienteEntity.getPasswordCliente();
    }


    public String getCodigoPostalCliente() {
        return clienteEntity.getCodigoPostalCliente();
    }

}
