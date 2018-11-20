package error;

public enum  EstadoError {

    ERROR_USUARIO(300, "Este USUARIO Ya existe", "Lorem Ipsum...","ErrorUsuario"),
    ERROR_PASSWORD(310, "Esta password es Incorrecta", "Lorem Ipsum...", "ErrorPassword");


    private final int id;
    private final String msg;
    private final String descrip;
    private final String className;

    EstadoError(int id, String msg, String descrip, String className) {
        this.id = id;
        this.msg = msg;
        this.descrip = descrip;
        this.className = className;
    }

    public int getId() {
        return this.id;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getDescrip() {
        return this.descrip;
    }

    public String getClassName() {
        return this.className;
    }
}


