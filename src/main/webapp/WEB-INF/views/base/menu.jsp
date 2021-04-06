<%@ page contentType="text/html; charset=UTF-8" %>
	<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
		<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				<!--Menu de Navegação-->
				<header>
					<ul id="submenuservicos" class="blue darken-4 dropdown-content">
						<li><a href="${s:mvcUrl('academias').build()}">Academias</a></li>
						<li><a href="${s:mvcUrl('clinicas').build()}">Clinicas</a></li>
						<li><a href="${s:mvcUrl('suplementos').build()}">Suplementos</a></li>
						<li><a href="${s:mvcUrl('acessorios').build()}">Produtos Esportivos</a></li>
					</ul>
					<div class="navbar-fixed">
						<nav>
							<div class="nav-wrapper blue darken-4">
								<a href="#!" class="brand-logo"><img src="img/fundbig.png"></a>
								<a href="#" data-target="mobile-demo" class="sidenav-trigger"><i
										class="material-icons">menu</i></a>
								<ul class="centralizarMenuHome hide-on-med-and-down">
									<li><a href="${s:mvcUrl('home').build() }">Home</a></li>
									<li><a class="dropdown-trigger" href="#!" data-target="submenuservicos">Serviços<i class="material-icons right">arrow_drop_down</i></a></li>
									<li><a href="${s:mvcUrl('sobre').build() }">Quem Somos</a></li>
									<li><a href="${s:mvcUrl('contato').build() }">Contato</a></li>
									<sec:authorize access="!isAuthenticated()">
										<li><a href="${s:mvcUrl('login').build() }">Entrar</a></li>
									</sec:authorize>
									<sec:authorize access="isAuthenticated()">
										<li><a href="${s:mvcUrl('paginaPainel').build() }">Painel Administrativo</a></li>
									</sec:authorize>
								</ul>
							</div>
						</nav>
					</div>
					<ul class="sidenav" id="mobile-demo">
						<li><a href="${s:mvcUrl('home').build() }">Home</a></li>
						<li><a href="${s:mvcUrl('sobre').build() }">Quem Somos</a></li>
						<li><a href="${s:mvcUrl('contato').build() }">Contato</a></li>
						<hr>
						<li><a href="${s:mvcUrl('academias').build()}">Academias</a></li>
						<li><a href="${s:mvcUrl('clinicas').build()}">Clinicas</a></li>
						<li><a href="${s:mvcUrl('suplementos').build()}">Suplementos</a></li>
						<li><a href="${s:mvcUrl('acessorios').build()}">Produtos Esportivos</a></li>
						<hr>
						<sec:authorize access="!isAuthenticated()">
							<li><a href="${s:mvcUrl('login').build() }">Entrar</a></li>
						</sec:authorize>
						<sec:authorize access="isAuthenticated()">
							<li><a href="${s:mvcUrl('paginaPainel').build() }">Painel Administrativo</a></li>
						</sec:authorize>
					</ul>
				</header>