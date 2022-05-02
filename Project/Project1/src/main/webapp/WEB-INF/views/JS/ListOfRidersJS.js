const getRiders = async ()=>{

    let list ;
   await fetch("http://localhost:8080/CARPOOL/getRiders")
    .then(res=> res.json())
    .then(data=>{
        console.log(data);
        list = data
    })
    console.log(list);


    let data="";
    let tbody=document.getElementById("tbody");
    for(let i=0;i<list.length;i++){
        console.log(list[i]);
        
        data+=
        `
            <tr>
                <td>${list[i].name}</td>
                <td>${list[i].startPoint}</td>
                <td>${list[i].destination}</td>
                <td><button onclick="chooseRide(${list[i].id})" id=${list[i].id} class="button2">Choose</button></td>
            </tr>
        `

        tbody.innerHTML=data;

    }
    

        
}

function chooseRide(riderId){
    localStorage.setItem("riderId",riderId);
    window.location.href = "PassengerPage.html",true;
}