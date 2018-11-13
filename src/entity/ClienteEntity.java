package entity;

import javax.persistence.*;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cliente", schema = "tienda_harnina20189")
public class ClienteEntity {
    private int idCliente;
    private String nifCliente;
    private String apellidosCliente;
    private String nombreCliente;
    private String domicilioCliente;
    private String fechaNacimiento;
    private String telefonoCliente;
    private String movilCliente;
    private String sexoCliente;
    private String emailCliente;
    private String imagenCliente;
    private String usuarioCliente;
    private String passwordCliente;
    private String codigoPostalClient;
    private Timestamp fechaAlta;


    public ClienteEntity(HttpSession session) throws IllegalAccessException {
        Field [] atributosCliente = this.getClass().getDeclaredFields();
        for (int i = 0; i < atributosCliente.length; i++) {
            atributosCliente[i].set(this,session.getAttribute(atributosCliente[i].getName()));
        }
    }

    public ClienteEntity() {
    }


    @Id
    @Column(name = "IdCliente", nullable = false)
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Basic
    @Column(name = "NifCliente", nullable = false, length = 9)
    public String getNifCliente() {
        return nifCliente;
    }

    public void setNifCliente(String nifCliente) {
        this.nifCliente = nifCliente;
    }

    @Basic
    @Column(name = "ApellidosCliente", nullable = false, length = 100)
    public String getApellidosCliente() {
        return apellidosCliente;
    }

    public void setApellidosCliente(String apellidosCliente) {
        this.apellidosCliente = apellidosCliente;
    }

    @Basic
    @Column(name = "NombreCliente", nullable = false, length = 50)
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Basic
    @Column(name = "DomicilioCliente", nullable = false, length = 100)
    public String getDomicilioCliente() {
        return domicilioCliente;
    }

    public void setDomicilioCliente(String domicilioCliente) {
        this.domicilioCliente = domicilioCliente;
    }

    @Basic
    @Column(name = "FechaNacimiento", nullable = false)
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Basic
    @Column(name = "TelefonoCliente", nullable = false, length = 20)
    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    @Basic
    @Column(name = "MovilCliente", nullable = false, length = 20)
    public String getMovilCliente() {
        return movilCliente;
    }

    public void setMovilCliente(String movilCliente) {
        this.movilCliente = movilCliente;
    }

    @Basic
    @Column(name = "SexoCliente", nullable = false, length = 1)
    public String getSexoCliente() {
        return sexoCliente;
    }

    public void setSexoCliente(String sexoCliente) {
        this.sexoCliente = sexoCliente;
    }

    @Basic
    @Column(name = "EmailCliente", nullable = false, length = 150)
    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    @Basic
    @Column(name = "ImagenCliente", nullable = false, length = 15)
    public String getImagenCliente() {
        return imagenCliente;
    }

    public void setImagenCliente(String imagenCliente) {
        this.imagenCliente = imagenCliente;
    }

    @Basic
    @Column(name = "UsuarioCliente", nullable = false, length = 30)
    public String getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(String usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    @Basic
    @Column(name = "PasswordCliente", nullable = false, length = 50)
    public String getPasswordCliente() {
        return passwordCliente;
    }

    public void setPasswordCliente(String passwordCliente) {
        this.passwordCliente = passwordCliente;
    }

    @Basic
    @Column(name = "fechaAlta", nullable = false)
    public Timestamp getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Timestamp fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity that = (ClienteEntity) o;
        return idCliente == that.idCliente &&
                Objects.equals(nifCliente, that.nifCliente) &&
                Objects.equals(apellidosCliente, that.apellidosCliente) &&
                Objects.equals(nombreCliente, that.nombreCliente) &&
                Objects.equals(domicilioCliente, that.domicilioCliente) &&
                Objects.equals(fechaNacimiento, that.fechaNacimiento) &&
                Objects.equals(telefonoCliente, that.telefonoCliente) &&
                Objects.equals(movilCliente, that.movilCliente) &&
                Objects.equals(sexoCliente, that.sexoCliente) &&
                Objects.equals(emailCliente, that.emailCliente) &&
                Objects.equals(imagenCliente, that.imagenCliente) &&
                Objects.equals(usuarioCliente, that.usuarioCliente) &&
                Objects.equals(passwordCliente, that.passwordCliente) &&
                Objects.equals(fechaAlta, that.fechaAlta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, nifCliente, apellidosCliente, nombreCliente, domicilioCliente, fechaNacimiento, telefonoCliente, movilCliente, sexoCliente, emailCliente, imagenCliente, usuarioCliente, passwordCliente, fechaAlta);
    }

    public String getCodigoPostalClient() {
        return codigoPostalClient;
    }

    public void setCodigoPostalClient(String codigoPostalClient) {
        this.codigoPostalClient = codigoPostalClient;
    }
}
