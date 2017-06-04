app.controller('loginCtrl',function($scope,$rootScope,mainService,Session){

	$scope.loginUser = function(credentials){
	    mainService.loginUser(credentials.username,credentials.password).then(function(data) {
	    	$rootScope.users =  data.data;
			 Session.create(data.data.userName, data.data.fullName,data.data.userRole);
	    });
		console.log($scope.users);
	}
	$scope.logOut = function(credentials){
			
		$rootScope.users =  {};
				 Session.destroy();
	}
});
