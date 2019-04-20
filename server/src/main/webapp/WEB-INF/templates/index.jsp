<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<title>Random Quotes</title>
<style>
<!--
-->
.quote-card {
	margin-top: 20%;
	box-shadow: 5px 5px 25px rgba(0, 123, 255, .25)
}
</style>
</head>
<body data-ng-app="RandomQuotes">
	<div class="container">
		<div class="row">
			<div class="col"></div>
			<div class="col-6">
				<div class="card quote-card"
					data-ng-controller="RandomQuoteController">
					<div class="card-header">
						<strong>Random Quote Machine</strong> <a class="float-right" href="#" data-ng-click="refresh()"> <i class="fa fa-sync"></i>
						</a>
					</div>
					<div class="card-body">
						<h5 class="card-title">Today's Quote</h5>
						<h6 class="card-subtitle mb-2 text-muted"
							data-ng-bind="quote.author"></h6>
						<p class="card-text" data-ng-bind="quote.quote"></p>
					</div>
				</div>
			</div>
			<div class="col"></div>
		</div>
	</div>

	<script type="text/javascript">
		var baseURL = 'http://localhost:3000/rq/'
	</script>
	
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.5/angular.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/js/app.js"></script>
</body>
</html>