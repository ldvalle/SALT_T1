package edesur.t1.srv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "corrFactu",
        "fechaLectu",
        "lectura",
        "tipoLectu",
        "nroMedidor",
        "marcaMedidor"
})

public class LecturaResponse {

    @Size(max = 999999999)
    @NotNull
    private int corrFactu;

    @NotNull
    private Date fechaLectu;

    @DecimalMax("9999999999")
    @NotNull
    private BigDecimal lectura;

    @Size(max = 1)
    @NotNull
    private String tipoLectu;

    @Size(max = 999999999)
    @NotNull
    private Long nroMedidor;

    @Size(max = 3)
    @NotNull
    private String marcaMedidor;

    public void setCorrFactu(int corrFactu){ this.corrFactu = corrFactu; }
    public int getCorrFactu(){ return this.corrFactu; }

    public void setFechaLectu(Date fechaLectu){ this.fechaLectu = fechaLectu; }
    public Date getFechaLectu() { return this.fechaLectu; }

    public void setLectura(BigDecimal lectura) { this.lectura = lectura; }
    public BigDecimal getLectura(){ return this.lectura; }

    public void setTipoLectu(String tipoLectu){ this.tipoLectu = tipoLectu; }
    public String getTipoLectu(){ return this.tipoLectu; }

    public void setNroMedidor(Long nroMedidor){ this.nroMedidor = nroMedidor; }
    public Long getNroMedidor() {return this.nroMedidor; }

    public void setMarcaMedidor(String marcaMedidor) { this.marcaMedidor = marcaMedidor; }
    public String getMarcaMedidor(){ return this.marcaMedidor; }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LecturaResponse{");
        sb.append("corrFactu=").append(corrFactu);
        sb.append(", fechaLectu=").append(df.format(fechaLectu));
        sb.append(", lectura=").append(lectura);
        sb.append(", tipoLectu='").append(tipoLectu).append('\'');
        sb.append(", nroMedidor=").append(nroMedidor);
        sb.append(", marcaMedidor='").append(marcaMedidor).append('\'');
        sb.append('}');
        return sb.toString();
    }

    private static final SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
}
