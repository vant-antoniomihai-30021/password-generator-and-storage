
// function register(){
//     let url = "http://localhost:8080/api/v1/users/save-user-";
//     let name = document.getElementById("name");
//     let password  = document.getElementById("password");
//     let email = document.getElementById("email")
//     if(name.value!="" && password.value!="" && email.value!=""){
//     var xml = new XMLHttpRequest();
//     xml.open("Post", url+name.value+'-'+password.value+'-'+email.value, false);
//     xml.send(null);
//     return xml.responseText;
//     }
// }

// function login(){
//     let url = "http://localhost:8080/api/v1/users/exists-";
//     let name = document.getElementById("name");
//     let password  = document.getElementById("password");
//     let email = document.getElementById("email")
//     if(name.value!="" && password.value!=""  && email.value!=""){
//         fetch(url+name.value+'-'+password.value+'-'+email.value).then((data) => data.json()).then((data) => {
            
//             if(data == true)
//                 window.open("http://127.0.0.1:5500/index.html","_self");
//         }
//     )}
// }