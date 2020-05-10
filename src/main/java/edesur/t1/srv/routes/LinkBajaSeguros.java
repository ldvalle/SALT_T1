package edesur.t1.srv.routes;


import edesur.t1.srv.model.BajaSeguroRequest;
import org.apache.camel.Body;
import org.apache.camel.Headers;

import java.util.Map;

public class LinkBajaSeguros {

    public void pba1(@Body BajaSeguroRequest objReq, @Headers Map<String, Object > objRes){
        objRes.put("numeroCliente", objReq.getNumeroSuministro());
        objRes.put("codEmpresa", objReq.getCodCompaSeguro());
        objRes.put("concepto", objReq.getCodConcepto());
        objRes.put("fechaBaja", objReq.getFechaBaja());
        objRes.put("rolBaja", objReq.getRolBaja());

    }
}
