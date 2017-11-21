//these global variables contains information about the selected objects
var loggedInAccount = null;

$(document).ready(function() {

	assignActions()

});

function assignActions() {
	//--------Account functions-------
	//assign login action 
	$("#loginOperatorSubmit").click(function(e) {
		//prevent the default form behaviour
		e.preventDefault();
		
		var user = $("#loginOperatorUserNameTxtInput").val();
		var pwd = $("#loginOperatorPwdTxtInput").val();		
		if (user == "" || pwd == "") {
			return;
		}
		login(user, pwd);		
	});
}

function login(user, pwd) {
	var url = "/lottery/operator/login";
	var request = {};
	request.userName = user;
	request.password = pwd;
	sendAjax("POST", url, JSON.stringify(request), 
	 	function(data, textStatus, xhr ) {
			
		sessionStorage.setItem('operatorId', data.id);
		sessionStorage.setItem('operatorUsername', data.userName);
		sessionStorage.setItem('operatorPermissions', data.permissionIds);
			
		window.location.href = "/lottery/sites/lotteryGames.html";
		
		},
		function(xhr) {
			$("#failedOperatorLogin").html(getErrorMsg(xhr));
		}
	);	
}