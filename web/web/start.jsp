<%--
  Created by IntelliJ IDEA.
  User: Cipri
  Date: 5/30/2018
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="js/jquery-2.0.3.js"></script>
    <script src="js/ajax-utils.js"></script>
    <style>
        form{
            margin-top: 100px;
            margin-left: 300px;
            width: 400px;
        }
    </style>
    <script>
        $(document).ready(function () {
            var number;
            $("#show").click(function () {
                getTests(function (response) {
                    console.log(response);
                    $("#content").html(response);
                });
            });
            $("#Start").click(function () {
                var lemn = $("#games").val();
                console.log(lemn);
                getGame(lemn, function (response) {
                    var string ="<div>";
                    console.log(response.split("|")[0]);
                    number = response.split("|").length - 1;
                    for (var i=0 ; i< response.split("|").length - 1;i++)
                    {
                        string += "<p>"+response.split("|")[i] + "</p>";
                        string += "<input id='in"+i+"' placeholder=Answer>";
                    }
                    string +="</div>";
                    $("#gamecontent").html(string);
                    $("#game").show();
                    $("#init").hide();
                });
            });
            $("#givePoints").click(function () {
                getPoints(function (response) {
                    var sum = 0;
                    for (var i =0 ; i <response.split(" ").length - 1; i++){
                        sum +=  Number(response.split(" ")[i]);
                    }
                    $("#da").html("Total points so far:" +sum);
                });
            });
            $("#showgames").click(function () {
                getGames(function (response) {
                    $("#da").html("You played the following games:" + response);
                })
            });
            $("#back").click(function () {
                $("#game").hide();
                $("#init").show();
            });
            $("#finish").click(function () {
                var string = "";
                for (var i =0 ;i< number ; i++){
                    string += $("#in"+i).val() + " ";
                }
                checkAns(string ,function (response) {
                    if (Number(response) === 0)
                        alert("Not god boss");
                    else{
                        alert("GOOOOOOOOOOOOOOOOOOOOOOOOOOOD !!!");
                        $("#game").hide();
                        $("#init").show();
                    }
                });
            });
        });
    </script>

</head>
<body>
    <div>
        <div id="init">
            <button id="show">Show</button>
            <div id="content"></div>
            <input type="text" id="games" placeholder="Give the id of the Game...">
            <button id="Start">Start</button>
        </div>

        <div id="game" style="display: none">
            <div id="gamecontent"></div>
            <button id="finish">Finish</button>
            <button id="back">Back</button>
        </div>
        <button id="givePoints">Show Points</button>
        <button id="showgames">Show Games</button>
        <p id="da"></p>
    </div>
</body>
</html>
