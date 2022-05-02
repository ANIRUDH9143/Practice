<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOC TYPE HTML>
<html>
    
<head>
    <title>Customer</title>
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script>
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
    </script>
</head>

<body>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<h1>Customer Page</h1>
    <div class="container">
        <div class="row align-items-center">
            <div class="col-6 mx-auto">
                <div class="jumbotron">
                    <form action="customerFormHandle" method="post">
                        <label for="name">Name:</label>
                        <input type="text" id="name" name="name" ><br><br>
            
                        <label for="startPoint">Start point:</label>
                        <select name="startPoint" id="startPoint">
                            <option value="" selected="selected">Select start point</option>

                          </select><br><br>

                        <label for="destination">Destination:</label>
                        <select name="destination" id="destination">
                            <option value="" selected="selected">Select destination</option>

                          </select><br><br>            
                        <input type="submit" value="Search">
                      </form> 
                </div>
            </div>
        </div>
    </div>
</body>

</html>