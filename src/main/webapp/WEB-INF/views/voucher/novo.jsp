<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html lang="pt-BR">

	<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
		<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

					<head>
						<meta charset="UTF-8">
						<meta name="viewport" content="width=device-width, initial-scale=1.0">
						<title>Generally Sports</title>

						<!-- Materialize CSS -->
						<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
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

						<%@ include file="../base/menuAdministrativo.jsp" %>

							<div class="container">

								<div class="row">

									<div class="row">
										<div class="col s10 ">
											<div class="card ">

												<div class="card-content">
													<span class="card-title center">
														<h1>Voucher</h1>
													</span>

													<div class="row">
														<c:if test="${voucher.idVoucher != null }">

															<div class="card-image col s6">
																<c:if test="${voucher.getCaminhoFoto() == null }">
																	<img class="product-image"
																		src="/img/default_product.png"
																		alt="Imagem do Voucher">
																</c:if>
																<c:if test="${voucher.getCaminhoFoto() != null}">
																	<img class="product-image"
																		src="/img/${voucher.getCaminhoFoto() }"
																		alt="Imagem do Produto">
																</c:if>
															</div>

															<f:form action="${s:mvcUrl('alterarFotoVoucher').build() }"
																method="POST" enctype="multipart/form-data"
																modelAttribute="voucher">
																<f:hidden path="idVoucher" />
																<div class="file-field input-field">
																	<div class="btn indigo">
																		<span><i
																				class="material-icons">attach_file</i></span>
																		<input type="file" name="foto" multiple>
																	</div>
																	<div class="file-path-wrapper">
																		<input class="file-path validate" type="text"
																			placeholder="Selecione uma imagem">
																	</div>
																	<button class="btn-small indigo"
																		type="submit">Salvar</button>
																</div>
															</f:form>
														</c:if>

														<f:form method="POST"
															action="${s:mvcUrl('salvarVoucher').build() }"
															modelAttribute="voucher" class="col s12">
															<f:hidden path="idVoucher" />


															<div class="row">
																<div class="input-field col s12">
																	<i class="material-icons prefix">inventory_2</i>
																	<f:input path="titulo" cssClass="validate"
																		placeholder="Nome do voucher" />
																	<f:errors path="titulo"
																		cssClass="helper-text red-text" />
																	<label for="titulo">Voucher</label>
																</div>
															</div>
															<div class="row">
																<div class="input-field col s12">
																	<i class="material-icons prefix">paid</i>
																	<f:input path="precoVenda" cssClass="validate"
																		type="number" placeholder="0,00" />
																	<f:errors path="precoVenda"
																		cssClass="helper-text red-text" />
																	<label for="precoVenda">Preço de Venda</label>
																</div>
															</div>
													</div>
													<div class="card-action">
														<div class="row">

															<a href="${s:mvcUrl('listarVoucher').build() }"
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
								<%@ include file="../base/rodape.jsp" %>



									<!--Materialize JS-->
									<script src="/js/jquery-3.4.1.min.js"></script>
									<script src="/js/jquery.mask.min.js"></script>
									<script src="/js/materialize.min.js"></script>
									<script src="/js/main.js"></script>
					</body>

	</html>