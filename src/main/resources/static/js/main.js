$(document).ready(function() {
	M.updateTextFields();
	$('.sidenav').sidenav();
	$(".dropdown-trigger").dropdown({
		container: document.body
	});	
	$('.collapsible').collapsible(); 
	$('ul.tabs').tabs();
	$('select').formSelect();
	$('.modal').modal();
	
	// Tradução datapicker
	// Fonte: https://gist.github.com/lramosduarte/d74f9ad0ad62d109a85fc58ce8985165
	// Documentação: https://materializecss.com/pickers.html
	$('.datepicker').datepicker(
			{
				i18n : {
					cancel : "Cancelar",
					clear : "Limpar",
					labelMonthNext : 'Próximo mês',
					labelMonthPrev : 'Mês anterior',
					labelMonthSelect : 'Selecione um mês',
					labelYearSelect : 'Selecione um ano',
					months : [ 'Janeiro', 'Fevereiro', 'Março',
							'Abril', 'Maio', 'Junho', 'Julho',
							'Agosto', 'Setembro', 'Outubro',
							'Novembro', 'Dezembro' ],
					monthsShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai',
							'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov',
							'Dez' ],
					weekdays : [ 'Domingo', 'Segunda', 'Terça',
							'Quarta', 'Quinta', 'Sexta', 'Sabádo' ],
					weekdaysShort : [ 'Dom', 'Seg', 'Ter', 'Qua',
							'Qui', 'Sex', 'Sab' ],
					weekdaysAbbrev : [ 'D', 'S', 'T', 'Q', 'Q', 'S',
							'S' ],
				},

				format : "dd/mm/yyyy"
			});
});

//mascaras para dados e inputs
$(".fmt-cnpj").mask("00.000.000/0000-00");
$(".fmt-cpf").mask("000.000.000-00");
$(".fmt-cep").mask("00000-000");
$(".fmt-tel").mask("(00)0000-0000");
$(".fmt-cel").mask("(00)00000-0000");
$(".datepicker").mask("00/00/0000");

$(".linkFotosHome1").hover(function() {
	$(".linkFotosHome1 span").css("display", "block")
},function() {
	$(".linkFotosHome1 span").css("display", "none")
});

$(".linkFotosHome2").hover(function() {
	$(".linkFotosHome2 span").css("display", "block")
},function() {
	$(".linkFotosHome2 span").css("display", "none")
});

$(".linkFotosHome3").hover(function() {
	$(".linkFotosHome3 span").css("display", "block")
},function() {
	$(".linkFotosHome3 span").css("display", "none")
});

$(".linkFotosHome4").hover(function() {
	$(".linkFotosHome4 span").css("display", "block")
},function() {
	$(".linkFotosHome4 span").css("display", "none")
});
//Configuração dropdown menu
$('.dropdown-button').dropdown({
    container: document.body
  }); 
