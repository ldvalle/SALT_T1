package edesur.t1.srv.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import edesur.t1.srv.validacion.CheckEmpresa;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@JsonInclude(JsonInclude.Include.NON_NULL)

public class BajaSeguroRequest {
    @CheckEmpresa
    private String codigoEmpresa;

    @NotNull
    @Size(max = 12)
    private String numeroSuministro;

    @NotNull
    @Size(max = 10)
    private String codCompaSeguro;

    @NotNull
    @Size(max = 3)
    private String codConcepto;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Argentina/Buenos_Aires")
    private Date fechaBaja;

    @NotNull
    private String rolBaja;

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

    public String getCodCompaSeguro() {
        return codCompaSeguro;
    }
    public void setCodCompaSeguro(String codCompaSeguro) {
        this.codCompaSeguro = codCompaSeguro;
    }

    public String getCodConcepto() {
        return codConcepto;
    }
    public void setCodConcepto(String codConcepto) {
        this.codConcepto = codConcepto;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }
    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getRolBaja() {
        return rolBaja;
    }
    public void setRolBaja(String rolBaja) {
        this.rolBaja = rolBaja;
    }

}
