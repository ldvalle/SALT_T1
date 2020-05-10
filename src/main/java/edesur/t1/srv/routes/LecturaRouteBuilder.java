package edesur.t1.srv.routes;

import edesur.t1.srv.errores.ErrorResponse;
import edesur.t1.srv.errores.ErrorType;
import org.apache.camel.LoggingLevel;

public class LecturaRouteBuilder extends BaseRouteBuilder {

    @Override
    public void configure() throws Exception {
        super.configure();

        from("direct:getLecturas")
                .routeId("getLecturas")
                .setHeader("numeroCliente", simple("${body.getNumeroSuministro}"))
                .log(LoggingLevel.DEBUG, logname, "Consulta Lecturas ${header.numeroCliente}")
                .to("sql:classpath:sql/lecturas.sql?dataSource=#SynergiaDS&outputType=SelectList&outputClass=edesur.t1.srv.model.LecturaResponse")
                .choice()
                .when(body().isNull())
                    .log(LoggingLevel.DEBUG, logname, "Cliente ${header.numeroCliente} no existe")
                    .setBody(constant(ErrorResponse.create(ErrorType.ClienteNoExiste)))
                .otherwise()
                    .log(LoggingLevel.DEBUG, logname, "Cliente ${header.numeroCliente}: ${body}")
                .end();
    }

}
