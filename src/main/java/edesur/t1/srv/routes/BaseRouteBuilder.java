package edesur.t1.srv.routes;

import edesur.t1.srv.errores.ExceptionHandler;
import org.apache.camel.builder.RouteBuilder;

public class BaseRouteBuilder extends RouteBuilder {
    protected String logname;

    @Override
    public void configure() throws Exception {
        logname = getContext().getName();

        onException(Exception.class)
                .handled(true)
                .bean(ExceptionHandler.class);
    }
}
