package edesur.t1.srv;

import edesur.t1.srv.model.ActuDataComerRequest;
import edesur.t1.srv.model.ActuDataComerResponse;


import edesur.t1.srv.model.DeudaRequest;
import edesur.t1.srv.model.DeudaResponse;
import edesur.t1.srv.model.SuministroRequest;
import edesur.t1.srv.model.SuministroResponse;
import edesur.t1.srv.model.DirSumRequest;
import edesur.t1.srv.model.DirSumResponse;
import edesur.t1.srv.model.LecturaRequest;
import edesur.t1.srv.model.LecturaResponse;
import edesur.t1.srv.model.InsSapRegiClienteRequest;
import edesur.t1.srv.model.InsSapRegiClienteResponse;
import edesur.t1.srv.model.AltaSeguroRequest;
import edesur.t1.srv.model.AltaSeguroResponse;
import edesur.t1.srv.model.BajaSeguroRequest;
import edesur.t1.srv.model.BajaSeguroResponse;


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
    @Path("/deuda")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DeudaResponse deuda(@NotNull @Valid DeudaRequest request) {
        return null;
    }

    @POST
    @Path("/suministro")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SuministroResponse suministro(@NotNull @Valid SuministroRequest request) {
        return null;
    }

    @POST
    @Path("/dirSum")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public DirSumResponse dirSum(@NotNull @Valid DirSumRequest request) {
        return null;
    }

    @POST
    @Path("/lecturas")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LecturaResponse lecturas(@NotNull @Valid LecturaRequest request) {
        return null;
    }

    @POST
    @Path("/ins_sap_regi_cliente")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public InsSapRegiClienteResponse ins_sap_regi_cliente(@NotNull @Valid InsSapRegiClienteRequest request) { return null; }

    @POST
    @Path("/AltaSeguros")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AltaSeguroResponse AltaSeguros(@NotNull @Valid AltaSeguroRequest request) { return null; }

    @POST
    @Path("/BajaSeguros")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BajaSeguroResponse BajaSeguros(@NotNull @Valid BajaSeguroRequest request) { return null; }

}
