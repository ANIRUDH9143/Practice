const createPassenger = async() =>{
  console.log("function in passenger page executed");

  let name=document.getElementById("name").value;
  let mailId=document.getElementById("mailId").value;
  let phoneNumber=document.getElementById("phoneNumber").value;
if(!name || !mailId ||!phoneNumber){
var k = document.getElementById("snackbarDetails");
        k.className = "show";
        setTimeout(function(){ k.className = k.className.replace("show", ""); }, 3000);
}else{
  let f1=0,f2=0,f3=0;
  
    if(isValidName(name)){
        console.log("valid name  ");
    }
    else{
        f1=1;
        console.log("not valid name  ");
    }

  if(isValidMail(mailId)){
      console.log("valid mail id  ");
  }
  else{
      f3=1;
      console.log("not valid phone  ");
  }
  if(isValidNumber(phoneNumber)){
      console.log("valid phone  ");
  }
  else{
      f2=1;
      console.log("not valid phone  ");
  }

  if(f1==0 && f2==0 && f3==0){ 
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
    window.open("successfull.html","_self")
  });



  }else{
    if(f1==1){
      var a = document.getElementById("snackbarName");
      a.className = "show";
      setTimeout(function(){ a.className = a.className.replace("show", ""); }, 3000);
    }
    if(f2==1){
      var b = document.getElementById("snackbarPhone");
      b.className = "show";
      setTimeout(function(){ b.className = b.className.replace("show", ""); }, 3000);
    }
    if(f3==1){
      var b = document.getElementById("snackbarMail");
      b.className = "show";
      setTimeout(function(){ b.className = b.className.replace("show", ""); }, 3000);
    }
  }
}
}


  function isValidNumber($number){
    if($number.match('[0-9]{10}$')  && $number.length===10)  {
        return true;
    }  
    else{
        return false;
    }

}

function isValidName($name){
    var letters = '[A-Za-z]{2,40}$';
    if($name.match(letters) )  {
        return true;
    }  
    else{
        return false;
    }
}

function isValidMail($mail){
  var letters='[A-Za-z0-9]@[a-z]{2,10}.[a-z]{2,3}$';
  if($mail.match(letters))  {
      return true;
  }  
  else{
      return false;
  }
}