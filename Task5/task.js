function func1(){
    
    var xhttp=new XMLHttpRequest();
    
    xhttp.onload = function() { 
        let value =JSON.parse(this.responseText);
        console.log(value);
        let x= value.content;
        for(let i=0;i<x.length;i++){
            var pc=document.createElement("p");
            pc.innerHTML=x[i].empId +" "+x[i].firstname+" "+x[i].lastname+"<img src="+x[i].picurl+">";
            document.getElementById("id1").appendChild(pc);
            console.log(x[i].firstname);
            
        }
    }
        
    xhttp.open("GET","http://corridor.cloud.wavemakeronline.com/EmployeesAPI/services/HRAPI/Employee");

    xhttp.send();


}


// var form=document.getElementById("formid");
// form.addEventListener('submit',function(e){
//     e.preventDefault();
//     var eid=document.getElementById("emp-id").value;
//     var fnid=document.getElementById("fn-id").value;
//     var lnid=document.getElementById("ln-id").value;

//     fetch("http://corridor.cloud.wavemakeronline.com/EmployeesAPI/services/HRAPI/Employee",{
//         method:'POST',
//         body:JSON.stringify({
//             empId:eid,
//             firstname:fnid,
//             lastname:lnid
//         }),
//         headers:{
//             "Content-Type":"application/json;charset=UTF-8"
//         }

// })
// .then(function(response){
//     return response.json()
// })
// .then(function(data){
//     console.log(data)

// })
// })

function image(){
    var l=document.getElementById("emp-id").value;
    console.log(l);
    
    var xhttp=new XMLHttpRequest();
    
    xhttp.onload = function() { 
        let value =JSON.parse(this.response);
        let x= value.content;
        for(let i=0;i<x.length;i++){
            if(x[i].empId==l){ 
            var pc=document.createElement("p");
            pc.innerHTML=x[i].empId +" "+x[i].firstname+" "+x[i].lastname+"<img src="+x[i].picurl+">";
            document.getElementById("pid").appendChild(pc);
            console.log(x[i].firstname);
            }
        }
    }
        
    xhttp.open("GET","http://corridor.cloud.wavemakeronline.com/EmployeesAPI/services/HRAPI/Employee");

    xhttp.send();

}

// function pos(){
//     var xhttp=new XMLHttpRequest();
    
//     xhttp.onload = function() { 
//         let value =JSON.parse(this.response);
//         let x= value.content;
//         const obj={
//             empId:document.getElementById("eid").innerHTML,
//             firstname:document.getElementById("fid").innerHTML,
//             lastname:document.getElementById("lid").innerHTML
//         }

        
    
//     }
//     xhttp.open("POST","http://corridor.cloud.wavemakeronline.com/EmployeesAPI/services/HRAPI/Employee");

//     xhttp.send();

// }