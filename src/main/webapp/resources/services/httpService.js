app.factory('mainService', function ($http) {	
	var fac={};
	fac.getData= function() {		
		return $http({
		        method : "GET",
		        url : "productList",
		});	    
	};	
	fac.loginUser= function(userName,userPwd) {		
		return $http({
		        method : "GET",
		        url : "loginUser",
		        params : {userPassword:userPwd,userName:userName}
		});	    
	};	
	return fac;
});
