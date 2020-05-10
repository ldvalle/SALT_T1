package edesur.t1.srv.routes;

import edesur.t1.srv.model.AltaSeguroRequest;
import org.apache.camel.Body;
import org.apache.camel.Headers;

import java.util.Map;

public class pbalink {
    public void pba1(@Body AltaSeguroRequest lineRequest, @Headers Map<String, Object > lineaResponse){
        lineaResponse.put("numeroCliente", lineRequest.getNumeroSuministro());


    }

}
