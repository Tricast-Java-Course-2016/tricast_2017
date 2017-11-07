$(document).ready(function() {

    loadLotteryGames();

});

function loadLotteryGames() {
    sendAjax("GET", "/lottery/lotterygames", null, function(data) {
        console.log(data);
        displayGames(data);
    }, function(xhr) {
        console.log(xhr);
    });

}

function displayGames(data) {

    for (var i = 0; i < data.length; i++) {

        $('#lotteryGamesTable-body:last-child').append(
                '<tr id="' + data[i].id + '"><td>' + data[i].description + '</td><td>' + data[i].baseStake
                        + '</td><td>' + data[i].gridSize + '</td><td>' + data[i].numbersDrawn + '</td><td>'
                        + data[i].nrOfGrids + '</td><td>' + data[i].minNrOfFix + '</td><td>' + data[i].maxNrOfFix
                        + '</td><td>' + data[i].maxNrOfCombination + '</td><td>' + data[i].createdDate + '</td></tr>');

    }
}