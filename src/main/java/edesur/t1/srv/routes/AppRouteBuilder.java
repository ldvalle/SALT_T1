package edesur.t1.srv.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.component.cxf.common.message.CxfConstants;

public class AppRouteBuilder extends BaseRouteBuilder {
    @Override
    public void configure() throws Exception {
        super.configure();

        from("cxfrs:bean:rsServer?bindingStyle=SimpleConsumer")
                .routeId("restEndpointConsumer")
                .choice()
                    .when(header(CxfConstants.OPERATION_NAME).isEqualTo("actuDataComer"))
                        .to("direct:setDataComer")
                    .when(header(CxfConstants.OPERATION_NAME).isEqualTo("comprobantePago"))
                        .to("direct:setComprobantePago")                        
                    .when(header(CxfConstants.OPERATION_NAME).isEqualTo("adhesionDebito"))
                        .to("direct:setDebitoAutomatico")
                    .when(header(CxfConstants.OPERATION_NAME).isEqualTo("bloqueoProrroga"))
                        .to("direct:setBloqueoProrroga")
                    .when(header(CxfConstants.OPERATION_NAME).isEqualTo("tipoReparto"))
                        .to("direct:setTipoReparto")
                    .when(header(CxfConstants.OPERATION_NAME).isEqualTo("consultaCorteRepo"))
                        .to("direct:setConsultaCorteRepo")                        
                    .otherwise()
                        .log(LoggingLevel.ERROR, "Operacion no implementada: " + header(CxfConstants.OPERATION_NAME))
                .end();
    }
}
