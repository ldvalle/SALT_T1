package edesur.t1.srv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import edesur.t1.srv.validacion.CheckEmpresa;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class DirSumRequest {
    @CheckEmpresa
    private String codigoEmpresa;

    @NotNull
    @Size(max = 12)
    private String numeroSuministro;

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

}
