$(document).ready(function() {

    lotteryDrawId = document.URL.split("id=")[1];

    if (lotteryDrawId === undefined || lotteryDrawId === null || lotteryDrawId === "null") {
        alert("LotteryDraw Id is missing from the URL");
    } else {
        loadLotteryDraw();
    }
    bindListeners();
});

function loadLotteryDraw() {
    sendAjax("GET", "/lottery/lotterydraw/detailsForEditDraw/" + lotteryDrawId, null, function(data) {
        console.log(data);
        displayDraw(data);
    }, function(xhr) {
        console.log(xhr);
    });

}
function saveDrawEdit() {
    var drawInfos = getDrawInfos();

    sendAjax("PUT", "/lottery/lotterydraw", JSON.stringify(drawInfos), function(data) {
        alert("Your draw saved");
        displayDraw(data);
    }, function(xhr) {
        alert(xhr);
    });
}

function getDrawInfos() {
    var draw = {};
    draw.winningNumbers = "";
    draw.winningPercentage = "";
    draw.lotteryDrawId = lotteryDrawId;
    $(".winningNumber").each(function() {
        if (draw.winningNumbers.length == 0) {
            draw.winningNumbers = draw.winningNumbers + (this.value);
        } else {
            draw.winningNumbers = draw.winningNumbers + "," + (this.value);
        }
        console.log(this.value);
    });
    console.log(draw.winningNumbers);
    $(".winningPercentage").each(function() {
        if (draw.winningPercentage.length == 0) {
            draw.winningPercentage = draw.winningPercentage + (this.value);
        } else {
            draw.winningPercentage = draw.winningPercentage + "," + (this.value);
        }
        console.log(this.value);
    });
    console.log(draw.winningPercentage);

    return draw;
}

function bindListeners() {
    $('#edit').click(function() {
        // e.preventDefault();
        saveDrawEdit();
    });
}

function displayDraw(data) {

    $('#winningAmountlabel').html(data.winningAmount);
    for (var i = 0; i < data.numbersDrawn; i++) {

        $('#winningNumbers-td:last-child').append(
                '<td><input type="number" name="winningNumber" min="1" max="90" class="winningNumber"></td>');
        $('#winnngPercentages-td:last-child').append(
                '<td><input type="number" name="winningPercentage" min="0" max="90" class="winningPercentage"></td>');
    }
}