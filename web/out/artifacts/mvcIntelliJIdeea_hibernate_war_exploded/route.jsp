<%--
  Created by IntelliJ IDEA.
  User: Cipri
  Date: 6/23/2018
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="js/jquery-2.0.3.js"></script>
    <script src="js/ajax-utils.js"></script>
    <script>
        $(document).ready(function () {
            var history_route=[];
            var current_route=[];

            getCities(function (response) {
               var string ="";
               console.log(response);
               for (var i = 0; i < response.split("|").length - 1; i++){
                   string += "<p>" + response.split("|")[i] + "</p>";
               }
               $("#cityContent").html(string);
            });
            $("#start ,#next").click(function () {
                var city = $("#intP").val();
                console.log(city);
                current_route.push(city);
                console.log(response);
                getLinks(city, function (response) {
                    var string ="";
                    console.log(response);
                    for (var i = 0; i < response.split(",").length; i++){
                        string += "<p>" + response.split(",")[i] + "</p>";
                    }
                    $("#mare").hide();
                    $("#routes").show();
                    $("#routeContent").html(string);
                });
            });
            $("#back").click(function () {
                history_route.push(Array.from(current_route));
                if (current_route.length === 1){
                    alert("No more cities left!!!");
                    return;}
                current_route.pop();
                console.log(current_route);
                console.log(history_route);
                getLinks(current_route[current_route.length - 1], function (response) {
                    var string ="";
                    console.log(response);
                    for (var i = 0; i < response.split("|").length - 1; i++){
                        string += "<p>" + response.split("|")[i] + "</p>";
                    }
                    $("#mare").hide();
                    $("#routes").show();
                    $("#routeContent").html(string);
                });
            });
            $("#finalD").click(function () {
                history_route.push(Array.from(current_route));
                $("#postshow").show();
                $("#routes").hide();
                $("#intP").hide();
            });
            $("#route").click(function () {
                $("#routess").html("Final destination:" + current_route);
            });
            $("#history").click(function () {
                $("#routess").html("History:" + history_route);
            });
        });
    </script>
</head>
<body>
    <div id="mare">
        <div id="cityContent"></div>
        <div id="inputs">
            <button id="start">Start</button>
        </div>
    </div>

    <div id="routes" style="display: none;">
        <div id="routeContent"></div>
        <div id="buttons">
            <button id="next">Next</button>
            <button id="finalD">Set final destination</button>
            <button id="back">Go Back</button>
        </div>
    </div>
    <input id="intP" placeholder="City...">
    <div id="postshow" style="display: none">
        <p id="routess"></p>
        <button id="route">Show Final Route</button>
        <button id="history">Show History</button>
    </div>
</body>
</html>
