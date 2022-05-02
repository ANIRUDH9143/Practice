let ownerId;
let ownerName;
let ownerCarNumber;
let ownerStartPoint;
let ownerDestination;
let ownerPhoneNumber;
const getOwner = async ()=>{

    let getdata ;
   await fetch("http://localhost:8080/CARPOOL/getRider")
    .then(res=> res.json())
    .then(data=>{
        console.log(data);
        getdata = data
    })

        let obj=getdata;

            document.getElementById(`name`).innerHTML=`${obj.name}`;
            document.getElementById(`carNumber`).innerHTML=`${obj.carNumber}`;
            document.getElementById(`startPoint`).innerHTML=`${obj.startPoint}`;
            document.getElementById(`destination`).innerHTML=`${obj.destination}`;
            document.getElementById(`phoneNumber`).innerHTML=`${obj.phoneNumber}`;

            ownerId=obj.id;
            ownerName=obj.name;            
            ownerCarNumber=obj.carNumber;
            ownerStartPoint=obj.startPoint;;
            ownerDestination=obj.destination;
            ownerPhoneNumber=obj.phoneNumber;
}
// const searchingPassenger = async ()=>{

//     console.log("inside send request func");
//     let requestData ;
//     await fetch("http://localhost:8080/CARPOOL/getRequest")
   
//     .then(res=>res.json()
//         // {
//         // const contentType=res.headers.get("content-type");
//         // console.log(contentType);
//         // if(contentType){
//         //     console.log("inside if contentype");
//         //     res.json()

//         // }
//         // else{
//         //     document.getElementById("notFound").innerHTML="no passengers found yet";
//         //     return;
//         // }
//     // }
//     )
//     .then(data=>{
//         console.log(data);
//         if(data.riderId==ownerId){ 
//                 window.location = "PassengerFound.html";
//         }
//         else{
//             console.log("inside else");
//             alert("No passengers found")

//         }
//     })

// }