<%--
  Created by IntelliJ IDEA.
  User: Cipri
  Date: 5/29/2018
  Time: 6:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>lil snek</title>

    <script src="js/jquery-2.0.3.js"></script>
    <script src="js/ajax-utils.js"></script>
    <script>
        $(document).ready(function(){
            $("td").click(function () {
                var color = $( this ).css( "background-color" );
                var y = this.cellIndex;
                var x = this.parentNode.rowIndex;
                var str = "#td" + x + y;
                console.log(color);

                position(x, y, function (response) {
                    console.log(typeof response);
                    console.log(response);
                    console.log(typeof 100);
                    if (!isNaN(response)) {
                        if (response > 90) {
                            console.log("ma-ta1");
                            $("#div1").hide();
                            $("#div2").show();
                            del();
                        }
                        else {
                            console.log("ma-ta");
                            alert("You cannot go on diagonals or more than one cell at the time.");
                        }
                    }
                    else {
                        if (color === 'rgb(0, 0, 0)')
                        {
                            $("#div1").hide();
                            $("#div2").show();
                            del();
                        }
                        else {
                            $(str).html("X");
                            $(response).html("==");
                        }
                    }
                });
            });
        });
    </script>
    <style>
        #div2{
            display:none;
            margin-left: 300px;
        }
    </style>
</head>
<body>
    <div id="div1">
        <p> HELLO THERE!!! Welcome to the best snake ever made...</p>
        <table border="8">
            <tr >
                <td id="td00" style="width: 50px;height: 50px;background: black"></td>
                <td id="td01" style="width: 50px;height: 50px;background: black"></td>
                <td id="td02" style="width: 50px;height: 50px;background: black"></td>
                <td id="td03" style="width: 50px;height: 50px;background: black"></td>
                <td id="td04" style="width: 50px;height: 50px;background: black"></td>
                <td id="td05" style="width: 50px;height: 50px;background: black"></td>
                <td id="td06" style="width: 50px;height: 50px;background: black"></td>
            </tr>
            <tr >
                <td id="td10" style="width: 50px;height: 50px;background: white">X</td>
                <td id="td11" style="width: 50px;height: 50px;background: white"></td>
                <td id="td12" style="width: 50px;height: 50px;background: white"></td>
                <td id="td13" style="width: 50px;height: 50px;background: white"></td>
                <td id="td14" style="width: 50px;height: 50px;background: black"></td>
                <td id="td15" style="width: 50px;height: 50px;background: white"></td>
                <td id="td16" style="width: 50px;height: 50px;background: black"></td>
            </tr>
            <tr>
                <td id="td20" style="width: 50px;height: 50px;background: black"></td>
                <td id="td21" style="width: 50px;height: 50px;background: white"></td>
                <td id="td22" style="width: 50px;height: 50px;background: white"></td>
                <td id="td23" style="width: 50px;height: 50px;background: black"></td>
                <td id="td24" style="width: 50px;height: 50px;background: white"></td>
                <td id="td25" style="width: 50px;height: 50px;background: white"></td>
                <td id="td26" style="width: 50px;height: 50px;background: black"></td>
            </tr>
            <tr>
                <td id="td30" style="width: 50px;height: 50px;background: black"></td>
                <td id="td31" style="width: 50px;height: 50px;background: black"></td>
                <td id="td32" style="width: 50px;height: 50px;background: white"></td>
                <td id="td33" style="width: 50px;height: 50px;background: black"></td>
                <td id="td34" style="width: 50px;height: 50px;background: white"></td>
                <td id="td35" style="width: 50px;height: 50px;background: white"></td>
                <td id="td36" style="width: 50px;height: 50px;background: black"></td>
            </tr>
            <tr>
                <td id="td40" style="width: 50px;height: 50px;background: black"></td>
                <td id="td41" style="width: 50px;height: 50px;background: black"></td>
                <td id="td42" style="width: 50px;height: 50px;background: white"></td>
                <td id="td43" style="width: 50px;height: 50px;background: white"></td>
                <td id="td44" style="width: 50px;height: 50px;background: white"></td>
                <td id="td45" style="width: 50px;height: 50px;background: black"></td>
                <td id="td46" style="width: 50px;height: 50px;background: black"></td>
            </tr>
            <tr>
                <td id="td50" style="width: 50px;height: 50px;background: black"></td>
                <td id="td51" style="width: 50px;height: 50px;background: white"></td>
                <td id="td52" style="width: 50px;height: 50px;background: white"></td>
                <td id="td53" style="width: 50px;height: 50px;background: black"></td>
                <td id="td54" style="width: 50px;height: 50px;background: white"></td>
                <td id="td55" style="width: 50px;height: 50px;background: white"></td>
                <td id="td56" style="width: 50px;height: 50px;background: black"></td>
            </tr>
            <tr>
                <td id="td60" style="width: 50px;height: 50px;background: black"></td>
                <td id="td61" style="width: 50px;height: 50px;background: black"></td>
                <td id="td62" style="width: 50px;height: 50px;background: black"></td>
                <td id="td63" style="width: 50px;height: 50px;background: black"></td>
                <td id="td64" style="width: 50px;height: 50px;background: black"></td>
                <td id="td65" style="width: 50px;height: 50px;background: black"></td>
                <td id="td66" style="width: 50px;height: 50px;background: black"></td>
            </tr>
        </table>
    </div>
    <div id="div2">
        <h1>Sorry bro, but the game is over.</h1>
        <video id="videoid" width="400px" height="400px" controls>
            <source src="generalekenobi.mp4" type="video/mp4" style="width: 400px;height: 400px;">
        </video>
    </div>
</body>
</html>
