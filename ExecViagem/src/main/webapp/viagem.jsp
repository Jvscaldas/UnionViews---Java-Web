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
			<p class="title">
				<b>Viagens</b>
			</p>
			<table>
				<tr>
					<td colspan="3">
						<input class="input_data_id" type="number" min="0"
							step="1" id="id" name="id" placeholder="#COD"
							value='<c:out value="${viagem.codigo }"></c:out>'>
					
						<input class="input_data_placa" type="text" id="nome" name="nome"
							placeholder="Placa" 
							value='<c:out value="${viagem.destino }"></c:out>'>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<input class="input_data" type="text" id="nome" name="nome"
							placeholder="Destino"
							value='<c:out value="${viagem.destino }"></c:out>'>
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<input class="input_data" type="text" id="nome" name="nome"
							placeholder="Nome do motorista"
							value='<c:out value="${viagem.destino }"></c:out>'>
					</td>
				</tr>
				
				<tr>
					<td>
						<input type="submit" id="botao" name="botao" value="Descrição Viagem">
					</td>
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
	<div align="left">
		<c:if test="${not empty viagens }">
			<table>
				<thead>
					<tr>
						<th><b>#CODIGO</b></th>
						<th><b>PLACA</b></th>
						<th><b>CHEGADA</b></th>
						<th><b>SAIDA</b></th>
						<th><b>PARTIDA</b></th>
						<th><b>DESTINO</b></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${viagens }" var="m">
					<tr>
						<td><c:out value="${v.codigo }" /></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>