package edesur.t1.srv.routes;

import edesur.t1.srv.errores.ErrorResponse;
import edesur.t1.srv.errores.ErrorType;
//import edesur.t1.srv.model.ActuDataComerResponse;
import org.apache.camel.LoggingLevel;
//import org.apache.camel.component.sql.SqlConstants;
//import static org.apache.camel.builder.PredicateBuilder.not;

public class ActuDataComerRouteBuilder extends  BaseRouteBuilder {
    @Override
    public void configure() throws Exception {
        super.configure();

        from("direct:setDataComer")
			 .routeId("setDataComer")
			 .setHeader("numeroCliente", simple("${body.getNumeroSuministro}"))
			 .setHeader("nroOrden", simple("${body.getNroOrden}"))
			 .setHeader("nombreCliente", simple("${body.getNombreCliente}"))
			 .setHeader("tipoDocumento", simple("${body.getTipoDocumento}"))
			 .setHeader("nroDocumento", simple("${body.getNroDocumento}"))
			 .setHeader("telefono", simple("${body.getTelefono}"))
          .log(LoggingLevel.DEBUG, logname, "Actualiza Datos Comerciales Cliente ${header.numeroCliente}")
          .setHeader("response", body())
			 //.to("sql:classpath:sql/insMiCliente.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.t1.srv.model.ResponseBase")
			 //.to("sql:classpath:sql/insMiCliente.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.t1.srv.model.ActuDataComerResponse")
			 .to("sql:classpath:sql/spInsMiCliente.sql?dataSource=#SynergiaDS&outputType=SelectOne&outputClass=edesur.t1.srv.model.ActuDataComerResponse")
			 //.to("sql:classpath:sql/spInsMiCliente.sql?dataSource=#SynergiaDS")
//			 .setBody(header("response"));

			 .choice()
			 .when(body().isNull())
				  .log(LoggingLevel.DEBUG, logname, "Cliente ${header.numeroCliente} no existe")
				  .setBody(constant(ErrorResponse.create(ErrorType.ClienteNoExiste)))
			 .otherwise()
				  .log(LoggingLevel.DEBUG, logname, "Cliente ${header.numeroCliente}: ${body}")
			 .end();                

    }
}
