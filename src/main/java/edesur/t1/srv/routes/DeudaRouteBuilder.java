package edesur.t1.srv.routes;

import edesur.t1.srv.errores.ErrorResponse;
import edesur.t1.srv.errores.ErrorType;
import org.apache.camel.LoggingLevel;

public class DeudaRouteBuilder extends BaseRouteBuilder {
    @Override
    public void configure() throws Exception {
        super.configure();

        from("direct:getDeuda")
                .routeId("getDeuda")
                .setHeader("numeroCliente", simple("${body.getNumeroSuministro}"))
                .log(LoggingLevel.DEBUG, logname, "Consulta deuda cliente ${header.numeroCliente}")
                .to("sql:classpath:sql/deuda.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.t1.srv.model.DeudaResponse")
                .choice()
                    .when(body().isNull())
                        .log(LoggingLevel.DEBUG, logname, "Cliente ${header.numeroCliente} no existe")
                        .setBody(constant(ErrorResponse.create(ErrorType.ClienteNoExiste)))
                    .otherwise()
                        .log(LoggingLevel.DEBUG, logname, "Cliente ${header.numeroCliente}: ${body}")
                .end();
    }
}
