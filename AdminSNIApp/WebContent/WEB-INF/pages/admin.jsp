<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage accounts</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<!-- <script src="script/index.js"></script> -->
</head>
<body>

	
	<div style="position: relative">
		<p style="font-weight: bold; margin-left: 20px">Ulogovani ste kao:
					<%
							out.print(session.getAttribute("username"));
					%>
	</p> 
	<h1 style="text-align: center">Manage accounts</h1>
		<form action="?action=logout" method="post">
			<input style="font-weight: bold; position: absolute; right: 10px; top: 5px; color: green;"  type="submit" value="Logout"/>
		</form>
	</div>
	
	
	<div>
 	
 	<table class="w3-table-all w3-hoverable">
 	<thead>
            <tr class="w3-red">
                <th>Username</th>
                <!-- <th>Password</th>	-->
                <th>Roles</th>
                <th>Active</th>
            </tr>
        </thead>
 		<tbody id="data">
 		</tbody>
 	</table>
 	
 	  
 	<script type="text/javascript">
	
	const userDatatableConst = document.querySelector("#usersDatatable > tbody");
	
	function loadUsers(){	
	var request = new XMLHttpRequest();	
    request.open("GET", "api/user", true);    
	request.onreadystatechange = function (){
        if ((request.readyState == 4) && (request.status == 200)) {
            var allUsers = JSON.parse(request.responseText);
            populateTable(allUsers);

        }
    }
    	request.send();
	}
	
	function populateTable(allUsers){
		var temp = "";
		
		allUsers.forEach((u) => {
			temp += "<tr class='w3-hover-green'>";
			temp += "<td>"+u.username + "</td>";
			//temp += "<td>"+u.password + "</td>";
			temp += "<td>"+u.roles + "</td>";
			temp += "<td>"+u.active + "</td></tr>";
		});
		
		document.getElementById("data").innerHTML = temp;

	}
	
	document.addEventListener("DOMContentLoaded", () => { loadUsers();  });
	
	</script>
 	
	</div>
	
	

</body>
</html>