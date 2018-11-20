package cliente;

import utils.GuardadorDeRequesParamsEnSession;
import utils.POJOCreatorSession;
import entity.LoginClienteHarnina;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;

public abstract class DataBundleCliente {

    LoginClienteHarnina loginClienteEntity = new LoginClienteHarnina();

    HttpSession session;

    public DataBundleCliente(HttpServletRequest request) throws InvocationTargetException, IllegalAccessException {

        session = request.getSession();

        new GuardadorDeRequesParamsEnSession().guardarDatosSesion(request,session);

        new POJOCreatorSession(session,loginClienteEntity);
    }

}
