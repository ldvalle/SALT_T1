package edesur.t1.srv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
   "codigoBarras1",
   "codigoBarras2"
})

public class ComprobantePagoResponse extends ResponseBase{ 
	@Size(max=60)
	private String codigoBarras1;

	@Size(max=60)
	private String codigoBarras2;

	public String getCodigoBarras1(){ return codigoBarras1; }
	public void setCodigoBarras1(String codigoBarras1){ this.codigoBarras1 = codigoBarras1; }
	
	public String getCodigoBarras2(){ return codigoBarras2; }
	public void setCodigoBarras2(String codigoBarras2){ 
		this.codigoBarras2 = codigoBarras2; 
	}

	@Override
	public String toString() {
	  final StringBuilder sb = new StringBuilder("ComprobantePagoResponse{");
	  sb.append(", 'codigoBarras1'='").append(codigoBarras1).append('\'');
	  sb.append(", 'codigoBarras2'='").append(codigoBarras2).append('\'');
	  sb.append('}');
	  return sb.toString();
	}

}


