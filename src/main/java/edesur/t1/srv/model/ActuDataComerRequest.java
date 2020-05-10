package edesur.t1.srv.model;

//import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import edesur.t1.srv.validacion.CheckEmpresa;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import java.util.Date;
//import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class ActuDataComerRequest {
    @CheckEmpresa
    private String codigoEmpresa;

    @NotNull
    @Size(max = 12)
    private String numeroSuministro;

    @NotNull
    @Size(max = 15)
    private String nroOrden;

    @NotNull
    @Size(max = 10)
    private String pod;

    @Size(max = 40)
    private String nombreCliente;

    @Size(max = 4)
    private String tipoDocumento;

	@Size(max = 20)
	private String nroDocumento;
	
    @Size(max = 30)
    private String telefono;
	

    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }
    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getNumeroSuministro() {
        return numeroSuministro;
    }
    public void setNumeroSuministro(String numeroSuministro) {
        this.numeroSuministro = numeroSuministro;
    }

	public String getNroOrden(){ return nroOrden; }
	public void setNroOrden(String nroOrden) { this.nroOrden = nroOrden; }
	
	public String getPod(){ return pod; }
	public void setPod(String pod) { this.pod = pod; }
	
	public String getNombreCliente(){ return nombreCliente; }
	public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
	
	public String getTipoDocumento(){ return tipoDocumento; }
	public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }
	
	public String getNroDocumento(){ return nroDocumento; }
	public void setNroDocumento(String nroDocumento) { this.nroDocumento = nroDocumento; }

	public String getTelefono(){ return telefono; }
	public void setTelefono(String telefono) { this.telefono = telefono; }

}
