package accounts.business;

import accounts.business.impl.FacadeDefaultImpl;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Logger;

public class FacadeLocator {

    private static Facade instance;

    private static final Logger LOG = Logger.getLogger(FacadeLocator.class.getName());

    public static Facade getInstance() {
        if (instance == null) {
            instance = new FacadeDefaultImpl();
        }
        return instance;
    }

    private static Facade wrap(Facade f) {
        return (Facade) Proxy.newProxyInstance(FacadeLocator.class.getClassLoader(),
                new Class<?>[]{Facade.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                LOG.info(method.toString());
                return method.invoke(f, args);
            }

        });
    }
}
