<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Generally Sports</title>

<!-- Materialize CSS -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="/css/materialize.min.css"
	media="screen,projection" />

<link rel="stylesheet" href="/css/style.css" />
</head>

<body>

	<%@ include file="base/menuAdministrativo.jsp"%>

	<div class="container">
		<div class="row center">
			<h1>Painel Administrativo</h1>

			<div class="row">
				<div class="col s12">
					<div class="row">
						<a href="${s:mvcUrl('listarUsuarios').build() }">
							<div style="padding: 30px; border-radius: 10px;"
								class="col s3 waves-effect black-seuphone">
								<i class="white-text large material-icons">person</i> <span
									class="white-text">
									<h5>Usuários</h5>
								</span>
							</div>
						</a>
						<div class="col s1"></div>
						<a href="${s:mvcUrl('listarPerfis').build() }">
							<div style="padding: 30px; border-radius: 10px;"
								class="col s3 waves-effect black-seuphone">
								<i class="white-text large material-icons">people</i> <span
									class="white-text">
									<h5>Perfis</h5>
								</span>
							</div>
						</a>
						<div class="col s1"></div>
						<a href="${s:mvcUrl('listarProdutos').build() }">
							<div style="padding: 30px; border-radius: 10px;"
								class="col s3 waves-effect black-seuphone">
								<i class="white-text large material-icons">store</i> <span
									class="white-text">
									<h5>Produtos</h5>
								</span>
							</div>
						</a>
					</div>
					<div class="row">
						<a href="${s:mvcUrl('listarPedidos').build() }">
							<div style="padding: 30px; border-radius: 10px;"
								class="col s3 waves-effect black-seuphone">
								<i class="white-text large material-icons">assignment</i> <span
									class="white-text">
									<h5>Pedidos</h5>
								</span>
							</div>
						</a>
						<div class="col s1"></div>
						<a href="${s:mvcUrl('listarFornecedores').build() }">
							<div style="padding: 30px 20px; border-radius: 10px;"
								class="col s3 waves-effect black-seuphone">
								<i class="white-text large material-icons">business_center</i> <span
									class="white-text">
									<h5>Fornecedor</h5>
								</span>
							</div>
						</a>
						<div class="col s1"></div>
						<a href="${s:mvcUrl('listarNotasFiscais').build() }">
							<div style="padding: 30px; border-radius: 10px;"
								class="col s3 waves-effect black-seuphone">
								<i class="white-text large material-icons">description</i> <span
									class="white-text">
									<h5>NFE</h5>
								</span>
							</div>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="base/rodape.jsp"%>

	<!--Materialize JS-->
	<script src="/js/jquery-3.4.1.min.js"></script>
	<script src="/js/jquery.mask.min.js"></script>
	<script src="/js/materialize.min.js"></script>
	<script src="/js/main.js"></script>
	<!-- <script src="/js/modalExcluir.js"></script> -->
</body>

</html>