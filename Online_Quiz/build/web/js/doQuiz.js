function setTime(time) {
//  count down timer
    time += 10000;
    var timer = setInterval(function () {
        time -= 1000;
        if (time < 0)
            time = 0;
        var minutes = Math.floor(time / (1000 * 60));
        var seconds = Math.floor((time - minutes * 60 * 1000) / 1000);
        if (seconds < 10) {
            seconds = "0" + seconds;
        }
        document.getElementById("timer").innerHTML = minutes + ":" + seconds;
        // If the count down is over, submit quiz
        if (time === 0) {
            document.getElementById("timeup").value = "true";
            clearInterval(timer);
            document.getElementById("doquiz").submit();
        }
    }, 1000);
}


