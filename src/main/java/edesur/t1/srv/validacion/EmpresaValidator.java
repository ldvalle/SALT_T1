package edesur.t1.srv.validacion;

import edesur.t1.srv.Configuracion;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmpresaValidator implements ConstraintValidator<CheckEmpresa, String> {
    private  boolean obligatorio;

    @Override
    public void initialize(CheckEmpresa parameters) {
        obligatorio = parameters.obligatorio();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (!obligatorio && value == null) {
            return true;
        }

        return Configuracion.CodigoEmpresa.equals(value);
    }
}
