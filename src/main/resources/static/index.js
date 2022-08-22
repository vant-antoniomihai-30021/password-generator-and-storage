
var clearBtn = document.getElementById("clear");
clearBtn.onclick = function clear() {
    document.getElementById("response").innerHTML = "";
}


function httpGet(url) {
    document.getElementById("response").innerHTML = "";
    fetch(url).then((response) => response.json()).then((date) => { console.log(date);
        for(var i =0;i<date.length;i++){
            
            var tag = document.createElement("p");
            var text = date[i].password;
            tag.innerHTML = text;
            var ind = document.createElement("p"); ind.style.display = "inline"; tag.style.display = "inline";
            ind.innerHTML = "Password with the number " + (date[i].indOfThisPassword) + " is: ";
            var br = document.createElement("br");
            tag.style.color = "rgb(152, 256, 255)";
            document.getElementById("response").appendChild(ind);
            document.getElementById("response").appendChild(tag);
            document.getElementById("response").appendChild(br);
            
        }}
       

   );}
  

function httpPut(url) {
    var xml = new XMLHttpRequest();
    xml.open("Put", url, false);
    xml.send(null);
    return xml.responseText;

}

function httpDelete(url) {
    var id = document.getElementById("passwordId");
    var xml = new XMLHttpRequest();
    xml.open("Delete", url + id.value, false);
    xml.send(null);

}

function httpDeleteAll(url) {
    var xml = new XMLHttpRequest();
    xml.open("Delete", url, false);
    xml.send(null);
    return xml.responseText;

}


