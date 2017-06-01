app.controller('loginCtrl',function($scope,mainService,Session){
	 $scope.credentials = {
			    username: '',
			    password: ''
			  };
	$scope.loginUser = function(credentials){
		$scope.userDetails = mainService.loginUser(credentials.username,credentials.password).then(function(data) {
			 $scope.users =  data.data;
			 Session.create(data.data.userName, data.data.fullName,data.data.userRole);
	    });
		console.log($scope.users);
	}
	$scope.logOut = function(credentials){
			
				 $scope.users =  null;
				 Session.destroy();
	}
});
