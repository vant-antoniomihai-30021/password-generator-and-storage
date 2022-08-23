
var clearBtn = document.getElementById("clear");
clearBtn.onclick = function clear() {
    document.getElementById("response").innerHTML = "";
    var clearTag = document.getElementById("clearTag");
    clearTag.style.color="rgb(196, 255, 240)";
    clearTag.style.fontSize="22px";
    clearTag.style.transition="all 1s"
    setTimeout( function(){ 
        clearTag.style.fontSize="1em";
        clearTag.style.color="white";
    },1000);
}


function httpGet(url) {
    var getAllTag = document.getElementById("getAllTag");
    getAllTag.style.color="rgb(196, 255, 240)";
    getAllTag.style.fontSize="22px";
    getAllTag.style.transition="all 1s"
    setTimeout( function(){ 
        getAllTag.style.fontSize="1em";
        getAllTag.style.color="white";
    },1000);
    document.getElementById("response").innerHTML = "";
    fetch(url+"/check-if-empty").then((data)=>data.json()).then((data)=>{
        if(data === true){
            var tag = document.createElement("p");
            tag.innerHTML="There are no passwords in the database.";
            document.getElementById("response").appendChild(tag);}
        
    })
    
    fetch(url).then((response) => response.json()).then((date) => { 
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
    var pTag = document.getElementById("getTag");
    pTag.style.color="rgb(196, 255, 240)";
    pTag.style.fontSize="22px";
    pTag.style.transition="all 1s"
    setTimeout( function(){ 
        pTag.style.fontSize="1em";
        pTag.style.color="white";
    },1000);
    var xml = new XMLHttpRequest();
    xml.open("Put", url, false);
    xml.send(null);
    return xml.responseText;

}

function httpDelete(url) {
    var deleteTag = document.getElementById("deleteTag");
    deleteTag.style.color="rgb(196, 255, 240)";
    deleteTag.style.fontSize="22px";
    deleteTag.style.transition="all 1s"
    setTimeout( function(){ 
        deleteTag.style.fontSize="1em";
        deleteTag.style.color="white";
    },1000);
    var id = document.getElementById("passwordId");
    var xml = new XMLHttpRequest();
    xml.open("Delete", url + id.value, false);
    xml.send(null);

}

function httpDeleteAll(url) {
    var deleteAllTag = document.getElementById("deleteAllTag");
    deleteAllTag.style.color="rgb(196, 255, 240)";
    deleteAllTag.style.fontSize="22px";
    deleteAllTag.style.transition="all 1s"
    setTimeout( function(){ 
        deleteAllTag.style.fontSize="1em";
        deleteAllTag.style.color="white";
    },1000);
    var xml = new XMLHttpRequest();
    xml.open("Delete", url, false);
    xml.send(null);
    return xml.responseText;

}


