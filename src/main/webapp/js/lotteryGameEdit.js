$(document).ready(function() {

    lotteryGameId = document.URL.split("id=")[1];

    if (lotteryGameId === undefined || lotteryGameId === null || lotteryGameId === "null") {
        alert("Lottery Game Id is missing from the URL");
    } else {
        loadLotteryGame();
    }

    bindListeners();

});

function bindListeners() {
    $('#saveGame').click(function() {
        // e.preventDefault();
        saveGame();
    });
}

function loadLotteryGame() {
    sendAjax("GET", "/lottery/lotterygames/" + lotteryGameId, null, function(data) {
        displayGame(data);
    }, function(xhr) {
        alert(xhr);
    });

}

function displayGame(data) {

    $("#lotteryGameId").val(data.id);
    $("#lotteryGameName").val(data.description);
    $("#baseStake").val(data.baseStake);
    $("#gridSize").val(data.gridSize);
    $("#numbersDrawn").val(data.numbersDrawn);
    $("#nrOfGrids").val(data.nrOfGrids);
    $("#minNrOfFix").val(data.minNrOfFix);
    $("#maxNrOfFix").val(data.maxNrOfFix);
    $("#maxNrOfCombination").val(data.maxNrOfCombination);
    $("#createdDate").val(data.createdDate);

}

function saveGame() {
    var lotteryGame = getGameParams();

    sendAjax("PUT", "/lottery/lotterygames", JSON.stringify(lotteryGame), function(data) {
        alert("OK");
        displayGame(data);
    }, function(xhr) {
        alert(xhr);
    });
}

function getGameParams() {
    var lotteryGame = {};

    lotteryGame.id = lotteryGameId;
    lotteryGame.description = $("#lotteryGameName").val();
    lotteryGame.baseStake = $("#baseStake").val();
    lotteryGame.gridSize = $("#gridSize").val();
    lotteryGame.numbersDrawn = $("#numbersDrawn").val();
    lotteryGame.nrOfGrids = $("#nrOfGrids").val();
    lotteryGame.minNrOfFix = $("#minNrOfFix").val();
    lotteryGame.maxNrOfFix = $("#maxNrOfFix").val();
    lotteryGame.maxNrOfCombination = $("#maxNrOfCombination").val();

    return lotteryGame;
}
