package edesur.t1.srv.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import edesur.t1.srv.validacion.CheckEmpresa;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class AdeDebAutRequest {
	//@CheckEmpresa
	@Size(max = 4)
	private String codigoEmpresa;

	@NotNull
	@Size(max = 12)
	private String cuentaContrato;
	
	//Este no lo vamos a usar
	@Size(max = 3)
	private String codigoBanco;

	@Size(max = 4)
	private String codBanco;

	//Este no lo vamos a usar
	@Size(max = 10)
	private String cuentaCorriente;

	@Size(max = 1)
	private String accion;

	@Size(max = 4)
	private String claseTarjeta;

	@Size(max = 16)
	private String nroTarjeta;
	
	@Size(max = 22)
	private String nroCBU;

	@Size(max = 2)
	private String tipoCuenta;	
	 
	public String getCodigoEmpresa() { return codigoEmpresa; }
	public void setCodigoEmpresa(String codigoEmpresa) {this.codigoEmpresa = codigoEmpresa; }

	public String getCuentaContrato() { return cuentaContrato; }
	public void setCuentaContrato(String cuentaContrato) { this.cuentaContrato = cuentaContrato; }

	public String getCodigoBanco(){ return codigoBanco; }
	public void setCodigoBanco(String codigoBanco) { this.codigoBanco = codigoBanco; }
	
	public String getCodBanco(){ return codBanco; }
	public void setCodBanco(String codBanco) { this.codBanco = codBanco; }
	
	public String getCuentaCorriente(){ return cuentaCorriente; }
	public void setCuentaCorriente(String cuentaCorriente) { this.cuentaCorriente = cuentaCorriente; }
	
	public String getAccion(){ return accion; }
	public void setAccion(String accion) { this.accion = accion; }
	
	public String getClaseTarjeta(){ return claseTarjeta; }
	public void setClaseTarjeta(String claseTarjeta) { this.claseTarjeta = claseTarjeta; }

	public String getNroTarjeta(){ return nroTarjeta; }
	public void setNroTarjeta(String nroTarjeta) { this.nroTarjeta = nroTarjeta; }

	public String getNroCBU(){ return nroCBU; }
	public void setNroCBU(String nroCBU) { this.nroCBU = nroCBU; }	

	public String getTipoCuenta(){ return tipoCuenta; }
	public void setTipoCuenta(String tipoCuenta) { this.tipoCuenta = tipoCuenta; }
	
}
