SELECT c1.numero_cliente numerosuministro,
' ' nroOrdenSap,
(c1.numero_cliente || LPAD(c1.corr_corte, 4, '0') || 'CORTFOPARG') idCorteRepo,
'C' tipoRegistro,
c1.motivo_corte motivo,
CASE
	WHEN c1.fecha_corte IS NULL THEN '20'
  ELSE '21'
END estado,
c1.fecha_corte fechaEjecucion,
c1.fecha_ini_evento fechaSolicitud,
' ' accionRealizada,
' ' usuario,
' ' tipo
FROM correp c1
WHERE c1.numero_cliente = :#${header.numeroSuministro}
AND c1.fecha_ini_evento BETWEEN :#${header.fechaDesde} AND :#${header.fechaHasta}
AND c1.motivo_corte IS NOT NULL
AND c1.tramite_repo IS NULL
UNION
SELECT c2.numero_cliente numerosuministro,
' ' nroOrdenSap,
(c2.numero_cliente || LPAD(c2.corr_repo, 4, '0') || 'REPOFOPARG') idCorteRepo,
'R' tipoRegistro,
c2.motivo_corte motivo,
CASE
	WHEN c2.fecha_sol_repo IS NULL THEN '22'
  ELSE '30'
END estado,
c2.fecha_reposicion fechaEjecucion,
c2.fecha_ini_evento fechaSolicitud,
' ' accionRealizada,
' ' usuario,
' ' tipo
FROM correp c2
WHERE c2.numero_cliente = :#${header.numeroSuministro}
AND c2.fecha_sol_repo BETWEEN :#${header.fechaDesde} AND :#${header.fechaHasta}
AND c2.motivo_corte IS NOT NULL
UNION
SELECT c3.numero_cliente numerosuministro,
' ' nroOrdenSap,
c3.numero_cliente || TO_CHAR(c3.fecha_solicitud, '%Y%m%d') || 'PRORFOPARG' idCorteRepo,
'P' tipoRegistro,
c3.cod_motivo motivo,
CASE
	WHEN c3.fecha_anterior + c3.dias > TODAY THEN 'A'
  ELSE 'D'
END estado,
c3.fecha_solicitud fechaEjecucion,
c3.fecha_solicitud fechaSolicitud,
' ' accionRealizada,
c3.rol usuario,
c3.tipo tipo
FROM corplazo c3
WHERE c3.numero_cliente = :#${header.numeroSuministro}
AND c3.fecha_solicitud BETWEEN :#${header.fechaDesde} AND :#${header.fechaHasta}
ORDER BY 8
