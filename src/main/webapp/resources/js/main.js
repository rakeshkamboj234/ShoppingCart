var app=angular.module('myApp', ['ngRoute','ngCookies']);
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
app.run(function($rootScope,$location) {
	$rootScope.users =  {};
	 $rootScope.$on('$locationChangeStart', function (event, next, current) {
         if ($location.path() !== '/login' && !$rootScope.globals.currentUser) {
             $location.path('/login');
         }
     });
});






