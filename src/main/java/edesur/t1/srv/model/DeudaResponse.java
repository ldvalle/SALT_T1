package edesur.t1.srv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.math.RoundingMode;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "codigo",
        "descripcion",
        "deudaTotal",
        "numeroFactura",
        "importe",
        "parcelas",
        "productos",
        "deudaAlumbradoPublico",
        "parcelasDividida",
        "saldoExigible",
        "saldoNoExigible",
        "facturaCNR",
        "saldoDisputa",
        "convenioEnergia",
        "convenioProductos",
        "convenioAlumbradoPublico",
        "antiguedad",
        "depositoEnGarantia"
})
public class DeudaResponse extends ResponseBase {
    @DecimalMax("9999999999")
    private BigDecimal deudaTotal;

    @Size(max = 16)
    private String numeroFactura;

    @DecimalMax("9999999999")
    private BigDecimal importe;

    @DecimalMax("9999999999")
    private BigDecimal  parcelas;

    @DecimalMax("9999999999")
    private BigDecimal productos;

    @DecimalMax("9999999999")
    private BigDecimal deudaAlumbradoPublico;

    @DecimalMax("9999999999")
    private BigDecimal parcelasDividida;

    @DecimalMax("9999999999")
    private BigDecimal saldoExigible;

    @DecimalMax("9999999999")
    private BigDecimal saldoNoExigible;

    @DecimalMax("9999999999")
    private BigDecimal facturaCNR;

    @DecimalMax("9999999999")
    private BigDecimal saldoDisputa;

    @DecimalMax("9999999999")
    private BigDecimal convenioEnergia;

    @DecimalMax("9999999999")
    private BigDecimal convenioProductos;

    @DecimalMax("9999999999")
    private BigDecimal convenioAlumbradoPublico;

    @DecimalMin("0")
    @DecimalMax("9999")
    private Integer antiguedad;

    @DecimalMax("9999999999")
    private BigDecimal depositoEnGarantia;

    public BigDecimal getDeudaTotal() {
        return round(deudaTotal);
    }

    public void setDeudaTotal(BigDecimal deudaTotal) {
        this.deudaTotal = deudaTotal;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public BigDecimal getImporte() {
        return round(importe);
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public BigDecimal getParcelas() {
        return round(parcelas);
    }

    public void setParcelas(BigDecimal parcelas) {
        this.parcelas = parcelas;
    }

    public BigDecimal getProductos() {
        return round(productos);
    }

    public void setProductos(BigDecimal productos) {
        this.productos = productos;
    }

    public BigDecimal getDeudaAlumbradoPublico() {
        return round(deudaAlumbradoPublico);
    }

    public void setDeudaAlumbradoPublico(BigDecimal deudaAlumbradoPublico) {
        this.deudaAlumbradoPublico = deudaAlumbradoPublico;
    }

    public BigDecimal getParcelasDividida() {
        return round(parcelasDividida);
    }

    public void setParcelasDividida(BigDecimal parcelasDividida) {
        this.parcelasDividida = parcelasDividida;
    }

    public BigDecimal getSaldoExigible() {
        return round(saldoExigible);
    }

    public void setSaldoExigible(BigDecimal saldoExigible) {
        this.saldoExigible = saldoExigible;
    }

    public BigDecimal getSaldoNoExigible() {
        return round(saldoNoExigible);
    }

    public void setSaldoNoExigible(BigDecimal saldoNoExigible) {
        this.saldoNoExigible = saldoNoExigible;
    }

    public BigDecimal getFacturaCNR() {
        return round(facturaCNR);
    }

    public void setFacturaCNR(BigDecimal facturaCNR) {
        this.facturaCNR = facturaCNR;
    }

    public BigDecimal getSaldoDisputa() {
        return round(saldoDisputa);
    }

    public void setSaldoDisputa(BigDecimal saldoDisputa) {
        this.saldoDisputa = saldoDisputa;
    }

    public BigDecimal getConvenioEnergia() {
        return round(convenioEnergia);
    }

    public void setConvenioEnergia(BigDecimal convenioEnergia) {
        this.convenioEnergia = convenioEnergia;
    }

    public BigDecimal getConvenioProductos() {
        return round(convenioProductos);
    }

    public void setConvenioProductos(BigDecimal convenioProductos) {
        this.convenioProductos = convenioProductos;
    }

    public BigDecimal getConvenioAlumbradoPublico() {
        return round(convenioAlumbradoPublico);
    }

    public void setConvenioAlumbradoPublico(BigDecimal convenioAlumbradoPublico) {
        this.convenioAlumbradoPublico = convenioAlumbradoPublico;
    }

    public Integer getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Integer antiguedad) {
        this.antiguedad = antiguedad;
    }

    public BigDecimal getDepositoEnGarantia() {
        return round(depositoEnGarantia);
    }

    public void setDepositoEnGarantia(BigDecimal depositoEnGarantia) {
        this.depositoEnGarantia = depositoEnGarantia;
    }

    private BigDecimal round(BigDecimal value) {
        return value == null ? null : value.setScale(2, RoundingMode.HALF_EVEN);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DeudaResponse{");
        sb.append("deudaTotal=").append(deudaTotal);
        sb.append(", numeroFactura='").append(numeroFactura).append('\'');
        sb.append(", importe=").append(importe);
        sb.append(", deudaAlumbradoPublico=").append(deudaAlumbradoPublico);
        sb.append(", saldoDisputa=").append(saldoDisputa);
        sb.append(", antiguedad=").append(antiguedad);
        sb.append('}');
        return sb.toString();
    }
}
