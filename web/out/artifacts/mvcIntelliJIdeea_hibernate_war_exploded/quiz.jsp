<%--
  Created by IntelliJ IDEA.
  User: Cipri
  Date: 6/23/2018
  Time: 5:27 PM
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
            var pages = [];
            var nrquestions;
            var current = 0;
            var nrpage ;

            $("#start").click(function () {
                nrpage = $("#nrp").val();
                var nrqu = $("#nrq").val();
                console.log(nrqu+ " "+nrpage);
                getQuestions(nrqu, function (response) {
                    var string ="";
                    nrquestions = response.split("|").length - 1;
                    for (var i =0 ;i <response.split("|").length - 1;i++){
                        string += "<p>" + response.split("|")[i] + "</p>";
                        string += "<input id='in"+ i +"' placeholder='Answer...'>";
                        if ((i%(nrpage - 1)) === 0 && i>0) {
                            pages.push(string);
                            string = "";
                        }
                    }
                    pages.push(string);
                    console.log(pages);
                    $("#inceput").hide();
                    $("#main").show();
                    $("#content").html(pages[current]);
                });
            });

            $("#prev").click(function () {
                if (current - 1 < 0)
                    alert("cannot go!");
                else {
                    $("#content").html(pages[current - 1]);
                    current -= 1;
                }
            });
            $("#next").click(function () {
                if (current + 1 > pages.length)
                    alert("cannot go!");
                else {
                    $("#content").html(pages[current + 1]);
                    current += 1;
                }
            });
            $("#submit").click(function () {
                var string ="";
                for (var i =0; i< nrquestions ; i++){
                    var ans = $("#in"+i).val();
                    if (ans === "")
                        string += "." +" ";
                    else
                        string += ans +" ";
                }
                results(string, function (response) {
                    $("#results").html(response);
                })
            })
        });
    </script>
</head>
<body>
    <div id="inceput">
        <input id="nrq" placeholder="Input nr of questions">
        <input id="nrp" placeholder="Input nr of questions/page">
        <button id="start">Start</button>
    </div>

    <div id="main" style="display: none">
        <div id="content"></div>
        <button id="prev">Prev</button>
        <button id="next">Next</button>
        <button id="submit">Submit</button>
        <p id="results"></p>
    </div>


</body>
</html>
