package edesur.t1.srv.routes;

import edesur.t1.srv.errores.ErrorResponse;
import edesur.t1.srv.errores.ErrorType;
import org.apache.camel.LoggingLevel;

public class InsSapRegiClienteRouteBuilder extends BaseRouteBuilder {
    @Override
    public void configure() throws Exception {
        super.configure();

        from("direct:setSapRegiCliente")
                .routeId("setSapRegiCliente")
                .setHeader("numeroCliente", simple("${body.getNumeroSuministro}"))
                .setHeader("tarifa", simple("${body.getTarifa}"))
                .setHeader("ul", simple("${body.getUl}"))
                .log(LoggingLevel.DEBUG, logname, "Inserta SapRegiCliente ${header.numeroCliente}")
                .setHeader("response", body())
                //.to("sql:classpath:sql/insSapRegiCliente.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.t1.srv.model.InsSapRegiClienteResponse")
                .to("sql:classpath:sql/insSapRegiCliente.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.t1.srv.model.ResponseBase")
                .setBody(header("response"));
/*
                .choice()
                .when(body().isNull())
                    .log(LoggingLevel.DEBUG, logname, "Cliente ${header.numeroCliente} no existe")
                    .setBody(constant(ErrorResponse.create(ErrorType.ClienteNoExiste)))
                .otherwise()
                    .log(LoggingLevel.DEBUG, logname, "Cliente ${header.numeroCliente}: ${body}")
                .end();
*/
    }

}
