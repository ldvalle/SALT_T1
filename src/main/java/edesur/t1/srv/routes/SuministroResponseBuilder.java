package edesur.t1.srv.routes;

import edesur.t1.srv.model.SuministroResponse;
import edesur.t1.srv.model.SuministroResultado;
import org.apache.camel.Body;

public class SuministroResponseBuilder {
    public SuministroResponse build(@Body SuministroResultado resultado) {
        SuministroResponse response = new SuministroResponse();
        response.getListaResultado().add(resultado);
        return response;
    }
}
