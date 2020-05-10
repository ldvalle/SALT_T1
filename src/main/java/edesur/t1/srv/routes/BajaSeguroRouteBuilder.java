package edesur.t1.srv.routes;

import edesur.t1.srv.errores.ErrorResponse;
import edesur.t1.srv.errores.ErrorType;
import edesur.t1.srv.model.BajaSeguroResponse;
import org.apache.camel.LoggingLevel;
import org.apache.camel.component.sql.SqlConstants;

public class BajaSeguroRouteBuilder extends BaseRouteBuilder {

    @Override
    public void configure() throws Exception {
        super.configure();

        from("direct:setBajaClienteSeguro")
                .routeId("setBajaClienteSeguro")
                .bean(LinkBajaSeguros.class)

                .transacted()
                .log(LoggingLevel.DEBUG, logname, "Baja Asociación Seguro ${header.numeroCliente}")
                .to("sql:classpath:sql/dataCliente.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.t1.srv.model.DataClienteResponse")
                .log("${body}")
                .log("${header." + SqlConstants.SQL_ROW_COUNT + "}")

                .choice()
                .when(header(SqlConstants.SQL_ROW_COUNT).isEqualTo(0))
                    .log(LoggingLevel.DEBUG, logname, "Cliente ${header.numeroCliente} no existe o esta en ciclo facturación")
                    .setBody(constant(ErrorResponse.create(ErrorType.ClienteNoEnEstado)))
                .otherwise()
                    .to("sql:classpath:sql/updateSeguro.sql?dataSource=#SynergiaDS")
                    .to("sql:classpath:sql/updateArrie.sql?dataSource=#SynergiaDS")
                    .setBody(constant(new BajaSeguroResponse()))
                    .log(LoggingLevel.DEBUG, logname, "Cliente ${header.numeroCliente}: ${body}")
                .end();


    }


}
