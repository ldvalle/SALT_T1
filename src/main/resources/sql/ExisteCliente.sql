SELECT '0009' codigoEmpresa, c.numero_cliente numeroSuministro
FROM cliente c
WHERE c.numero_cliente = :#${header.numeroSuministro}
