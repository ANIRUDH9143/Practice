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
  console.log("function in rider page executed");
  let name=document.getElementById("name").value;
  let carNumber=document.getElementById("carNumber").value;
  let startPoint=document.getElementById("startPoint").value;
  let destination=document.getElementById("destination").value;
  let phoneNumber=document.getElementById("phoneNumber").value;

  let data={
    "name":name,
    "carNumber":carNumber,
    "startPoint":startPoint,
    "destination":destination,
    "phoneNumber":phoneNumber
  };
  console.log(data);
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
    console.log("the data in .then");
    console.log(data);
    // window.location = "index.html";
  });
  console.log("end");
  // console.log("no redirecting");



  }
