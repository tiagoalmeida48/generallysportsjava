<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

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
.helper-text {
	font-family: Arial, sans-serif;
	text-align: left;
}

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

			<div class="row">
				<div class="col s12">
					<div class="card ">

						<div class="card-content">
							<span class="card-title center"><h1>Produto</h1></span>

							<div class="row">
								<c:if test="${produto.idProduto != null }">

									<div class="card-image col s6">
										<c:if test="${produto.getCaminhoFoto() == null }">
											<img class="product-image" src="/img/default_product.png"
												alt="Imagem do Produto">
										</c:if>
										<c:if test="${produto.getCaminhoFoto() != null}">
											<img class="product-image"
												src="/img/${produto.getCaminhoFoto() }"
												alt="Imagem do Produto">
										</c:if>
									</div>

									<f:form action="${s:mvcUrl('alterarFotoProduto').build() }"
										method="POST" enctype="multipart/form-data"
										modelAttribute="produto">
										<f:hidden path="idProduto" />
										<div class="file-field input-field">
											<div class="btn indigo">
												<span><i class="material-icons">attach_file</i></span> <input
													type="file" name="foto" multiple>
											</div>
											<div class="file-path-wrapper">
												<input class="file-path validate" type="text"
													placeholder="Selecione uma imagem">
											</div>
											<button class="btn-small indigo" type="submit">Salvar</button>
										</div>
									</f:form>
								</c:if>

								<f:form method="POST"
									action="${s:mvcUrl('salvarProduto').build() }"
									modelAttribute="produto" class="col s12">
									<f:hidden path="idProduto" />


									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">inventory_2</i>
											<f:input path="nomeProduto" cssClass="validate"
												placeholder="Nome do produto" />
											<f:errors path="nomeProduto" cssClass="helper-text red-text" />
											<label for="nomeProduto">Produto</label>
										</div>
										<div class="input-field col s6">
											<i class="material-icons prefix">description</i>
											<f:input path="descricao" cssClass="validate"
												placeholder="Descrição do Produto" />
											<f:errors path="descricao" cssClass="helper-text red-text" />
											<label for="descricao">Descrição</label>
										</div>
									</div>
									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">people</i>
											<f:select path="fornecedor">
												<c:if test="${produto.fornecedor != null }">
													<f:option selected="true" value="${produto.fornecedor }"
														label="${produto.fornecedor.razaoSocial }" />
												</c:if>
												<f:option value="">Selecione um Fornecedor</f:option>
												<c:forEach items="${listaFornecedores}" var="fornecedor">
													<f:option value="${fornecedor.id}">${fornecedor.razaoSocial}</f:option>
												</c:forEach>
											</f:select>
											<f:errors path="fornecedor" cssClass="helper-text red-text" />
										</div>
										<div class="input-field col s6">
											<i class="material-icons prefix">Categoria</i>
											<f:select path="categoria" id="categoria" cssClass="validate">
												<f:option value="">Selecione uma categoria</f:option>
												<f:option value="Acessórios">Acessórios</f:option>
												<f:option value="Suplementos">Suplementos</f:option>
												<f:option value="Modas">Modas</f:option>
											</f:select>
											<f:errors path="categoria" cssClass="helper-text red-text" />
										</div>
									</div>

									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">today</i>
											<f:input path="validade" class="datepicker"
												placeholder="validade" />
											<f:errors path="validade" cssClass="helper-text red-text" />
											<label class="active">Validade</label>
										</div>
										<div class="input-field col s6">
											<i class="material-icons prefix">paid</i>
											<f:input path="custoUnitario" cssClass="validate"
												type="number" placeholder="0,00" />
											<f:errors path="custoUnitario"
												cssClass="helper-text red-text" />
											<label for="custoUnitario">Custo Unitário</label>
										</div>
									</div>

									<div class="row">
										<div class="input-field col s6">
											<i class="material-icons prefix">paid</i>
											<f:input path="precoVenda" cssClass="validate" type="number"
												placeholder="0,00" />
											<f:errors path="precoVenda" cssClass="helper-text red-text" />
											<label for="precoVenda">Preço de Venda</label>
										</div>
										<sec:authorize access="hasRole('ROLE_ADMIN')">
											<div class="input-field col s6">
												<i class="material-icons prefix">description</i>
												<f:select path="inativo" id="inativo" cssClass="validate">
													<f:option value="false">Ativo</f:option>
													<f:option value="true">Inativo</f:option>
												</f:select>
												<f:errors path="inativo" cssClass="helper-text red-text" />
												<label for="inativo">Status do Produto</label>
											</div>
									</div>
									</sec:authorize>
							</div>
						</div>

					</div>
					<div class="card-action">
						<div class="row">

							<a href="${s:mvcUrl('listarProdutos').build() }"
								class="waves-effect waves-light btn red"><i
								class="material-icons left">arrow_back</i>Voltar</a>



							<button type="submit"
								class="waves-effect waves-light btn green white-text">
								<i class="material-icons left">add</i>Salvar
							</button>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</f:form>
	</div>
	<%@ include file="../base/rodape.jsp"%>



	<!--Materialize JS-->
	<script src="/js/jquery-3.4.1.min.js"></script>
	<script src="/js/jquery.mask.min.js"></script>
	<script src="/js/materialize.min.js"></script>
	<script src="/js/main.js"></script>
</body>

</html>