app.service('Session', function () {
	  this.create = function (sessionId, userId, userRole, fullName) {
		    this.id = sessionId;
		    this.userId = userId;
		    this.fullName = fullName;
		    this.userRole = userRole;
		  };
		  this.destroy = function () {
		    this.id = null;
		    this.userId = null;
		    this.userRole = null;
		    this.fullName = null;
		  };
});