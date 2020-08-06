package edesur.t1.srv.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import edesur.t1.srv.validacion.CheckEmpresa;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class TipoRepartoRequest {
   @CheckEmpresa
   private String codigoEmpresa;	
	@Size(max = 40)
	private String caseNumber1;
	@Size(max = 40)
	private String caseNumber2;
	@Size(max = 30)
	private String motivo;
	@Size(max = 30)
	private String subMotivo;
	@Size(max = 12)
	private String contrato;
	@Size(max = 2)
	private String emailBilling;
	@Size(max = 241)
	private String email;
	@Size(max = 10)
	private String nroCuenta;
	@Size(max = 4)
	private String tipo;
	@Size(max = 60)
	private String calle;
	@Size(max = 10)
	private String numeroCalle;
	@Size(max = 40)
	private String piso_depto;
	@Size(max = 10)
	private String codigoPostal;
	@Size(max = 40)
	private String ciudadLocalidad;
	@Size(max = 40)
	private String barrioPartido;
	@Size(max = 3)
	private String estadoProvincia;
	@Size(max = 40)
	private String entreCalle1;
	@Size(max = 40)
	private String entreCalle2;
	@Size(max = 60)
	private String acuseRecibo;
	
	private String pisoPostal;
	private String deptoPostal;
	
	 
	/*	SETTERS AND GETTERS */
	public String getCodigoEmpresa() { return codigoEmpresa; }
	public void setCodigoEmpresa(String codigoEmpresa) { this.codigoEmpresa = codigoEmpresa; }
    
	public String getCaseNumber1() { return caseNumber1; }
	public void setCaseNumber1(String caseNumber1) { this.caseNumber1 = caseNumber1; }

	public String getCaseNumber2() { return caseNumber2; }
	public void setCaseNumber2(String caseNumber2) { this.caseNumber2 = caseNumber2; }

	public String getMotivo() { return motivo; }
	public void setMotivo(String motivo) { this.motivo = motivo; }

	public String getSubMotivo() { return subMotivo; }
	public void setSubMotivo(String subMotivo) { this.subMotivo = subMotivo; }

	public String getContrato() { return contrato; }
	public void setContrato(String contrato) { this.contrato = contrato; }

	public String getEmailBilling() { return emailBilling; }
	public void setEmailBilling(String emailBilling) { this.emailBilling = emailBilling; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getNroCuenta() { return nroCuenta; }
	public void setNroCuenta(String nroCuenta) { this.nroCuenta = nroCuenta; }

	public String getTipo() { return tipo; }
	public void setTipo(String tipo) { this.tipo = tipo; }

	public String getCalle() { return calle; }
	public void setCalle(String calle) { this.calle = calle; }

	public String getNumeroCalle() { return numeroCalle; }
	public void setNumeroCalle(String numeroCalle) { this.numeroCalle = numeroCalle; }

	public String getPiso_depto() { return piso_depto; }
	public void setPiso_depto(String piso_depto) { this.piso_depto = piso_depto; }

	public String getCodigoPostal() { return codigoPostal; }
	public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }

	public String getCiudadLocalidad() { return ciudadLocalidad; }
	public void setCiudadLocalidad(String ciudadLocalidad) { this.ciudadLocalidad = ciudadLocalidad; }

	public String getBarrioPartido() { return barrioPartido; }
	public void setBarrioPartido(String barrioPartido) { this.barrioPartido = barrioPartido; }

	public String getEstadoProvincia() { return estadoProvincia; }
	public void setEstadoProvincia(String estadoProvincia) { this.estadoProvincia = estadoProvincia; }

	public String getEntreCalle1() { return entreCalle1; }
	public void setEntreCalle1(String entreCalle1) { this.entreCalle1 = entreCalle1; }

	public String getEntreCalle2() { return entreCalle2; }
	public void setEntreCalle2(String entreCalle2) { this.entreCalle2 = entreCalle2; }

	public String getAcuseRecibo() { return acuseRecibo; }
	public void setAcuseRecibo(String acuseRecibo) { this.acuseRecibo = acuseRecibo; }


	public String getPisoPostal() { return pisoPostal; }
	public void setPisoPostal(String piso_depto) { 
	 String partes[] = pisoPostal.split(";");
	 
		if(partes.length > 0){
			this.pisoPostal = partes[0];
		}else{
			this.pisoPostal = piso_depto;
		}
	}
    
	public String getDeptoPostal() { return deptoPostal; }
	public void setDeptoPostal(String piso_depto) { 
	 String partes[] = pisoPostal.split(";");
	 
		if(partes.length > 0){
			this.deptoPostal = partes[1];
		}else{
			this.deptoPostal = piso_depto;
		}
	}

    
}
