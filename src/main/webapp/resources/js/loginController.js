app.controller('loginCtrl',function($scope,mainService){
	 $scope.credentials = {
			    username: '',
			    password: ''
			  };
	$scope.loginUser = function(credentials){
		$scope.userDetails = mainService.loginUser(credentials.username,credentials.password).then(function(data) {
			 $scope.users =  data.data.User;
	    });
		console.log($scope.users);
	}	
});
