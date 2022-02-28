<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Viagem</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<br />
	<div align="center" class="container">
		<form action="viagem" method="post">
			<table>
				<tr>
					<td align="center">
						<input class="input_data_id" type="number" min="0"
							step="1" id="id" name="id" placeholder="#COD"
							>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" id="botao" name="botao" value="Descrição Viagem">
					</td>
					<tr>
					<td>
						<input type="submit" id="botao" name="botao" value="Descrição Ônibus">
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
	<br />
	<br />
	<div align="center">
		<c:if test="${not empty viagem }">
			<table>
					<thead>
						<tr>
							<th><b>#COD</b></th>
							<th><b>PLACA</b></th>
							<th><b>SAIDA</b></th>
							<th><b>CHEGADA</b></th>
							<th><b>PARTIDA</b></th>
							<th><b>DESTINO</b></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><c:out value="${viagem.codigo}" /></td>
							<td><c:out value="${viagem.onibus.placa}" /></td>
							<td><c:out value="${viagem.hr_saida }" /></td>
							<td><c:out value="${viagem.hr_chegada }" /></td>
							<td><c:out value="${viagem.partida }" /></td>
							<td><c:out value="${viagem.destino }" /></td>
						</tr>
					</tbody>
			</table>
		</c:if>		
	</div>
	<div align="center">
		<c:if test="${not empty onibus }">
			<table>
					<thead>
						<tr>
							<th><b>#COD</b></th>
							<th><b>NOME</b></th>
							<th><b>PLACA</b></th>
							<th><b>MARCA</b></th>
							<th><b>ANO</b></th>
							<th><b>DESCRICAO</b></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><c:out value="${viagem.codigo}" /></td>
							<td><c:out value="${viagem.motorista.nome}" /></td>
							<td><c:out value="${viagem.onibus.placa }" /></td>
							<td><c:out value="${viagem.onibus.marca }" /></td>
							<td><c:out value="${viagem.onibus.ano }" /></td>
							<td><c:out value="${viagem.onibus.descricao }" /></td>
						</tr>
					</tbody>
			</table>
		</c:if>		
	</div>
</body>
</html>