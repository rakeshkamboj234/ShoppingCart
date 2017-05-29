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
	});
}]);
app.factory('mainService', function ($http) {	
	var fac={};
	fac.getData= function() {		
		return $http({
		        method : "GET",
		        url : "productList",
		});	    
	};	
	return fac;
});	
app.controller('productCtrl',function($scope,$http,mainService){
	
	$scope.productList = function(){
		$scope.products = mainService.getData().then(function(data) {
			 $scope.products =  data.data.listItem;
	    });
		console.log($scope.products);
	}
	
});