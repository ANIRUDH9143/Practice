
function func() {
        var xhttp = new XMLHttpRequest();
  
        xhttp.open("GET","https://reqres.in/api/users?page=1");
        xhttp.send();    

        xhttp.onload = function() { 
            let value =JSON.parse(this.response);
            for (let index = 0; index < value.data.length; index++) {
                var x=document.createElement("p");
                var obj=value.data[index];
                var p=document.createElement("p");
                p.innerHTML=
                "Name : "+obj.first_name+" "+obj.last_name+"<br/>"+
                "ID : "+ obj.id+"<br/>"+
                "Email : " + obj.email+"<br/>"+"<br/>"+
                "<img src="+obj.avatar+">"+"<br/><br/>";
                document.getElementById("demo").appendChild(p);
        
            }
        }
    
}

