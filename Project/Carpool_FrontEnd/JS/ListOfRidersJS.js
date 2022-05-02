const getRiders = async ()=>{

    let list ;
   await fetch("http://localhost:8080/CARPOOL/getRiders")
    .then(res=> res.json())
    .then(data=>{
        list = data
    })


    let data="";
    let tbody=document.getElementById("tbody");
    for(let i=0;i<list.length;i++){        
        data+=
        `
            <tr>
                <td>${list[i].name}</td>
                <td>${list[i].startPoint}</td>
                <td>${list[i].destination}</td>
                <td>${list[i].dateTime}</td>
                <td><button onclick="chooseRide(${list[i].id})" id=${list[i].id} class="button2 cls">Choose</button></td>
            </tr>
        `

        tbody.innerHTML=data;

    }
    

        
}

function chooseRide(riderId){
    localStorage.setItem("riderId",riderId);
    window.location.href = "signup.html",true;
}