
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
        "Ameerpet": arrayRemove(places,"Ameerpet")
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

const createPassenger = async() =>{
  console.log("function in passenger page executed");

  let name=document.getElementById("name").value;
  let mailId=document.getElementById("mailId").value;
  let phoneNumber=document.getElementById("phoneNumber").value;

  let data={
    "name":name,
    "mailId":mailId,
    "phoneNumber":phoneNumber,
    "riderId":localStorage.getItem("riderId")
  };
  console.log(data);

  await fetch('http://localhost:8080/CARPOOL/postPassenger',{
    method: 'POST',
    headers:{
      'Accept':'application/json',
      'Content-Type':'application/json'
    },
    body: JSON.stringify(data)
  }).then(response => response.json())
  .then(data => {
    console.log("inside log of .then data");
    console.log(data);
    ////////////////////////////////////////////////////////////////////////////////

    localStorage.setItem("passengerId",data.id)
    console.log(localStorage.getItem("passengerId"));
    // window.location = "PassengerWait.html";
  });



  }
