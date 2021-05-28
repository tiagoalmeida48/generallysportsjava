<!--Fale Conosco-->
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<div class="fale-conosco" id="fale-conosco">
	<div class="container center">
		<h4 class="card-title">Fale Conosco</h4>
		<br>
		<br>
		<div class="row">
			<div class="col s6 formulario">
				<f:form class="col s12" method="POST"
					action="${s:mvcUrl('contatoViaSite').build() }"
					modelAttribute="contatoSiteForm">
					<div class="row">

						<div class="input-field col s12">
							<input id="nome" name="nome" type="text" class="validate">
							<label for="nome">Nome</label>
						</div>

						<div class="input-field col s12">
							<input id="email" name="email" type="text" class="validate">
							<label for="email">E-mail</label>
						</div>

						<div class="input-field col s12">
							<input id="assunto" name="assunto" type="text" class="validate">
							<label for="assunto">Assunto</label>
						</div>


						<div class="input-field col s12">
							<textarea id="mensagem" name="mensagem"
								class="materialize-textarea"></textarea>
							<label for="mensagem">Mensagem</label>
						</div>


						<div class="input-field col s12">
							<input type="submit" value="Enviar" class="left btn botao">
						</div>
					</div>
				</f:form>
			</div>

			<div class="col s6">
				<h2>Obrigado !!!</h2>

				<h4>Sua visita em nosso site é muito importante para a
					Generally Sports.</h4>
			</div>
		</div>
	</div>
</div>