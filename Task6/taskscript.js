var div = document.createElement('div');
document.body.appendChild(div);

let button = document.createElement('button');
button.innerHTML = "Get Data";
div.append(button);

button.addEventListener('click', function () {
    const xhttp = new XMLHttpRequest();

    let t = document.createElement('table');
    let thead = document.createElement('thead');
    let tbody = document.createElement('tbody');

    t.appendChild(thead);
    t.appendChild(tbody);
    div.appendChild(t);

    let tr = document.createElement('tr');
    let th1 = document.createElement('th');
    th1.innerHTML = "Employee ID";
    let th2 = document.createElement('th');
    th2.innerHTML = "Full Name";
    let th3 = document.createElement('th');
    th3.innerHTML = "Email";
    let th4 = document.createElement('th');
    th4.innerHTML = "PicURL";
    let  edit= document.createElement('th');
    edit.innerHTML = "Edit";

    tr.appendChild(th1);
    tr.appendChild(th2);
    tr.appendChild(th3);
    tr.appendChild(th4);
    tr.appendChild(edit);
    thead.appendChild(tr);

    xhttp.open("GET","https://reqres.in/api/users?page=1");
    xhttp.send();

    xhttp.onload = function () {
        const x = JSON.parse(this.responseText);
        const obj = x.data;
        for (let i = 0; i < obj.length; i++) {
            let r = document.createElement('tr');
            r.setAttribute('id',i+1);

            let rd1 = document.createElement('td');
            rd1.innerHTML = obj[i].id;
            rd1.setAttribute("id","r2d1"+r.id);

            let rd2 = document.createElement('td');
            rd2.innerHTML = obj[i].first_name + " " + obj[i].last_name;
            rd2.setAttribute("id","r2d2"+r.id);

            let rd3 = document.createElement('td');
            rd3.innerHTML = obj[i].email;
            rd3.setAttribute("id","r2d3"+r.id);

            let rd4=document.createElement("td");
            rd4.innerHTML=obj[i].avatar;
            rd4.setAttribute("id","r2d4"+r.id);

            let bttn= document.createElement('button');
            bttn.innerHTML="EDIT";
            bttn.addEventListener('click',function(){
                console.log(r.id);
                var id=document.getElementById("r2d1"+r.id);
                var name=document.getElementById("r2d2"+r.id);
                var email=document.getElementById("r2d3"+r.id);
                var picurl=document.getElementById("r2d4"+r.id);

                var id_data=id.innerHTML;
                var name_data=name.innerHTML;
                var email_data=email.innerHTML;
                var picurl_data=picurl.innerHTML;

                id.innerHTML="<input type='text' id='id_text'+" + r.id + " 'value=' " + id_data + "'>'";
                name.innerHTML="<input type='text' id='name_text"+r.id +"'value='"+name_data +"'>";
                email.innerHTML="<input type='text' id='email_text"+r.id +"'value='"+email_data +"'>";
                picurl.innerHTML="<input type='text' id='picurl_text"+r.id +"'value='"+picurl_data +"'>";
            });


            let sav= document.createElement('button');
            sav.innerHTML="SAVE";
            sav.addEventListener('click',function(){
                console.log(r.id);
                var id=document.getElementById("r2d1"+r.id);
                var name=document.getElementById("r2d2"+r.id);
                var email=document.getElementById("r2d3"+r.id);
                var picurl=document.getElementById("r2d4"+r.id);


                id.innerHTML="<p>"+document.getElementById("id_text"+r.id).innerHTML+"</p>";
                name.innerHTML="<p>"+document.getElementById("name_text"+r.id).innerHTML+"</p>";
                email.innerHTML="<p>"+document.getElementById("email_text"+r.id).innerHTML+"</p>";
                picurl.innerHTML="<p>"+document.getElementById("picurl_text"+r.id).innerHTML+"</p>";
            });

            r.appendChild(rd1);
            r.appendChild(rd2);
            r.appendChild(rd3);
            r.appendChild(rd4);
            r.appendChild(bttn);
            r.appendChild(sav);

            tbody.appendChild(r);
        }
    }
});

