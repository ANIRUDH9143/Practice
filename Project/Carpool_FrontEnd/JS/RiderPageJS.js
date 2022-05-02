var places=["Miyapur","JNTU College", "KPHB Colony", "Kukatpally", "Balanagar","Moosapet","Bharat Nagar","Erragadda","ESI Hospital","SR Nagar","Ameerpet"];
function arrayRemove(arr, value) {
  return arr.filter(function(ele){
    return ele != value;
  });
}
    var placeObject = {
    "Miyapur": arrayRemove(places,"Miyapur"),
    "JNTU College": arrayRemove(places,"JNTU College"),
    "KPHB Colony": arrayRemove(places,"KPHB Colony"),
    "Kukatpally": arrayRemove(places,"Kukatpally"),
    "Balanagar": arrayRemove(places,"Balanagar"),
    "Moosapet": arrayRemove(places,"Moosapet"),
    "Bharat Nagar": arrayRemove(places,"Bharat Nagar"),
    "Erragadda": arrayRemove(places,"Erragadda"),
    "ESI Hospital": arrayRemove(places,"ESI Hospital"),
    "SR Nagar":arrayRemove(places,"SR Nagar"),
    "Ameerpet": arrayRemove(places,"Ameerpet"),
}
window.onload = function() {
  var start = document.getElementById("startPoint");
  var destination = document.getElementById("destination");
  for (var x in placeObject) {
    start.options[start.options.length] = new Option(x, x);
  }
start.onchange = function() {
    for(var i in destination){
        destination.remove(i);
    }
    var z = placeObject[start.value];
    for (var i = 0; i < z.length; i++) {
      destination.options[destination.options.length] = new Option(z[i], z[i]);
    }
  }
}

const createRider = async() =>{

  let name=document.getElementById("name").value;
  let carNumber=document.getElementById("carNumber").value;
  let startPoint=document.getElementById("startPoint").value;
  let destination=document.getElementById("destination").value;
  let dateTime=document.getElementById("dateTime").value;dateTime=dateTime.replace("T"," ");dateTime+=":00";
  let phoneNumber=document.getElementById("phoneNumber").value;

  
  if(!name || !carNumber   ||  !startPoint   ||  !destination   ||  !dateTime   ||  !phoneNumber  ){
    var k = document.getElementById("snackbarDetails");
        k.className = "show";
        setTimeout(function(){ k.className = k.className.replace("show", ""); }, 3000);
  }
  else{
    let f1=0,f2=0,f3=0;
    
    if(isValidName(name)){
        console.log("valid name   ");
    }else{
        f1=1;
        console.log("not valid name   ");
    }

    if(isValidCarNumber(carNumber)){
        console.log("valid car   ");
    }else{
        f2=1;
        console.log("not valid car   ");
    }

    if(isValidNumber(phoneNumber)){
        console.log("valid phone   ");
    }else{
        f3=1;
        console.log("not valid phone   ");
    }


    
  if(f1==0&&f2==0&&f3==0){ 
    let data={
      "name":name,
      "carNumber":carNumber,
      "startPoint":startPoint,
      "destination":destination,
      "dateTime" : dateTime,
      "phoneNumber":phoneNumber
    };
    console.log(JSON.stringify(data));
    console.log("before posting");
    await fetch('http://localhost:8080/CARPOOL/postRider',{
      method: 'POST',
      headers:{
        'Accept':'application/json',
        'Content-Type':'application/json'
      },
      body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
      console.log("the data after posting");
      console.log(data);

      success();
      // var k = document.getElementById("snackbar");
      //   k.className = "show";
      //   setTimeout(function(){ k.className = k.className.replace("show", ""); }, 3000);
        
        console.log("after 3 sec daelay");
      // window.open("index.html","_self")
    });
  }


  else{
    if(f3==1){
      console.log("in not valid phone");
      var c = document.getElementById("snackbarPhone");
      c.className = "show";
      setTimeout(function(){ c.className = c.className.replace("show", ""); }, 3000);
    }
    if(f2==1){
      console.log("in not valid car");
      var b = document.getElementById("snackbarCar");
      b.className = "show";
      setTimeout(function(){ b.className = b.className.replace("show", ""); }, 3000);
    }
    
    if(f1==1){
      console.log("in not valid name");
      var a = document.getElementById("snackbarName");
      console.log("after getting id");
      a.className = "show";
      console.log("after showing");
      setInterval(() => {
        
      }, 5000);
      setTimeout(function(){ a.className = a.className.replace("show", ""); }, 3000);
      console.log("after 3 sec");
    }
  }
}
}

  function isValidCarNumber($carNumber){
        var letters = '[A-Za-z]{2}[0-9]{2}[A-Za-z]{0,2}[0-9]{4}$';
        if($carNumber.match(letters))  {
            return true;
        }
        else {
           return false;
        }
}

function isValidNumber($number){
    if($number.match('[0-9]{10}$'))  {
        return true;
    }  
    else{
        return false;
    }

}

function isValidName($name){
    var letters = '[A-Za-z]{2,40}$';
    if($name.match(letters))  {
        return true;
    }  
    else{
        return false;
    }
}

    
function success(){
  var k = document.getElementById("snackbar");
  k.className = "show";
  setTimeout(function(){ k.className = k.className.replace("show", ""); }, 3000);
  console.log("inside success func");
  setTimeout(window.open("index.html","_self"),3000);
}