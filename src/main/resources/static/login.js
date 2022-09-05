
function register(){
    let url = "http://localhost:8080/api/v1/users/save-user-";
    let name = document.getElementById("name");
    let password  = document.getElementById("password");
    if(name!="" && password!=""){
    var xml = new XMLHttpRequest();
    xml.open("Post", url+name.value+'-'+password.value, false);
    xml.send(null);
    return xml.responseText;
    }
}

function login(){
    let url = "http://localhost:8080/api/v1/users/exists-";
    let name = document.getElementById("name");
    let password  = document.getElementById("password");
    if(name!="" && password!=""){
        fetch(url+name.value+'-'+password.value).then((data) => data.json()).then((data) => {
            if(data === "true")
                window.location = "http://127.0.0.1:5500/index.html";
        }
    )}
}