var app=angular.module('myApp', ['ngRoute']);
app.config(['$routeProvider', function ($routeProvider) { 
	$routeProvider.when('/',{
		templateUrl : "resources/template/product.jsp",
		cotroller:"productCtrl"
	}).when('/categories',{
		templateUrl : "resources/template/categories.jsp",
		cotroller:"productCtrl"
	}).when('/checkout',{
		templateUrl : "resources/template/checkout.jsp",
		cotroller:"productCtrl"
	}).when('/login',{
		templateUrl : "resources/template/login.jsp",
		cotroller:"loginCtrl"
	});
}]);
	
app.constant('AUTH_EVENTS', {
	  loginSuccess: 'auth-login-success',
	  loginFailed: 'auth-login-failed',
	  logoutSuccess: 'auth-logout-success',
	  sessionTimeout: 'auth-session-timeout',
	  notAuthenticated: 'auth-not-authenticated',
	  notAuthorized: 'auth-not-authorized'
});
app.constant('USER_ROLES', {
	  all: '*',
	  admin: 'admin',
	  editor: 'editor',
	  guest: 'guest'
});
