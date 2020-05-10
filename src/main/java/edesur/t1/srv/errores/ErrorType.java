package edesur.t1.srv.errores;

public enum ErrorType {
    ParametersValidationError("E400SC0000", "Error en validación de parámetros"),
    ClienteNoExiste ("E400SC0001", "Cliente Inexistente"),
    ClienteNoEnEstado("E400SC0002", "Cliente Inexistente, Inactivo o en Ciclo de Facturación"),

    InternalError("E500SC0000", "Error Interno"),
    SqlError("E500SC0001", "Error SQL");

    private String codigo;
    private String descripcion;

    private ErrorType(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
