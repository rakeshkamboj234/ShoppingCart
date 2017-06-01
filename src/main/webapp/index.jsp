<html>
<head>
<script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
<link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet" type="text/css" />
<script src="resources/js/main.js"></script>
<script src="resources/services/sessionService.js"></script>
<script src="resources/services/httpService.js"></script>
<script src="resources/js/productController.js"></script>
<script src="resources/js/loginController.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
</head>
	<body ng-app="myApp">
		<h1 class="well">
			<a href="#/">Product</a>&nbsp&nbsp&nbsp&nbsp
			<a href="#categories">Categories</a>&nbsp&nbsp&nbsp&nbsp
			<a href="#checkout">Checkout</a>
			<a href="#login">Login</a>
			
			<p>Welcome to Shopping Cart.</p>
		</h1>
		<div ng-view></div>
	</body>
</html>