package edesur.t1.srv.routes;

import edesur.t1.srv.errores.ErrorResponse;
import edesur.t1.srv.errores.ErrorType;
import org.apache.camel.LoggingLevel;

public class ComprobantePagoRouteBuilder extends  BaseRouteBuilder {
    @Override
    public void configure() throws Exception {
        super.configure();

        from("direct:setComprobantePago")
			 .routeId("setComprobantePago")
			 .setHeader("numeroCliente", simple("${body.getNumeroCliente}"))
			 .setHeader("saldoExigible", simple("${body.getSaldoExigible}"))
			 .setHeader("saldoNoExigible", simple("${body.getSaldoNoExigible}"))
			 .setHeader("saldoProductosServicios", simple("${body.getSaldoProductosServicios}"))
			 .setHeader("saldoTasaAlumbradoPublico", simple("${body.getSaldoTasaAlumbradoPublico}"))
			 .setHeader("saldoCuotasConvenio", simple("${body.getSaldoCuotasConvenio}"))
			 .setHeader("saldoTotal", simple("${body.getSaldoTotal}"))
			 .setHeader("montoFlexible", simple("${body.getMontoFlexible}"))
          .log(LoggingLevel.DEBUG, logname, "Comprobante de Pago Cliente ${header.numeroCliente}")
          .setHeader("response", body())
			 .to("sql:classpath:sql/spComprobantePago.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.t1.srv.model.ComprobantePagoResponse")
			 .choice()
			 .when(body().isNull())
				  .log(LoggingLevel.DEBUG, logname, "Cliente ${header.numeroCliente} no existe")
				  .setBody(constant(ErrorResponse.create(ErrorType.ClienteNoExiste)))
			 .otherwise()
				  .log(LoggingLevel.DEBUG, logname, "Cliente ${header.numeroCliente}: ${body}")
			 .end();                

    }
}
