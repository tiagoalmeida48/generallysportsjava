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
.profile-avatar {
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
			<h1>Usuário</h1>

			<br> <br>

			<c:forEach items="usuario">
				<fmt:parseDate value="${usuarioForm.usuario.pessoa.dtNascimento }"
					pattern="yyyy-MM-dd" type="date" var="parsedDate" />

				<div class="row">

					<div class="col s3"></div>
					<div class="col s6">
						<div class="card">
							<br>
							<div class="card-image">
								<c:if test="${usuarioForm.usuario.getCaminhoFoto() == null }">
									<img class="profile-avatar" src="/img/default_avatar.png"
										alt="Avatar do Usuário">
								</c:if>
								<c:if test="${usuarioForm.usuario.getCaminhoFoto() != null}">
									<img class="profile-avatar"
										src="/${usuarioForm.usuario.getCaminhoFoto() }"
										alt="Avatar do Usuário">
								</c:if>
							</div>
							<div class="card-content">
								<h5 style="text-transform: uppercase;" class="black-text">
									${usuarioForm.usuario.pessoa.nome }</h5>
								<hr />

								<table class="striped">
									<tbody>
										<tr>
											<td>ID:</td>
											<td>${usuarioForm.usuario.idLogin}</td>
										</tr>
										<tr>
											<td>Login:</td>
											<td>${usuarioForm.usuario.login}</td>
										</tr>
										<tr>
											<td>Email:</td>
											<td>${usuarioForm.usuario.email}</td>
										</tr>
										<tr>
											<td>CPF:</td>
											<td class="fmt-cpf">${usuarioForm.usuario.pessoa.cpf}</td>
										</tr>
										<tr>
											<td>Data Nascimento:</td>
											<td><fmt:formatDate value="${parsedDate }"
													pattern="dd/MM/yyyy" /></td>
										</tr>
										<tr>
											<td>Sexo:</td>
											<td>${usuarioForm.usuario.pessoa.sexo}</td>
										</tr>
										<tr>
											<td>Telefone:</td>
											<td class="fmt-tel">${usuarioForm.usuario.pessoa.telefone}</td>
										</tr>
										<tr>
											<td>Status:</td>
											<td><c:if test="${!usuarioForm.usuario.inativo }">
													<span class="chip green-text">Ativo</span>
												</c:if> <c:if test="${usuarioForm.usuario.inativo }">
													<span class="chip red-text">Inativo</span>
												</c:if></td>
										</tr>
									</tbody>
								</table>

								<h5>Permissões</h5>
								<c:forEach items="${usuarioForm.listaPerfil }" var="authority">
									<div class="chip">${authority.getAuthority() }</div>
								</c:forEach>
			</c:forEach>
		</div>
	</div>

	</div>
	<div class="col s3"></div>


	</div>



	<div class="row">
		<div class="col s3"></div>
		<div class="col s6">
			<a href="${s:mvcUrl('listarUsuarios').build() }"
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