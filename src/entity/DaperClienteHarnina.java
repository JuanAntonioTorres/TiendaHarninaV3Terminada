package entity;

public class DaperClienteHarnina {
    private String NifCliente;
    private String ApellidosCliente;
    private String NombreCliente;
    private String CodigoPostalCliente;
    private String DomicilioCliente;
    private String FechaNacimiento;
    private String TelefonoCliente;
    private String MovilCliente;
    private String SexoCliente;
    private String EmailCliente;
    private String ImagenCliente;

    public DaperClienteHarnina(){

    }

    public DaperClienteHarnina(String nifCliente, String apellidosCliente, String nombreCliente, String codigoPostalCliente, String domicilioCliente, String fechaNacimiento, String telefonoCliente, String movilCliente, String sexoCliente, String emailCliente, String imagenCliente) {
        NifCliente = nifCliente;
        ApellidosCliente = apellidosCliente;
        NombreCliente = nombreCliente;
        CodigoPostalCliente = codigoPostalCliente;
        DomicilioCliente = domicilioCliente;
        FechaNacimiento = fechaNacimiento;
        TelefonoCliente = telefonoCliente;
        MovilCliente = movilCliente;
        SexoCliente = sexoCliente;
        EmailCliente = emailCliente;
        ImagenCliente = imagenCliente;
    }

    public String getNifCliente() {
        return NifCliente;
    }

    public void setNifCliente(String nifCliente) {
        NifCliente = nifCliente;
    }

    public String getApellidosCliente() {
        return ApellidosCliente;
    }

    public void setApellidosCliente(String apellidosCliente) {
        ApellidosCliente = apellidosCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        NombreCliente = nombreCliente;
    }

    public String getCodigoPostalCliente() {
        return CodigoPostalCliente;
    }

    public void setCodigoPostalCliente(String codigoPostalCliente) {
        CodigoPostalCliente = codigoPostalCliente;
    }

    public String getDomicilioCliente() {
        return DomicilioCliente;
    }

    public void setDomicilioCliente(String domicilioCliente) {
        DomicilioCliente = domicilioCliente;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getTelefonoCliente() {
        return TelefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        TelefonoCliente = telefonoCliente;
    }

    public String getMovilCliente() {
        return MovilCliente;
    }

    public void setMovilCliente(String movilCliente) {
        MovilCliente = movilCliente;
    }

    public String getSexoCliente() {
        return SexoCliente;
    }

    public void setSexoCliente(String sexoCliente) {
        SexoCliente = sexoCliente;
    }

    public String getEmailCliente() {
        return EmailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        EmailCliente = emailCliente;
    }

    public String getImagenCliente() {
        return ImagenCliente;
    }

    public void setImagenCliente(String imagenCliente) {
        ImagenCliente = imagenCliente;
    }
}
