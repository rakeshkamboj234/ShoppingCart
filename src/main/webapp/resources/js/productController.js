app.controller('productCtrl',function($scope,mainService){
	
	$scope.productList = function(){
		$scope.products = mainService.getData().then(function(data) {
			 $scope.products =  data.data.listItem;
	    });
		console.log($scope.products);
	}
	
});