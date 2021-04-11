<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>Generally Sports</title>

<!-- Materialize CSS -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"
	media="screen,projection" />

<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="/css/animate.css" />
</head>
<body>

	<div class="fixed-action-btn">
		<a class="btn-floating btn-large blue darken-1" href="#topo"> <i
			class="large material-icons">arrow_upward</i>
		</a>
	</div>
	<div id="topo"></div>
	<%@ include file="base/menu.jsp"%>
	<%@ include file="base/acessorios.jsp"%>
	<%@ include file="base/rodape.jsp"%>

	<!--Materialize JS-->
	<script src="js/jquery-3.4.1.min.js"></script>
	<script src="js/jquery.mask.min.js"></script>
	<script src="js/materialize.min.js"></script>
	<script src="js/main.js"></script>
	<script>
		setTimeout(function() {
			$('.status-message').fadeOut('slow');
		}, 5000);
	</script>

</body>
</html>