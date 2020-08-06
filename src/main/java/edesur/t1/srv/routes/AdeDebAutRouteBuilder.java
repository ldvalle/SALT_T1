package edesur.t1.srv.routes;

import edesur.t1.srv.errores.ErrorResponse;
import edesur.t1.srv.errores.ErrorType;
import edesur.t1.srv.model.AdeDebAutResponse;
import org.apache.camel.LoggingLevel;

public class AdeDebAutRouteBuilder extends  BaseRouteBuilder {
    @Override
    public void configure() throws Exception {
        super.configure();

        from("direct:setDebitoAutomatico")
			 .routeId("setDebitoAutomatico")
			 .setHeader("cuentaContrato", simple("${body.getCuentaContrato}"))
			 .setHeader("codBanco", simple("${body.getCodBanco}"))
			 .setHeader("accion", simple("${body.getAccion}"))
			 .setHeader("claseTarjeta", simple("${body.getClaseTarjeta}"))
			 .setHeader("nroTarjeta", simple("${body.getNroTarjeta}"))
			 .setHeader("nroCBU", simple("${body.getNroCBU}"))
			 .setHeader("tipoCuenta", simple("${body.getTipoCuenta}"))
			 .transacted()
          .log(LoggingLevel.DEBUG, logname, "Alta Debito Automatico Cliente ${header.cuentaContrato}")
          .setHeader("response", body())
			 .to("sql:classpath:sql/spDebitoAutomatico.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.t1.srv.model.AdeDebAutResponse")
			 .choice()
			 .when(body().isNull())
				  .log(LoggingLevel.DEBUG, logname, "Cliente ${header.cuentaContrato} no existe")
				  .setBody(constant(ErrorResponse.create(ErrorType.ClienteNoExiste)))
			 .otherwise()
				  .log(LoggingLevel.DEBUG, logname, "Cliente ${header.cuentaContrato}: ${body}")
			 .end();                

    }
}
