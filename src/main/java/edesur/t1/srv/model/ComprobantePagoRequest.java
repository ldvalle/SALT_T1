package edesur.t1.srv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import edesur.t1.srv.validacion.CheckEmpresa;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import java.math.BigDecimal;
import java.math.RoundingMode;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class ComprobantePagoRequest {
/*	
    @CheckEmpresa
    @Size(max = 4)
    private String codigoEmpresa;
*/

    @NotNull
    @Size(max = 12)
    private String numeroCliente;

    @DecimalMax("9999999999")
    private BigDecimal saldoExigible;

    @DecimalMax("9999999999")
    private BigDecimal saldoNoExigible;

    @DecimalMax("9999999999")
    private BigDecimal saldoProductosServicios;

    @DecimalMax("9999999999")
    private BigDecimal saldoTasaAlumbradoPublico;

    @DecimalMax("9999999999")
    private BigDecimal saldoCuotasConvenio;
    
    @DecimalMax("9999999999")
    private BigDecimal saldoTotal;
    
    @DecimalMax("9999999999")
    private BigDecimal montoFlexible;
	 
	 	 
    public String getNumeroCliente() { return numeroCliente; }
    public void setNumeroCliente(String numeroCliente) { this.numeroCliente = numeroCliente; }
    
    public BigDecimal getSaldoExigible() { return saldoExigible; }
    public void setSaldoExigible(BigDecimal saldoExigible) { this.saldoExigible = saldoExigible; }
    
    public BigDecimal getSaldoNoExigible() { return saldoNoExigible; }
    public void setSaldoNoExigible(BigDecimal saldoNoExigible) { this.saldoNoExigible = saldoNoExigible; }
        
    public BigDecimal getSaldoProductosServicios() { return saldoProductosServicios; }
    public void setSaldoProductosServicios(BigDecimal saldoProductosServicios) { this.saldoProductosServicios = saldoProductosServicios; }

    public BigDecimal getSaldoTasaAlumbradoPublico() { return saldoTasaAlumbradoPublico; }
    public void setSaldoTasaAlumbradoPublico(BigDecimal saldoTasaAlumbradoPublico) { this.saldoTasaAlumbradoPublico = saldoTasaAlumbradoPublico; }

    public BigDecimal getSaldoCuotasConvenio() { return saldoCuotasConvenio; }
    public void setSaldoCuotasConvenio(BigDecimal saldoCuotasConvenio) { this.saldoCuotasConvenio = saldoCuotasConvenio; }	
    
    public BigDecimal getSaldoTotal() { return saldoTotal; }
    public void setSaldoTotal(BigDecimal saldoTotal) { this.saldoTotal = saldoTotal; }	
    
    public BigDecimal getMontoFlexible() { return montoFlexible; }
    public void setMontoFlexible(BigDecimal montoFlexible) { this.montoFlexible = montoFlexible; }	    
	
	
}
