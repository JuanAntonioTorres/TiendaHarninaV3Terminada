package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "daper_cliente", schema = "tienda_harnina20189vistas")
public class DaperClienteEntity {
    private String NifCliente;
    private String ApellidosCliente;
    private String NombreCliente;
    private String CodigoPostalCliente;
    private String DomicilioCliente;
    private Date FechaNacimiento;
    private String TelefonoCliente;
    private String MovilCliente;
    private String SexoCliente;
    private String EmailCliente;
    private String ImagenCliente;

    @Basic
    @Column(name = "NifCliente")
    public String getNifCliente() {
        return NifCliente;
    }

    public void setNifCliente(String nifCliente) {
        this.NifCliente = nifCliente;
    }

    @Basic
    @Column(name = "ApellidosCliente")
    public String getApellidosCliente() {
        return ApellidosCliente;
    }

    public void setApellidosCliente(String apellidosCliente) {
        this.ApellidosCliente = apellidosCliente;
    }

    @Basic
    @Column(name = "NombreCliente")
    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.NombreCliente = nombreCliente;
    }

    public String getCodigoPostalCliente() {
        return CodigoPostalCliente;
    }

    public void setCodigoPostalCliente(String codigoPostalClient) {
        this.CodigoPostalCliente = codigoPostalClient;
    }

    @Basic
    @Column(name = "DomicilioCliente")
    public String getDomicilioCliente() {
        return DomicilioCliente;
    }

    public void setDomicilioCliente(String domicilioCliente) {
        this.DomicilioCliente = domicilioCliente;
    }

    @Basic
    @Column(name = "FechaNacimiento")
    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.FechaNacimiento = fechaNacimiento;
    }

    @Basic
    @Column(name = "TelefonoCliente")
    public String getTelefonoCliente() {
        return TelefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.TelefonoCliente = telefonoCliente;
    }

    @Basic
    @Column(name = "MovilCliente")
    public String getMovilCliente() {
        return MovilCliente;
    }

    public void setMovilCliente(String movilCliente) {
        this.MovilCliente = movilCliente;
    }

    @Basic
    @Column(name = "SexoCliente")
    public String getSexoCliente() {
        return SexoCliente;
    }

    public void setSexoCliente(String sexoCliente) {
        this.SexoCliente = sexoCliente;
    }

    @Basic
    @Column(name = "EmailCliente")
    public String getEmailCliente() {
        return EmailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.EmailCliente = emailCliente;
    }

    @Basic
    @Column(name = "ImagenCliente")
    public String getImagenCliente() {
        return ImagenCliente;
    }

    public void setImagenCliente(String imagenCliente) {
        this.ImagenCliente = imagenCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DaperClienteEntity that = (DaperClienteEntity) o;
        return Objects.equals(NifCliente, that.NifCliente) &&
                Objects.equals(ApellidosCliente, that.ApellidosCliente) &&
                Objects.equals(NombreCliente, that.NombreCliente) &&
                Objects.equals(CodigoPostalCliente, that.CodigoPostalCliente) &&
                Objects.equals(DomicilioCliente, that.DomicilioCliente) &&
                Objects.equals(FechaNacimiento, that.FechaNacimiento) &&
                Objects.equals(TelefonoCliente, that.TelefonoCliente) &&
                Objects.equals(MovilCliente, that.MovilCliente) &&
                Objects.equals(SexoCliente, that.SexoCliente) &&
                Objects.equals(EmailCliente, that.EmailCliente) &&
                Objects.equals(ImagenCliente, that.ImagenCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NifCliente, ApellidosCliente, NombreCliente, CodigoPostalCliente, DomicilioCliente, FechaNacimiento, TelefonoCliente, MovilCliente, SexoCliente, EmailCliente, ImagenCliente);
    }

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
