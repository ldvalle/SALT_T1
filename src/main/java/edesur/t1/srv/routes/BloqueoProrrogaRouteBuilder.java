package edesur.t1.srv.routes;

import edesur.t1.srv.errores.ErrorResponse;
import edesur.t1.srv.errores.ErrorType;
import org.apache.camel.LoggingLevel;

public class BloqueoProrrogaRouteBuilder extends  BaseRouteBuilder {
    @Override
    public void configure() throws Exception {
        super.configure();

        from("direct:setBloqueoProrroga")
			 .routeId("setBloqueoProrroga")
			 .setHeader("codigoEmpresa", simple("${body.getCodigoEmpresa}"))
			 .setHeader("cuentaContrato", simple("${body.getCuentaContrato}"))
			 .setHeader("numeroSuministro", simple("${body.getNumeroSuministro}"))
			 .setHeader("tipoBloqueo", simple("${body.getTipoBloqueo}"))
			 .setHeader("bloqueo", simple("${body.getBloqueo}"))
			 .setHeader("motivo", simple("${body.getMotivo}"))
			 .setHeader("fechaInicioBloqueo", simple("${body.getFechaInicioBloqueo}"))
			 .setHeader("fechaFinBloqueo", simple("${body.getFechaFinBloqueo}"))
			 .transacted()
          .log(LoggingLevel.DEBUG, logname, "Bloqueo de Prorroga Cliente ${header.numeroCliente}")
          .setHeader("response", body())
			 .to("sql:classpath:sql/spBloqueoProrroga.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.t1.srv.model.BloqueoProrrogaResponse")
			 //.setBody(header("response"));

			 .choice()
			 .when(body().isNull())
				  .log(LoggingLevel.DEBUG, logname, "Cliente ${header.numeroSuministro} no existe")
				  .setBody(constant(ErrorResponse.create(ErrorType.ClienteNoExiste)))
			 .otherwise()
				  .log(LoggingLevel.DEBUG, logname, "Cliente ${header.numeroSuministro}: ${body}")
			 .end();                

    }
}
