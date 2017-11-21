$(document).ready(function() {

    betId = document.URL.split("id=")[1];

    if (betId === undefined || betId === null || betId === "null") {
        alert("Lottery Game Id is missing from the URL");
    } else {
        loadBet();
    }

});

function loadBet() {
    sendAjax("GET", "/lottery/lotteryticket/bet/" + betId, null, function(data) {
        console.log(data);
        displayBetField(data);
    }, function(xhr) {
        console.log(xhr);
    });

}

function displayBetField(data) {

    $('#description').append(data.description);
    $('#gameWeek').append(data.week + '. Week');
    $('#lotteryDrawId').val(data.lotteryDrawId);

    for (var i = 0; i < data.nrOfGrids; i++) {

        $('#betField').append('<div class="grid" id="grid-' + i + '"> <h3>' + (i + 1) + '. grid</h3></br>');

        for (var j = 0; j < data.numbersDrawn; j++) {
            $('#grid-' + i).append(
                    '<input type="number" min="1" max="' + data.gridSize + '" class="bet-number input-lg">');
        }

    }
}

function bindListeners() {
    $('#saveBet').click(function() {
        // e.preventDefault();
        saveBet();
    });
}

function saveBet() {
    var betInfos = getBetInfos();

    sendAjax("POST", "/lottery/lotteryticket/placebet", JSON.stringify(betInfos), function(data) {
        alert("Your bet saved");
        displayBetField(data);
    }, function(xhr) {
        alert(xhr);
    });
}

function getBetInfos() {
    var betInfos = {};

    betInfos.lotteryDrawId = $("#lotteryDrawId").val();
    // betInfos.playerId = $("#lotteryDrawId").val(); ???
    betInfos.fixNumbers = fixNumbers();
    betInfos.combinationNumbers = combinationNumbers();
    betInfos.oneWeek = oneWeek();  // lehet, hogy lehet egyszerubben...
    

    return betInfos;
}



oneWeek(){
    if($('#oneWeek').isSelected()){
        return true;
    } else {
        return false;
    }
    }
}

fixNumbers(){
  
    
}

combinationNumbers(){
    
}
