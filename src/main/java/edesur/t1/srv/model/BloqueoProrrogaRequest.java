package edesur.t1.srv.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import edesur.t1.srv.validacion.CheckEmpresa;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class BloqueoProrrogaRequest {
    @CheckEmpresa
    private String codigoEmpresa;

    @Size(max = 12)
    private String cuentaContrato;

    @Size(max = 10)
    private String numeroSuministro;

    @Size(max = 2)
    private String tipoBloqueo;

    @Size(max = 2)
    private String bloqueo;

    @Size(max = 1)
    private String motivo;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd", timezone = "America/Argentina/Buenos_Aires")
    @Size(max = 8)
    private String fechaInicioBloqueo;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd", timezone = "America/Argentina/Buenos_Aires")
    @Size(max = 8)
    private String fechaFinBloqueo;

    @Size(max = 15)
    private String numeroCaso;
	 
	/*	SETTERS AND GETTERS */

    public String getCodigoEmpresa() { return codigoEmpresa; }
    public void setCodigoEmpresa(String codigoEmpresa) { this.codigoEmpresa = codigoEmpresa; }

    public String getCuentaContrato() { return cuentaContrato; }
    public void setCuentaContrato(String cuentaContrato) { this.cuentaContrato = cuentaContrato; }

    public String getNumeroSuministro() { return numeroSuministro; }
    public void setNumeroSuministro(String numeroSuministro) { this.numeroSuministro = numeroSuministro; }

    public String getTipoBloqueo() { return tipoBloqueo; }
    public void setTipoBloqueo(String tipoBloqueo) { this.tipoBloqueo = tipoBloqueo; }

    public String getBloqueo() { return bloqueo; }
    public void setBloqueo(String bloqueo) { this.bloqueo = bloqueo; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public String getFechaInicioBloqueo() { return fechaInicioBloqueo; }
    public void setFechaInicioBloqueo(String fechaInicioBloqueo) { this.fechaInicioBloqueo = fechaInicioBloqueo; }

    public String getFechaFinBloqueo() { return fechaFinBloqueo; }
    public void setFechaFinBloqueo(String fechaFinBloqueo) { this.fechaFinBloqueo = fechaFinBloqueo; }

    public String getNumeroCaso() { return numeroCaso; }
    public void setNumeroCaso(String numeroCaso) { this.numeroCaso = numeroCaso; }
    
}
