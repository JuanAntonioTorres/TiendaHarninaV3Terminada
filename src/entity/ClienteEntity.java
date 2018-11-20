package entity;

import javax.persistence.*;
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
    private String codigoPostalCliente;
    private String fechaNacimiento;
    private String telefonoCliente;
    private String movilCliente;
    private String sexoCliente;
    private String emailCliente;
    private String imagenCliente;
    private String usuarioCliente;
    private String passwordCliente;
    private Timestamp fechaAlta;
    private byte bloqueado;
    private byte eliminado;

    @Id
    @Column(name = "IdCliente")
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Basic
    @Column(name = "NifCliente")
    public String getNifCliente() {
        return nifCliente;
    }

    public void setNifCliente(String nifCliente) {
        this.nifCliente = nifCliente;
    }

    @Basic
    @Column(name = "ApellidosCliente")
    public String getApellidosCliente() {
        return apellidosCliente;
    }

    public void setApellidosCliente(String apellidosCliente) {
        this.apellidosCliente = apellidosCliente;
    }

    @Basic
    @Column(name = "NombreCliente")
    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Basic
    @Column(name = "CodigoPostalCliente")
    public String getCodigoPostalCliente() {
        return codigoPostalCliente;
    }

    public void setCodigoPostalCliente(String codigoPostalCliente) {
        this.codigoPostalCliente = codigoPostalCliente;
    }

    @Basic
    @Column(name = "DomicilioCliente")
    public String getDomicilioCliente() {
        return domicilioCliente;
    }

    public void setDomicilioCliente(String domicilioCliente) {
        this.domicilioCliente = domicilioCliente;
    }

    @Basic
    @Column(name = "FechaNacimiento")
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Basic
    @Column(name = "TelefonoCliente")
    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    @Basic
    @Column(name = "MovilCliente")
    public String getMovilCliente() {
        return movilCliente;
    }

    public void setMovilCliente(String movilCliente) {
        this.movilCliente = movilCliente;
    }

    @Basic
    @Column(name = "SexoCliente")
    public String getSexoCliente() {
        return sexoCliente;
    }

    public void setSexoCliente(String sexoCliente) {
        this.sexoCliente = sexoCliente;
    }

    @Basic
    @Column(name = "EmailCliente")
    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    @Basic
    @Column(name = "ImagenCliente")
    public String getImagenCliente() {
        return imagenCliente;
    }

    public void setImagenCliente(String imagenCliente) {
        this.imagenCliente = imagenCliente;
    }

    @Basic
    @Column(name = "UsuarioCliente")
    public String getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(String usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    @Basic
    @Column(name = "PasswordCliente")
    public String getPasswordCliente() {
        return passwordCliente;
    }

    public void setPasswordCliente(String passwordCliente) {
        this.passwordCliente = passwordCliente;
    }

    @Basic
    @Column(name = "fechaAlta")
    public Timestamp getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Timestamp fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Basic
    @Column(name = "bloqueado")
    public byte getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(byte bloqueado) {
        this.bloqueado = bloqueado;
    }

    @Basic
    @Column(name = "eliminado")
    public byte getEliminado() {
        return eliminado;
    }

    public void setEliminado(byte eliminado) {
        this.eliminado = eliminado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity that = (ClienteEntity) o;
        return idCliente == that.idCliente &&
                bloqueado == that.bloqueado &&
                eliminado == that.eliminado &&
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
        return Objects.hash(idCliente, nifCliente, apellidosCliente, nombreCliente, domicilioCliente, fechaNacimiento, telefonoCliente, movilCliente, sexoCliente, emailCliente, imagenCliente, usuarioCliente, passwordCliente, fechaAlta, bloqueado, eliminado);
    }
}
