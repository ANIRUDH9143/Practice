var obj=[{activity:"Excercising",status:true},
{activity:"Going to Bank",status:false},
{activity:"Breakfast",status:true},
{activity:"Attend birthday party",status:false}];

var div=document.createElement("div");
div.setAttribute("id","id1");
div.setAttribute("class","className");
document.body.appendChild(div);

var p=document.createElement("p");
p.innerHTML="List of todo tasks : ";
div.appendChild(p); 

var span1=document.createElement("span");
span1.setAttribute("id","sp-id");
p.appendChild(span1);

var input=document.createElement("input");
input.className="inp-cls";
input.setAttribute("placeHolder","Title..");
input.setAttribute("id","inp-id")
document.getElementById("id1").appendChild(input);

var but=document.createElement("button");
but.innerHTML="Add activity..";
but.addEventListener("click",clicked);
div.appendChild(but);


function clicked(){
    
    var k=document.getElementById("inp-id").value;
    if(k){  
    var txt={
        name:k,status:false
    }
    obj.push(txt);

    var nl=document.createElement("li");
    nl.innerHTML=k;
    nl.appendChild(butfun());
    ul.append(nl);

    /*
            var c = document.createElement('input');
            c.type = "checkbox";
            c.className="cb-cls";
            c.id="cb-id";
            nl.appendChild(c);
            c.addEventListener('change',function(){
                nl.style.text-decoration
            })
    */ 
    document.getElementById("sp-id").innerHTML=obj.length;
    document.getElementById('inp-id').value = '';
}
else{
    alert("<<<<<<<<Enter activity>>>>>>>>")
}

}




span1.innerHTML=obj.length;

var div2=document.createElement("div");
div2.setAttribute("id","id2");
div2.className="div2-cls";
document.body.appendChild(div2);

var ul=document.createElement("ul");
div2.appendChild(ul);

function butfun(){
var c = document.createElement('input');
c.type = "checkbox";
c.className="cb-cls";
c.id="cb-id";
return c;
}

var l1=document.createElement("li");
l1.innerHTML="Excercising";
l1.appendChild(butfun());
ul.appendChild(l1);



var l2=document.createElement("li");
l2.innerHTML="Going to Bank";
l2.appendChild(butfun());
ul.appendChild(l2);

var l3=document.createElement("li");
l3.innerHTML="Breakfast";
l3.appendChild(butfun());
ul.appendChild(l3);

var l4=document.createElement("li");
l4.innerHTML="Attend birthday party";
l4.id="l4-id";
l4.appendChild(butfun());
ul.appendChild(l4);


