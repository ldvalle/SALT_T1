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
                    .when(header(CxfConstants.OPERATION_NAME).isEqualTo("deuda"))
                        .to("direct:getDeuda")
                    .when(header(CxfConstants.OPERATION_NAME).isEqualTo("suministro"))
                        .to("direct:getSuministro")
                    .when(header(CxfConstants.OPERATION_NAME).isEqualTo("dirSum"))
                        .to("direct:getDirSum")
                    .when(header(CxfConstants.OPERATION_NAME).isEqualTo("lecturas"))
                        .to("direct:getLecturas")
                    .when(header(CxfConstants.OPERATION_NAME).isEqualTo("ins_sap_regi_cliente"))
                        .to("direct:setSapRegiCliente")
                    .when(header(CxfConstants.OPERATION_NAME).isEqualTo("AltaSeguros"))
                        .to("direct:setAltaClienteSeguro")
                    .when(header(CxfConstants.OPERATION_NAME).isEqualTo("BajaSeguros"))
                        .to("direct:setBajaClienteSeguro")

                    .otherwise()
                        .log(LoggingLevel.ERROR, "Opeacion no implementada: " + header(CxfConstants.OPERATION_NAME))
                .end();
    }
}
