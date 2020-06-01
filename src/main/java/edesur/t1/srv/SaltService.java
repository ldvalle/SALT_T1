package edesur.t1.srv;

import edesur.t1.srv.model.ActuDataComerRequest;
import edesur.t1.srv.model.ActuDataComerResponse;

import edesur.t1.srv.model.ComprobantePagoRequest;
import edesur.t1.srv.model.ComprobantePagoResponse;

import edesur.t1.srv.model.AdeDebAutRequest;
import edesur.t1.srv.model.AdeDebAutResponse;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class SaltService {
	
    @POST
    @Path("/actuDataComer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ActuDataComerResponse actuDataComer(@NotNull @Valid ActuDataComerRequest request) {
        return null;
    }	

    @POST
    @Path("/comprobantePago")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ComprobantePagoResponse comprobantePago(@NotNull @Valid ComprobantePagoRequest request) {
        return null;
    }	

    @POST
    @Path("/adhesionDebito")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AdeDebAutResponse adhesionDebito(@NotNull @Valid AdeDebAutRequest request) {
        return null;
    }
    
}
