<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web shop</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/table-to-json@1.0.0/lib/jquery.tabletojson.min.js" integrity="sha256-H8xrCe0tZFi/C2CgxkmiGksqVaxhW0PFcUKZJZo1yNU=" crossorigin="anonymous"></script>
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

	<p style="font-weight: bold; margin-left: 20px">Ulogovani ste kao:
					<%
							out.print(session.getAttribute("username"));
					%>
	</p> 

		<h1 style="text-align: center">Web Shop</h1>
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
						<!-- <th>Age</th> -->
					</tr>
				<thead>
				<tbody id="data">
				</tbody>
			</table>
		</div>
		<div class="tab tab-2">
			<!-- 	<form method="POST">		-->
				<input style="display: none" type="number" name="id" id="id">
				Name: <input type="text" name="name" id="name" readonly> Price: <input
					type="number" name="price" id="price" readonly>
				<button type="submit"
					onclick="addArticleToCart();"
					style="background-color: #4CAF50; font-size: 20px; border-radius: 12px;">Add
					article to cart</button>
				<br> <br />
		<!-- 	</form>		-->
		</div>
	</div>

	<hr />
	<hr />
	
	<h1 style="text-align: center">Web cart</h1>

	<div class="container">
		<div class="tab tab-1">
			<table id="tableCart" class="w3-table-all w3-hoverable">
				<thead>
					<tr>
						<th style="display: none">Id</th>
						<th>Name</th>
						<th>Price</th>
					</tr>
				<thead>
				<tbody id="cartData">
				</tbody>
			</table>
		</div>
		<div class="tab tab-2">
			
			<!--  <form method="POST"> -->
				   <input style="display: none" type="number" name="idCart" id="idCart">
			Name:  <input type="text" name="nameCart" id="nameCart" readonly>
			Price: <input type="number" name="priceCart" id="priceCart" readonly>
				<button type="submit" onclick="removeCartSelectedRow();" style="background-color: #008CBA; font-size: 20px; border-radius: 12px;">Remove</button> <br><br />
			 
				<!-- <button formaction="?action=buy" type="submit" onclick="buy();"  -->
				<button type="submit" onclick="buyArticle();"
					style="background-color: #f44336; font-size: 20px; border-radius: 12px;">Buy</button>
				<br> <br />
		<!-- 	</form> -->
			  
		</div>
	</div>

	<script type="text/javascript">
	
	var rIndex,
	tableCart = document.getElementById("tableCart"),
	table = document.getElementById("table");
	
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
		
		
		console.log(allUsers);
		
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
	
	function selectedCartRowToInput(){				
		for(var i=1; i < tableCart.rows.length; i++){
			tableCart.rows[i].onclick = function(){
								
				rIndex = this.rowIndex;
				document.getElementById("idCart").value = this.cells[0].innerHTML;
				document.getElementById("nameCart").value = this.cells[1].innerHTML;
				document.getElementById("priceCart").value = this.cells[2].innerHTML;
			};
		}
	}
	
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
	
	function addArticleToCart(){

		if(!checkEmptyInput()){
			newRow = tableCart.insertRow(tableCart.length),
			cell1 = newRow.insertCell(0),
			cell2 = newRow.insertCell(1),
			cell3 = newRow.insertCell(2),
			id = document.getElementById("id").value,
			name = document.getElementById("name").value,
			price = document.getElementById("price").value,
			
			cell1.style.display = "none";
			
			cell1.innerHTML = id;
			cell2.innerHTML = name; 
			cell3.innerHTML = price;
			
			selectedCartRowToInput();
			}
	}
	
	function removeCartSelectedRow(){
		
		tableCart.deleteRow(rIndex);
		
	}
	
	function buyArticle(){
		var table = $('#tableCart').tableToJSON();
	    var sum = 0.0;
	    var test=""+"\n";
	    
	    Array.from(table).forEach(obj => {    	
	    	sum = sum + parseFloat(obj.Price);
	    	test += "Name: "+obj.Name +"\n"+"Price: "+obj.Price+"\n"+"==================="+"\n";	    	
	    });	
		var sum = 0;
		alert("You bought: \n"+test+"\n"+"Thank You !");
	}
	
	loadArticles();
	selectedRowToInput();
	selectedCartRowToInput();
	
	</script>


</body>
</html>