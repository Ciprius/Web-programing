function getBiblio(string,callbackFunction) {
    $.get("BibliographyController",
        {
            action:"getB",
            string:string
        }
        ,callbackFunction)
}
function delCat(cat,callbackFunction) {
    $.get("BibliographyController",
        {
            action:"del",
            category:cat
        }
        ,callbackFunction)
}
function addBib(stringus,callbackFunction) {
    $.get("BibliographyController",
        {
            action:"addbib",
            add:stringus
        }
        ,callbackFunction)
}
function showP(callbackFunction) {
    $.get("BibliographyController",
        {
            action:"show"
        }
        ,callbackFunction)
}
































function position(X, Y, callbackFunction) {
    $.get("PositionController",
        {
            action:"pos",
            X:X,
            Y:Y
        },
        callbackFunction
    );
}

function del() {
    $.get("PositionController",
        {
            action:"delete"
        });
}

function getTests(callbackFunction) {
    $.get("TestController",
        {action: "gettests"},
        callbackFunction
    );
}

function getGame(id,callbackFunction) {
    $.get("TestController",
        {
            action:"getgame",
            id:id
        },
        callbackFunction
    );
}

function getPoints(callbackFunction) {
    $.get("TestController",
        {action:"getpoints"},
        callbackFunction
        );
}
function getGames(callbackFunction) {
    $.get("TestController",
        {action:"getgames"},
        callbackFunction
    );
}
function checkAns(name,callbackFunction) {
    $.get("TestController",
        {
            action:"checkans",
            name:name
        },
        callbackFunction
    );
}
function getCities(callbackFunction){
    $.get("RouteController",{action:"getCities"},callbackFunction);
}
function getLinks(city,callbackFunction) {
    $.get("RouteController",
        {
            action:"getLinks",
            city:city
        },
        callbackFunction);
}
function getQuestions(nr,callbackFunction) {
    $.get("QuizController",
        {
            action:"getQuestions",
            nr:nr
        }
        ,callbackFunction);
}
function results(string,callbackFunction) {
    $.get("QuizController",
        {
            action:"results",
            string:string
        }
        ,callbackFunction)
}