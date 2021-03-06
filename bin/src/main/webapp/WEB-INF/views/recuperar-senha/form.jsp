<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="pt-BR">

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
</head>

<body>

	<%@ include file="../base/menu.jsp"%>

	<div class="container">

		<c:if test="${mensagemSucesso != null }">
			<div class="status-message row">
				<div class="center col s4 green white-text animated bounceInLeft">
					<p>${mensagemSucesso }</p>
				</div>
			</div>
		</c:if>
		<c:if test="${mensagemErro != null }">
			<div class="status-message row">
				<div class="center col s4 red white-text animated bounceInLeft">
					<p>${mensagemErro }</p>
				</div>
			</div>
		</c:if>


		<div class="row center">
			<br> <br>
			<h3>Esqueci minha Senha</h3>
			<br> <br>

			<div class="row">
				<f:form method="POST"
					action="${s:mvcUrl('verificarEmail').build() }">
					<div class="row">
						<div class="col s4"></div>
						<div class="col s4">

							<div class="input-field col s12">
								<label for="usuario.email">E-mail</label> <input
									id="usuario.email" name="usuario.email" type="text"
									class="validate" autofocus>
							</div>


							<div class="input-field col s12">
								<input type="submit" value="Enviar" class="left btn botao">
							</div>

						</div>
					</div>
				</f:form>
			</div>

		</div>
	</div>
	<%@ include file="../base/rodape.jsp"%>



	<!--Materialize JS-->
	<script src="/js/jquery-3.4.1.min.js"></script>
	<script src="/js/jquery.mask.min.js"></script>
	<script src="/js/materialize.min.js"></script>
	<script src="/js/main.js"></script>
	<script src="/js/modalExcluir.js"></script>

	<script>
		setTimeout(function() {
			$('.status-message').fadeOut('slow');
		}, 5000);
	</script>
</body>

</html>