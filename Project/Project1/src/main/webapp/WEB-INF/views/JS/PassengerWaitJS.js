let riderData;
async function getRider(){
    
    console.log("inside getrider");
   await fetch("http://localhost:8080/CARPOOL/getRiderById/"+localStorage.getItem("riderId").toString())
    .then(res=> res.json())
    .then(data=>{
        console.log(data);
        riderData=data;
        updateRider();
        // postPick()
    
    
    document.getElementById("name").innerHTML=data.name;
    document.getElementById("carNumber").innerHTML=data.carNumber;
    document.getElementById("startPoint").innerHTML=data.startPoint;
    document.getElementById("destination").innerHTML=data.destination;
    document.getElementById("phoneNumber").innerHTML=data.phoneNumber;

    
} );
}
async function updateRider(){
    console.log("before updating===================");
    console.log(riderData);
  console.log("before posting");
  let data={
      "id":riderData.id,
    "name":riderData.name,
    "carNumber":riderData.carNumber,
    "phoneNumber":riderData.phoneNumber,
    "startPoint":riderData.startPoint,
    "destination":riderData.destination,
    "available":true
    }
    console.log(data);

  await fetch('http://localhost:8080/CARPOOL/updateRider',{
    method: 'PUT',
    headers:{
      'Accept':'application/json',
      'Content-Type':'application/json',
      'Access-Control-Allow-Origin':"*"
    },
    body: JSON.stringify(data)
  })
  .then(response => response.json())
  .then(data => {
    console.log("the data in .then=========================");
    console.log(data);
  })
    
}

getRider();


// async function postPick(){
//     let pickObj={
//         "riderId":localStorage.getItem("riderId"),
//         "passengerId":localStorage.getItem("passengerId")
//       };
//       console.log(pickObj);
// await fetch('http://localhost:8080/CARPOOL/postPick',{
//       method: 'POST',
//       headers:{
//         'Accept':'application/json',
//         'Content-Type':'application/json'
//       },
//       body: JSON.stringify(pickObj)
//     }).then(response => response.json())
//     .then(pickData => {
//       console.log("inside log of .then data");
//       console.log(pickData);
//     });
// }