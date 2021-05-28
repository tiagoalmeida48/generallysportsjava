<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--Menu de Navegação-->
<header>
	<sec:authorize access="isAuthenticated()">
		<nav>
			<div class="nav-wrapper blue darken-4">
				<a href="#!" class="brand-logo"><img src="/img/fundbig.png"></a>
				<a href="#!" data-target="mobile-demo" class="sidenav-trigger"><i
					class="material-icons">menu</i></a>
				<ul class='right hide-on-med-and-down'>
					<li><a href="${s:mvcUrl('paginaPainel').build() }">Acessar
							Painel</a></li>
					<li><a href="${s:mvcUrl('listarFornecedores').build() }">Fornecedores</a></li>
					<li><a href="${s:mvcUrl('listarProdutos').build() }">Produtos</a></li>
					<li><a href="${s:mvcUrl('listarPedidos').build() }">Pedido
							de Compra</a></li>
					<li><a href="${s:mvcUrl('listarNotasFiscais').build() }">Notas
							Fiscais</a></li>
					<li><sec:authentication property="principal" var="user" /> <a
						class="dropdown-trigger" href="#!" data-target="submenuusuarios">
							<c:if
								test="${user.caminhoFoto == null || user.caminhoFoto == ''}">
								<img class="avatarMenu" src="/img/default_avatar.png"
									alt="Avatar do Usuário">
							</c:if> <c:if
								test="${user.caminhoFoto != null && user.caminhoFoto != ''}">
								<img class="avatarMenu" src="/img/${user.caminhoFoto}"
									alt="Avatar do Usuário">
							</c:if> <span><b style="text-transform: uppercase;"> <sec:authentication
										property="principal.login" />
							</b><i class="material-icons right">arrow_drop_down</i></span>
					</a></li>
				</ul>
			</div>
		</nav>
		<ul id="submenuusuarios" class="blue darken-4 dropdown-content">
			<li><a href="${s:mvcUrl('meuPerfil').build() }">Detalhes</a></li>
			<li><a href="${s:mvcUrl('listarUsuarios').build() }">Usuários</a></li>
			<li><a href="${s:mvcUrl('listarPerfis').build() }">Perfis</a></li>
			<li><a href="/logout">Sair</a></li>
		</ul>

		<ul id="mobile-demo" class="sidenav">
			<li><c:if test="${user.caminhoFoto == null }">
					<img style="max-width: 30px;" src="/img/default_avatar.png"
						alt="Avatar do Usuário">
				</c:if> <c:if test="${user.caminhoFoto != null}">
					<img style="width: 30px;" src="/${user.caminhoFoto }"
						alt="Avatar do Usuário">
				</c:if> <span><b style="text-transform: uppercase;"><sec:authentication
							property="principal.login" /></b></li>
			<li><a href="${s:mvcUrl('paginaPainel').build() }">Acessar
					Painel</a></li>
			<li><a href="${s:mvcUrl('listarFornecedores').build() }">Fornecedores</a></li>
			<li><a href="${s:mvcUrl('listarProdutos').build() }">Produtos</a></li>
			<li><a href="${s:mvcUrl('listarPedidos').build() }">Pedido
					de Compra</a></li>
			<li><a href="${s:mvcUrl('listarNotasFiscais').build() }">Notas
					Fiscais</a></li>
			<hr>
			<li><a href="${s:mvcUrl('meuPerfil').build() }">Detalhes</a></li>
			<li><a href="${s:mvcUrl('listarUsuarios').build() }">Usuários</a></li>
			<li><a href="${s:mvcUrl('listarPerfis').build() }">Perfis</a></li>
			<hr>
			<li><a href="/logout">Sair</a></li>
		</ul>
	</sec:authorize>
</header>