package entity;


public class LoginClienteHarnina {

    private String nifCliente;
    private String usuarioCliente;
    private String passwordCliente;

    public LoginClienteHarnina() {

    }
    public LoginClienteHarnina(String usuario, String password) {
        this.usuarioCliente = usuario;
        this.passwordCliente = password;
    }


    public String getNifCliente() {
        return nifCliente;
    }

    public void setNifCliente(String nifCliente) {
        this.nifCliente = nifCliente;
    }

    public String getUsuarioCliente() {
        return usuarioCliente;
    }

    public void setUsuarioCliente(String usuarioCliente) {
        this.usuarioCliente = usuarioCliente;
    }

    public String getPasswordCliente() {
        return passwordCliente;
    }

    public void setPasswordCliente(String passwordCliente) {
        this.passwordCliente = passwordCliente;
    }
}

