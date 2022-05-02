let riderData;
async function getRider(){
    
    console.log("inside getrider");
   await fetch("http://localhost:8080/CARPOOL/getRiderById/"+localStorage.getItem("riderId").toString())
    .then(res=> res.json())
    .then(data=>{
        console.log(data);
        riderData=data;
        updateRider();
    
    let time=data.dateTime.split(" ")[1];
    time=formatAMPM(time);
    let day=data.dateTime.split(" ")[0];
    day=formatDay(day);
    const str = data.name;
    const str2 = str.charAt(0).toUpperCase() + str.slice(1);
    document.getElementById("name").innerHTML=str2;
    document.getElementById("carNumber").innerHTML=data.carNumber.toUpperCase();
    document.getElementById("startPoint").innerHTML=data.startPoint;
    document.getElementById("destination").innerHTML=data.destination;
    document.getElementById("dateTime").innerHTML=time+","+day;
    document.getElementById("phoneNumber").innerHTML=data.phoneNumber;

    
} );
}
async function updateRider(){
  let data={
      "id":riderData.id,
    "name":riderData.name,
    "carNumber":riderData.carNumber,
    "phoneNumber":riderData.phoneNumber,
    "startPoint":riderData.startPoint,
    "destination":riderData.destination,
    "dateTime":riderData.dateTime,

    "available":true
    }

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
    console.log(data);
  })
    
}

getRider();

function formatAMPM(date) {
  
  var hours =date.split(":")[0];
  var minutes = date.split(":")[1];  
  var ampm = hours >= 12 ? 'pm' : 'am';
  hours = hours % 12;
  hours = hours ? hours : 12;
  minutes = minutes < 10 ? '0'+minutes : minutes;
  var strTime = hours + ':' + minutes + ' ' + ampm;
  return strTime;
}
function formatDay(day){
  return (day.split("-")[2]+"-"+day.split("-")[1]+"-"+day.split("-")[0])
}