<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Generally Sports</title>

<!-- Materialize CSS -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="/css/materialize.min.css"
	media="screen,projection" />

<link rel="stylesheet" href="/css/style.css" />
<link rel="stylesheet" href="/css/animate.css" />

<style>
/*Configuração Temporária*/
.product-image {
	max-width: 150px;
	margin: 0 auto;
}
</style>
</head>

<body>

	<%@ include file="../base/menuAdministrativo.jsp"%>

	<div class="container">

		<div class="row">
			<br> <br>
			<h1>Nota Fiscal</h1>

			<br> <br>

			<c:forEach items="notaFiscal">
				<fmt:parseDate value="${notaFiscal.dtNotaFiscal }"
					pattern="yyyy-MM-dd" type="date" var="parsedDateNF" />
				<fmt:parseDate value="${notaFiscal.dtRecebimento}"
					pattern="yyyy-MM-dd" type="date" var="parsedDateRecebimento" />

				<div class="row">

					<div class="col s3"></div>
					<div class="col s6">
						<div class="card">
							<br>
							<div class="card-content">
								<h5 style="text-transform: uppercase;" class="black-text">
									NF Nº ${notaFiscal.numeroNotaFiscal} - Série
									${notaFiscal.serieNotaFiscal }</h5>
								<hr />

								<table class="striped">
									<tbody>
										<tr>
											<td>ID Nota Fiscal:</td>
											<td>${notaFiscal.idNotaFiscal }</td>
										</tr>
										<tr>
											<td>Série Nota Fiscal:</td>
											<td>${notaFiscal.serieNotaFiscal }</td>
										</tr>
										<tr>
											<td>Número Nota Fiscal:</td>
											<td>${notaFiscal.numeroNotaFiscal }</td>
										</tr>
										<tr>
											<td>Data da Nota Fiscal:</td>
											<td><fmt:formatDate value="${parsedDateNF }"
													pattern="dd/MM/yyyy" /></td>
										</tr>
										<tr>
											<td>Data do Recebimento:</td>
											<td><fmt:formatDate value="${parsedDateRecebimento }"
													pattern="dd/MM/yyyy" /></td>
										</tr>
										<tr>
											<td>Número do Pedido:</td>
											<td>${notaFiscal.pedido.idPedido}</td>
										</tr>
										<tr>
											<td>Situação do Pedido:</td>
											<td>${notaFiscal.pedido.situacaoPedido.displayValue }</td>
										</tr>
										<tr>
											<td>Status do Pedido:</td>
											<td><c:if test="${!pedido.inativo }">
													<span class="chip green-text">Ativo</span>
												</c:if> <c:if test="${pedido.inativo }">
													<span class="chip red-text">Inativo</span>
												</c:if></td>
										</tr>
									</tbody>
								</table>
								<h5 style="text-transform: uppercase;" class="black-text">
									Detalhe do Pedido</h5>
								<hr />
								<table>
									<thead>
										<th>Cód.</th>
										<th>Descrição</th>
										<th>Qtde</th>
										<th>Val. Unitário</th>
										<th>Total</th>
									</thead>
									<tbody>
										<c:forEach items="${notaFiscal.pedido.itens}" var="item">
											<tr>
												<td>${item.produto.idProduto }</td>
												<td>${item.produto.descricao }</td>
												<td>${item.quantidade }</td>
												<td><fmt:formatNumber value="${item.produto.valor }"
														type="currency" /></td>
												<!-- Temporário -->
												<td><fmt:formatNumber
														value="${item.produto.valor*item.quantidade }"
														type="currency" /></td>
											</tr>
										</c:forEach>
										<tr>
											<td colspan="4" style="text-align: right; font-weight: bold;">Total</td>
											<td colspan="1"><b><fmt:formatNumber
														value="${notaFiscal.pedido.valorFinal }" type="currency" /></b></td>
										</tr>
									</tbody>
								</table>
			</c:forEach>
		</div>
	</div>

	</div>
	<div class="col s3"></div>


	</div>



	<div class="row">
		<div class="col s3"></div>
		<div class="col s6">
			<a href="${s:mvcUrl('listarNotasFiscais').build() }"
				class="waves-effect waves-light btn red"><i
				class="material-icons left">arrow_back</i>Voltar</a>
		</div>
		<div class="col s3"></div>
	</div>
	</div>
	</div>

	<%@ include file="../base/rodape.jsp"%>

	<script src="/js/jquery-3.4.1.min.js"></script>
	<script src="/js/jquery.mask.min.js"></script>
	<script src="/js/materialize.min.js"></script>
	<script src="/js/main.js"></script>
</body>

</html>