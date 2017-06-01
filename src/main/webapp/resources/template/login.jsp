<div ng-controller="loginCtrl"><form name="loginForm" 
      ng-submit="loginUser(credentials)" novalidate>
  <label for="username">Username:</label>
  <input type="text" id="username"
         ng-model="credentials.username">
  <label for="password">Password:</label>
  <input type="password" id="password"
         ng-model="credentials.password">
  <button type="submit">Login</button>
</form>
{{users}}
<button ng-click="logOut()">Logout</button>
</div>