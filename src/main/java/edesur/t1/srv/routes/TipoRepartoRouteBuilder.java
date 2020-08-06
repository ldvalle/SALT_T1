package edesur.t1.srv.routes;

import edesur.t1.srv.errores.ErrorResponse;
import edesur.t1.srv.errores.ErrorType;
import org.apache.camel.LoggingLevel;

public class TipoRepartoRouteBuilder extends  BaseRouteBuilder {
    @Override
    public void configure() throws Exception {
        super.configure();

        from("direct:setTipoReparto")
			 .routeId("setTipoReparto")
			 .setHeader("contrato", simple("${body.getContrato}"))
			 .setHeader("tipo", simple("${body.getTipo}"))
			 .setHeader("calle", simple("${body.getCalle}"))
			 .setHeader("numeroCalle", simple("${body.getNumeroCalle}"))
			 .setHeader("pisoPostal", simple("${body.getPisoPostal}"))
			 .setHeader("deptoPostal", simple("${body.getDeptoPostal}"))
			 .setHeader("codigoPostal", simple("${body.getCodigoPostal}"))
			 .setHeader("ciudadLocalidad", simple("${body.getCiudadLocalidad}"))
			 .setHeader("barrioPartido", simple("${body.getBarrioPartido}"))
			 .setHeader("estadoProvincia", simple("${body.getEstadoProvincia}"))
			 .setHeader("entreCalle1", simple("${body.getEntreCalle1}"))			 
			 .setHeader("entreCalle2", simple("${body.getEntreCalle2}"))			 
			 .transacted()
          .log(LoggingLevel.DEBUG, logname, "Tipo de Reparto Cliente ${header.numeroCliente}")
          .setHeader("response", body())
			 .to("sql:classpath:sql/spTipoReparto.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.t1.srv.model.BloqueoProrrogaResponse")
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
