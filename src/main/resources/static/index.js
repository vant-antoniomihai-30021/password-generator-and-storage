var clearBtn = document.getElementById("clear");
var mediaScreen = window.matchMedia("(max-width:890px)");
var mScreen = window.matchMedia("(max-width:801px)");
var m700Screen = window.matchMedia("(max-width:700px)");
var m616Screen = window.matchMedia("(max-width:616px)");
var m852Screen = window.matchMedia("(max-width:852px)");

var change = window.setInterval(function () {
    if (m852Screen.matches) {
        document.getElementById("pwToAdd").innerHTML = "(Has to be > 8)";
    }
    else document.getElementById("pwToAdd").innerHTML = "(Has to be greater than 8)";
}, 500);


clearBtn.onclick = function clear() {
    document.getElementById("response").innerHTML = "";
    var clearTag = document.getElementById("clearTag");
    clearTag.style.color = "rgb(196, 255, 240)";
    if (mediaScreen.matches != true) {
        clearTag.style.transition = "all 1s";
        clearTag.style.fontSize = "20px";
    }
    else
        clearTag.style.transition = "color 1s";
    setTimeout(function () {
        clearTag.style.fontSize = "1em";
        clearTag.style.color = "white";
    }, 1000);
}
var copy;
window.onload = function () {
    fetch("http://localhost:8080/api/v1/passwords" + "/check-if-empty").then((data) => data.json()).then((data) => {
        if (data === true) {
            var tag = document.createElement("p");
            tag.innerHTML = "There are no passwords in the database.";
            document.getElementById("response").appendChild(tag);
        }
        else
            {httpGet("http://localhost:8080/api/v1/passwords", 0);
            fetch("http://localhost:8080/api/v1/passwords").then((data) => data.json()).then((data) => {
               copy = data;
            })

    }
    })
};

var dateCopy;
function httpGet(url, cal) {

    if (cal == 1) {
        var getAllTag = document.getElementById("getAllTag");
        getAllTag.style.color = "rgb(196, 255, 240)";
        if (mediaScreen.matches != true) {
            getAllTag.style.transition = "all 1s";
            getAllTag.style.fontSize = "20px";
        }
        else
            getAllTag.style.transition = "color 1s";
        setTimeout(function () {
            getAllTag.style.fontSize = "1em";
            getAllTag.style.color = "white";
        }, 1000);
    }
    document.getElementById("response").innerHTML = "";
    fetch(url + "/check-if-empty").then((data) => data.json()).then((data) => {
        if (data === true) {
            var tag = document.createElement("p");
            tag.innerHTML = "There are no passwords in the database.";
            document.getElementById("response").appendChild(tag);
        }
    })
    fetch(url).then((response) => response.json()).then((date) => {
        isTrue = true;
        dateCopy = date;
        for (var i = 0; i < date.length; i++) {
            var tag = document.createElement("p"); //
            //tag.setAttribute("type", "password"); //
            //tag.disabled = true; //
            //tag.style.fontSize = "15px"; 
            var div = document.createElement("div");
            var response = document.getElementById("response");
            var copyBtn = document.createElement("button");
            response.appendChild(div);
            div.classList.add("mini-container");
            copyBtn.setAttribute("id", "copyBtn");
            copyBtn.innerHTML = "Copy";
            copyBtn.classList.add("copyBtn" + i);
            var text = date[i].password;
            tag.innerHTML = text;
            //tag.value = text; 
            tag.classList.add("tagPw");
            var ind = document.createElement("p"); ind.style.display = "inline"; tag.style.display = "inline";
            ind.innerHTML = "Password with the number " + (date[i].indOfThisPassword) + " is: ";
            ind.setAttribute("id","some-ind");
            if (mScreen.matches)
                ind.innerHTML = "Pw with the number " + (date[i].indOfThisPassword) + " is: ";

            if (m700Screen.matches == true)
                ind.innerHTML = "Pw number " + (date[i].indOfThisPassword) + " is: ";

            if (m616Screen.matches == true)
                ind.innerHTML = "Pw " + (date[i].indOfThisPassword) + " is: ";
           
            tag.style.color = "rgb(152, 256, 255)";
            div.appendChild(ind);
            div.appendChild(tag);
            div.appendChild(copyBtn);
        }
        for (var j = 0; j < dateCopy.length; j++) {
            var btn = document.querySelector(".copyBtn" + j);
            btn.onclick = function (v) {
                navigator.clipboard.writeText(v.path[1].querySelector(".tagPw").innerHTML);
                v.path[0].style.borderColor = "purple";
                v.path[0].style.transition = "2s all ease";
                let isPurple = true;
                setTimeout(function () {
                    v.path[0].style.borderColor = "white";
                    v.path[0].onmouseover = function (e) {
                        v.path[0].style.borderColor = "rgb(146, 255, 240)";
                        v.path[0].style.transition = "all 0.3s";
                    }
                    v.path[0].onmouseleave = function () {
                        if (!isPurple) {
                            v.path[0].style.borderColor = "white";
                            isPurple = false;
                        }
                        if (v.path[0].style.borderColor == "rgb(146, 255, 240)" && v.path[0].style.borderColor != "purple") {
                            v.path[0].style.borderColor = "white";
                        }
                    }
                }, 1000);


            }
        }

    }
    );
}

    // TO WORK ON THIS TOMORROW
    // window.setInterval(function(){
    //     var someInd = document.getElementById("some-ind");
        
    //     for (var i = 0; i < copy.length; i++) {
    //     if (mScreen.matches)
    //     someInd.innerHTML = "Pw with the number " + (copy[i].indOfThisPassword) + " is: ";
    
    // if (m700Screen.matches == true)
    // someInd.innerHTML = "Pw number " + (copy[i].indOfThisPassword) + " is: ";
    
    // if (m616Screen.matches == true)
    // someInd.innerHTML = "Pw " + (copy[i].indOfThisPassword) + " is: ";}
    // },500)


