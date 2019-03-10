<%--
  Created by IntelliJ IDEA.
  User: Cipri
  Date: 7/12/2018
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-2.0.3.js"></script>
    <script src="js/ajax-utils.js"></script>
    <script>
        $(document).ready(function (){
            var count = 0;
            var stringus = "";
            $("#btnn").click(function () {
                var string = $("#str").val();
                getBiblio(string, function (response) {
                    var string ="";
                    console.log(response);
                    for (var i = 0; i < response.split("|").length - 1; i++){
                        string += "<p>" + response.split("|")[i] + "</p>";
                    }
                    $("#bcontent").html(string);
                })
            });
            $("#del").click(function () {
                var cat = $("#cat").val();
                delCat(cat, function (response) {
                    
                })
            });
            $("#ad").click(function () {
                var idcat = $("#idcat").val();
                var aut = $("#aut").val();
                var tit = $("#tit").val();
                var nrpag = $("#nrpag").val();
                var year = $("#year").val();
                var cost= $("#cost").val();
                if (count === 3)
                    alert("No more adds possible!");
                else{
                    stringus += idcat+"-"+aut+"-"+tit+"-"+nrpag+"-"+year+"-"+cost+"=";
                    count++;
                }
                console.log(stringus);
            });
            $("#fin").click(function () {
                addBib(stringus, function (response) {

                })
            });
            $("#sho").click(function () {
                showP(function (response) {
                    
                })
            });
        });
    </script>

</head>
<body>
    <div id="int">
        <input id="str" placeholder="Give String">
        <button id="btnn">Check</button>
        <button id="sho">Show Pages</button>
        <input id="cat" placeholder="Category Name">
        <button id="del">Delete</button>
    </div>

    <div id="add">
        <input id="idcat" placeholder="id Cat">
        <input id="aut" placeholder="Author">
        <input id="tit" placeholder="Title">
        <input id="nrpag" placeholder="Nr of pages">
        <input id="year" placeholder="Year">
        <input id="cost" placeholder="Cost">
        <button id="ad">Add</button>
        <button id="fin" >Add Final</button>
    </div>
    <div id="bcontent"></div>
    <div id="content" style="display: none">
        <div id="cont"></div>
        <button id="next">Next</button>
    </div>




</body>
</html>
