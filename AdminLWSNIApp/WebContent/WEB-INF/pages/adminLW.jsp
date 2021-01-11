<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage articles</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
.container {
	overflow: hidden
}

.tab {
	float: left;
}

.tab-1 {
	margin-left: 50px
}

.tab-1 input {
	display: block;
	margin-bottom: 10px
}

.tab-2 {
	margin-left: 100px
}

.tab-2 input {
	display: block;
	margin-bottom: 10px
}

tr {
	transition: all .5s ease-in-out
}

tr:hover {
	background-color: #EEE;
	cursor: pointer;
}
</style>

</head>
<body>
	<div style="position: relative">
		<p style="font-weight: bold; margin-left: 20px">
			Ulogovani ste kao:
			<%
			out.print(session.getAttribute("username"));
		%>
		</p>
		<h1 style="text-align: center">Manage articles</h1>
		<form action="?action=logout" method="post">
			<input
				style="font-weight: bold; position: absolute; right: 10px; top: 5px; color: green; font-size: 20px; border-radius: 12px;"
				type="submit" value="Logout" />
		</form>
	</div>

	<div class="container">
		<div class="tab tab-1">
			<!--  <table id="table" border="1">	-->
			<table id="table" class="w3-table-all w3-hoverable">
				<thead>
					<tr>
						<th>Name</th>
						<th>Price</th>
					</tr>
				<thead>
				<tbody id="data">
				</tbody>
			</table>
		</div>
		<div class="tab tab-2">
			<form method="POST">
				<!-- Id:  -->
				<input style="display: none" type="number" name="id" id="id">
				Name: <input type="text" name="name" id="name"> Price: <input
					type="number" name="price" id="price">
				<button formaction="?action=addArticle" type="submit"
					onclick="addHTMLTableRow();"
					style="background-color: #4CAF50; font-size: 20px; border-radius: 12px;">Add</button>
				<br> <br />
				<button formaction="?action=editArticle"
					onclick="editHtmlTableSelectedRow();"
					style="background-color: #008CBA; font-size: 20px; border-radius: 12px;">Edit</button>
				<br> <br />
				<button formaction="?action=setUnactiveArticle"
					onclick="removeSelectedRow();"
					style="background-color: #f44336; font-size: 20px; border-radius: 12px;">Remove</button>
				<br> <br />
			</form>
		</div>
	</div>

	<script type="text/javascript">
	
	function loadArticles(){
		
		var request = new XMLHttpRequest();		
	    request.open("GET", "api/article", true);    
		request.onreadystatechange = function (){
	        if ((request.readyState == 4) && (request.status == 200)) {
	            var allArticles = JSON.parse(request.responseText);
	            populateTable(allArticles);
	        }
	    }	    
	    request.send();
	}
	
	function populateTable(allUsers){
		var temp = "";
		
		allUsers.forEach((u) => {
			temp += "<tr class='w3-hover-green'>";
			temp += "<td style='display:none;'>"+u.id + "</td>";
			temp += "<td>"+u.name + "</td>";
			//temp += "<td>"+u.password + "</td>";
			temp += "<td>"+u.price + "</td>";
			//temp += "<td>"+u.id + "</td></tr>";
			temp += "<td style='display:none;'>"+u.active + "</td>";
		});
		
		document.getElementById("data").innerHTML = temp;
		selectedRowToInput();
	}	
	//document.addEventListener("DOMContentLoaded", () => { loadArticles();  });
		
	var rIndex, 
		table = document.getElementById("table");
	
	function checkEmptyInput(){
				
		var isEmpty = false;
		
		name = document.getElementById("name").value,
		price = document.getElementById("price").value;
		
		if(name === ""){
			alert("Name cannot Be Empty");
			isEmpty = true;
		} else if(price === ""){
			alert("Price cannot Be Empty");
			isEmpty = true;
		}
		
		return isEmpty;
	}
	
	function addHTMLTableRow(){
		
		if(!checkEmptyInput()){
		newRow = table.insertRow(table.length),
		cell1 = newRow.insertCell(1),
		cell2 = newRow.insertCell(2),	
		name = document.getElementById("name").value,
		price = document.getElementById("price").value,
		
		cell1.innerHTML = name; 
		cell2.innerHTML = price;
		
		selectedRowToInput();
		}
	}
	
	function selectedRowToInput(){
	
		for(var i=1; i < table.rows.length; i++){
			table.rows[i].onclick = function(){								
				rIndex = this.rowIndex;
				document.getElementById("id").value = this.cells[0].innerHTML;
				document.getElementById("name").value = this.cells[1].innerHTML;
				document.getElementById("price").value = this.cells[2].innerHTML;
			};
		}
	}
	
	loadArticles();
	selectedRowToInput();
	
	
	function editHtmlTableSelectedRow(){
		
		var name = document.getElementById("name").value,
			price = document.getElementById("price").value;
		
		
		table.rows[rIndex].cells[1].innerHTML = name;
		table.rows[rIndex].cells[2].innerHTML = price;		
		
	}
	
	function removeSelectedRow(){		
		table.deleteRow(rIndex);		
		document.getElementById("name").value = "";
		document.getElementById("price").value = "";
	}	
	</script>

</body>
</html>