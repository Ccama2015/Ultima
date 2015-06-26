<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registro de Alumnos</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/registro.js"></script>
</head>
<body>
<table align="center">
	<tr>
		<td>
			<form>
			<li><label>CUI de Alumno</label></li>
			<input type="text" id="cui" required><br>
			<li><label>NOMBRE DE ALUMNO</label></li>
			<input type="text" id="nombre" required><br>
			<li><label>APELLIDO PARTERNO</label></li>
			<input type="text" id="apellidoPaterno" required><br>
			<li><label>APELLIDO MATERNO</label></li>
			<input type="text" id="apellidoMaterno" required><br><br>
			<input type="button" id="registro" value="REGISTRAR">
			<div id="cargar"></div>
			</form>
		</td>
	</tr>
</table>
</body>
</html>