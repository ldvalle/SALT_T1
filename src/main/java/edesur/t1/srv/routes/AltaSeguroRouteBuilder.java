package edesur.t1.srv.routes;

import edesur.t1.srv.errores.ErrorResponse;
import edesur.t1.srv.errores.ErrorType;
import edesur.t1.srv.model.AltaSeguroResponse;
import org.apache.camel.LoggingLevel;
import org.apache.camel.component.sql.SqlConstants;

public class AltaSeguroRouteBuilder extends  BaseRouteBuilder {
    @Override
    public void configure() throws Exception {
        super.configure();

        from("direct:setAltaClienteSeguro")
                .routeId("setAltaClienteSeguro")
                //.bean(pbalink.class)
                .setHeader("numeroCliente", simple("${body.getNumeroSuministro}"))
                .setHeader("codEmpresa", simple("${body.getCodCompaSeguro}"))
                .setHeader("concepto", simple("${body.getCodConcepto}"))
                .setHeader("fechaAlta", simple("${body.getFechaAlta}"))
                .setHeader("rolAlta", simple("${body.getRolAlta}"))
                .setHeader("monto", simple("${body.getMonto}"))
                .transacted()
                .log(LoggingLevel.DEBUG, logname, "Alta Asociación Seguro ${header.numeroCliente}")
                .to("sql:classpath:sql/dataCliente.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.t1.srv.model.DataClienteResponse")
                .log("${body}")
                .log("${header." + SqlConstants.SQL_ROW_COUNT + "}")

                .choice()
                .when(header(SqlConstants.SQL_ROW_COUNT).isEqualTo(0))
                    .log(LoggingLevel.DEBUG, logname, "Cliente ${header.numeroCliente} no existe o esta en ciclo facturación")
                    .setBody(constant(ErrorResponse.create(ErrorType.ClienteNoEnEstado)))
                .otherwise()
                    .to("sql:classpath:sql/altaSeguro.sql?dataSource=#SynergiaDS")
                    .to("sql:classpath:sql/altaArrie.sql?dataSource=#SynergiaDS")
                    .setBody(constant(new AltaSeguroResponse()))
                    .log(LoggingLevel.DEBUG, logname, "Cliente ${header.numeroCliente}: ${body}")
                .end();


    }
}
