//these global variables contains information about the selected objects
var loggedInAccount = null;

$(document).ready(function() {

	assignActions()

});

function assignActions() {
	//--------Account functions-------
	//assign login action 
	$("#loginPlayerSubmit").click(function(e) {
		//prevent the default form behaviour
		e.preventDefault();
		
		var user = $("#loginPlayerUserNameTxtInput").val();
		var pwd = $("#loginPlayerPwdTxtInput").val();		
		if (user == "" || pwd == "") {
			return;
		}
		login(user, pwd);		
	});
}

function login(user, pwd) {
	var url = "/lottery/player/login";
	var request = {};
	request.userName = user;
	request.password = pwd;
	sendAjax("POST", url, JSON.stringify(request), 
	 	function(data, textStatus, xhr ) {
			
		sessionStorage.setItem('playerId', data.id);
		sessionStorage.setItem('playerUsername', data.userName);
						
		window.location.href = "/lottery/sites/games.html";
		
		},
		function(xhr) {
			$("#failedPlayerLogin").html(getErrorMsg(xhr));
		}
	);	
}