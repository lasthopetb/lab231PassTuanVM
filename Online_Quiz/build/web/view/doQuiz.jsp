

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/doQuiz.js" type="text/javascript"></script>
    </head>
    <body>
        <p class="text">
            <span>Welcome </span>
            <span class="text-blue">${account.getUser()}</span>
        </p>
        <!--timer-->
        <p class="text time_remain">
            <span>Time remaining: </span>
            <span id="timer" class="notice">
                <script>
                    setTime(${time});
                </script>
            </span>
        </p>
        <!--question-->
        <form action="doquiz" method="post" id="doquiz">
            <p class="text question">${question.getQuestion()}</p>
            <p class="text">
                <input type="checkbox" name="option" value="1">
                <span class="text">${question.getOption1()}</span>
            </p>
            <p class="text">
                <input type="checkbox" name="option" value="2">
                <span class="text">${question.getOption2()}</span>
            </p>
            <p class="text">
                <input type="checkbox" name="option" value="3">
                <span class="text">${question.getOption3()}</span>
            </p>
            <p class="text">
                <input type="checkbox" name="option" value="4">
                <span class="text">${question.getOption4()}</span>
            </p>
            <input type="hidden" id="timeup" name="timeup" value="false"/>
            <input id="nextButton" type="submit" value="Next"/>
        </form>
    </body>
</html>
