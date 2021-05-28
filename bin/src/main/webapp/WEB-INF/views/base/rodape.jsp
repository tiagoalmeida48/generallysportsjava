<!--Rodape-->
<%@ page contentType="text/html; charset=UTF-8"%>
<footer class="page-footer blue darken-4">
	<div class="container-fluid">
		<div class="row">
			<div class="col l4 s12">
				<h5 class="white-text">AJUDA E SUPORTE</h5>
				<ul>
					<li><a class="linkRodape"
						href="${s:mvcUrl('politica').build() }">POLÍTICA E PRIVACIDADE</a></li>
					<li><a class="linkRodape"
						href="${s:mvcUrl('perguntas').build() }">PERGUNTAS FREQUENTES</a></li>
					<li><a class="linkRodape"
						href="${s:mvcUrl('termos').build() }">TERMOS E CONDIÇÕES</a></li>
					<li><a class="linkRodape"
						href="${s:mvcUrl('seguranca').build() }">SEGURANÇA</a></li>
					<li><a class="linkRodape"
						href="${s:mvcUrl('servicos').build() }">SERVIÇOS</a></li>
				</ul>
			</div>
			<div class="col l4 s12">
				<h5 class="white-text">INSTITUCIONAL</h5>
				<ul>
					<li><a class="linkRodape"
						href="${s:mvcUrl('investidores').build() }">RELAÇÃO COM
							INVESTIDORES</a></li>
					<li><a class="linkRodape"
						href="${s:mvcUrl('trocas').build() }">POLÍTICA DE TROCAS</a></li>
					<li><a class="linkRodape"
						href="${s:mvcUrl('marketplace').build() }">MARKETPLACE</a></li>
				</ul>
			</div>
			<div class="col l4 s12">
				<h5 class="white-text">LOCALIZAÇÃO</h5>
				<div class="mapa">
					<iframe
						src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3654.4020670091854!2d-46.53172074892907!3d-23.66157537111153!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x94ce42890ae627ef%3A0x934856e70030c41a!2sFAPEN%20-%20Faculdade%20Pent%C3%A1gono!5e0!3m2!1spt-BR!2sbr!4v1570217487451!5m2!1spt-BR!2sbr"
						width="300" height="110" frameborder="0" style="border: 0;"
						allowfullscreen=""></iframe>
				</div>
			</div>
		</div>
	</div>
	<div class="footer-copyright indigo darken-4">
		<div class="container-fluid">&copy; 2021 - Generally Sports</div>
	</div>
</footer>