function httpPut(url) {
    var pTag = document.getElementById("getTag");
    pTag.style.color = "rgb(196, 255, 240)";
    if (mediaScreen.matches != true) {
        pTag.style.transition = "all 1s";
        pTag.style.fontSize = "20px";
    }
    else
        pTag.style.transition = "color 1s";
    setTimeout(function () {
        pTag.style.fontSize = "1em";
        pTag.style.color = "white";
    }, 1000);
    var xml = new XMLHttpRequest();
    xml.open("Put", url, false);
    xml.send(null);
    httpGet('http://localhost:8080/api/v1/passwords', 0);
    return xml.responseText;
}

function httpDelete(url) {
    var id = document.getElementById("passwordId");
    var deleteTag = document.getElementById("deleteTag");
    if (id.value == " " || id.value == "") {
        deleteTag.style.color = "red";
        if (mediaScreen.matches != true) {
            deleteTag.style.transition = "all 1s";
            deleteTag.style.fontSize = "20px";
        }
        else
            deleteTag.style.transition = "color 1s";
        setTimeout(function () {
            deleteTag.style.fontSize = "1em";
            deleteTag.style.color = "white";
        }, 1000);
    }
    else {
        fetch("http://localhost:8080/api/v1/passwords/exists" + id.value).then((data) => data.json()).then((data) => {
            if (data === true) {
                deleteTag.style.color = "rgb(196, 255, 240)";
                if (mediaScreen.matches != true) {
                    deleteTag.style.transition = "all 1s";
                    deleteTag.style.fontSize = "20px";
                }
                else
                    deleteTag.style.transition = "color 1s";
                setTimeout(function () {
                    deleteTag.style.fontSize = "1em";
                    deleteTag.style.color = "white";
                }, 1000);
                var xml = new XMLHttpRequest();
                xml.open("Delete", url + id.value, false);
                xml.send(null);
                httpGet('http://localhost:8080/api/v1/passwords', 0);
            }
            else {
                deleteTag.style.color = "red";
                if (mediaScreen.matches != true) {
                    deleteTag.style.transition = "all 1s";
                    deleteTag.style.fontSize = "20px";
                }
                else
                    deleteTag.style.transition = "color 1s";
                setTimeout(function () {
                    deleteTag.style.fontSize = "1em";
                    deleteTag.style.color = "white";
                }, 1000);
            }
        })

    }
}

function httpDeleteAll(url) {
    var deleteAllTag = document.getElementById("deleteAllTag");
    deleteAllTag.style.color = "rgb(196, 255, 240)";
    if (mediaScreen.matches != true) {
        deleteAllTag.style.transition = "all 1s";
        deleteAllTag.style.fontSize = "20px";
    }
    else
        deleteAllTag.style.transition = "color 1s";
    setTimeout(function () {
        deleteAllTag.style.fontSize = "1em";
        deleteAllTag.style.color = "white";
    }, 1000);
    var xml = new XMLHttpRequest();
    xml.open("Delete", url, false);
    xml.send(null);
    httpGet('http://localhost:8080/api/v1/passwords', 0);
    return xml.responseText;
}

function httpPutThisPassword(url) {
    var passwordToAdd = document.getElementById("passwordToAdd").value;
    if ((passwordToAdd != "" || /[a-zA-Z]/.test(passwordToAdd)) && passwordToAdd.length > 8) {
        pwToAdd.style.color = "rgb(196, 255, 240)";
        if (mediaScreen.matches != true) {
            pwToAdd.style.transition = "all 1s";
            pwToAdd.style.fontSize = "20px";
        }
        else
            pwToAdd.style.transition = "color 1s";
        setTimeout(function () {
            pwToAdd.style.fontSize = "1em";
            pwToAdd.style.color = "white";
        }, 1000);
        var xml = new XMLHttpRequest();
        xml.open("Put", url + passwordToAdd, false);
        xml.send(null);
        httpGet('http://localhost:8080/api/v1/passwords', 0);
        return xml.responseText;
    }
    else {
        pwToAdd.style.color = "red";
        if (mediaScreen.matches != true) {
            pwToAdd.style.transition = "all 1s";
            pwToAdd.style.fontSize = "20px";
        }
        else
            pwToAdd.style.transition = "color 1s";
        setTimeout(function () {
            pwToAdd.style.fontSize = "1em";
            pwToAdd.style.color = "white";
        }, 1000);
    }
}

