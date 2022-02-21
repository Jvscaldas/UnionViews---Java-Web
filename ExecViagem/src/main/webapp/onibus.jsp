<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Onibus</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<br />
	<div align="center" class="container">
		<form action="onibus" method="post">
			<p class="title">
				<b>Onibus</b>
			</p>
			<table>
				<tr>
					<td colspan="3">
						<input class="input_data_placa" type="text" id="placa" name="placa" placeholder="Placa"
						value='<c:out value="${onibus.placa }"></c:out>'>
					</td>
					<td>
						<input class="input_data_placa" type="text" id="marca" name="marca" placeholder="Marca"> 
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<input class="input_data_id" type="number" min="0" step="1" id="ano" name="ano" placeholder="Ano"
						value='<c:out value="${onibus.ano }"></c:out>'>
					</td>
					<td>
						<input class="input_data_placa" type="text" id="descricao" name="descricao" placeholder="Descricao"> 
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" id="botao" name="botao" value="Buscar">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br />
	<div align="center">
		<c:if test="${not empty erro }">
			<H2><c:out value="${erro }" /></H2>
		</c:if>
	</div>
	<div align="center">
		<c:if test="${not empty saida }">
			<H3><c:out value="${saida }" /></H3>
		</c:if>
	</div>
</body>
</html>