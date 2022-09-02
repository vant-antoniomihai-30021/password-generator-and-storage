var clearBtn = document.getElementById("clear");
clearBtn.onclick = function clear() {
    document.getElementById("response").innerHTML = "";
    var clearTag = document.getElementById("clearTag");
    clearTag.style.color = "rgb(196, 255, 240)";
    clearTag.style.fontSize = "22px";
    clearTag.style.transition = "all 1s"
    setTimeout(function () {
        clearTag.style.fontSize = "1em";
        clearTag.style.color = "white";
    }, 1000);
}

var dateCopy;
function httpGet(url, cal) {
    
    if (cal == 1) {
        var getAllTag = document.getElementById("getAllTag");
        getAllTag.style.color = "rgb(196, 255, 240)";
        getAllTag.style.fontSize = "22px";
        getAllTag.style.transition = "all 1s"
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
            tag.style.color = "rgb(152, 256, 255)";
            div.appendChild(ind);
            div.appendChild(tag);
            div.appendChild(copyBtn);
        }
        for(var j = 0; j < dateCopy.length; j++){
            var btn = document.querySelector(".copyBtn"+j);
            btn.onclick = function(v) {
                navigator.clipboard.writeText(v.path[1].querySelector(".tagPw").innerHTML);
                v.path[0].style.borderColor = "purple";
                v.path[0].style.transition = "2s all ease";
                let isPurple = true;
                setTimeout(function () {
                    v.path[0].style.borderColor = "white";
                    v.path[0].onmouseover = function (e){
                        v.path[0].style.borderColor = "rgb(146, 255, 240)";
                        v.path[0].style.transition = "all 0.3s";
                    }    
                    v.path[0].onmouseleave = function (){
                        if(!isPurple)
                            {
                                v.path[0].style.borderColor = "white";
                                isPurple = false;
                            }
                        if(v.path[0].style.borderColor == "rgb(146, 255, 240)" && v.path[0].style.borderColor!="purple"){
                            v.path[0].style.borderColor = "white";
                        }
                    }
                }, 1000);
                

            }
        }

    }
    );
}

function httpPut(url) {
    var pTag = document.getElementById("getTag");
    pTag.style.color = "rgb(196, 255, 240)";
    pTag.style.fontSize = "22px";
    pTag.style.transition = "all 1s"
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
    if (id.value != "") {
        var deleteTag = document.getElementById("deleteTag");
        deleteTag.style.color = "rgb(196, 255, 240)";
        deleteTag.style.fontSize = "22px";
        deleteTag.style.transition = "all 1s"
        setTimeout(function () {
            deleteTag.style.fontSize = "1em";
            deleteTag.style.color = "white";
        }, 1000);
        var xml = new XMLHttpRequest();
        xml.open("Delete", url + id.value, false);
        xml.send(null);
        httpGet('http://localhost:8080/api/v1/passwords', 0);
    }
}

function httpDeleteAll(url) {
    var deleteAllTag = document.getElementById("deleteAllTag");
    deleteAllTag.style.color = "rgb(196, 255, 240)";
    deleteAllTag.style.fontSize = "22px";
    deleteAllTag.style.transition = "all 1s"
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
        if ((passwordToAdd != "" || /[a-zA-Z]/.test(passwordToAdd)) && passwordToAdd.length>8) {
            var xml = new XMLHttpRequest();
            xml.open("Put", url + passwordToAdd, false);
            xml.send(null);
            httpGet('http://localhost:8080/api/v1/passwords', 0);
            return xml.responseText;
        }
    }

