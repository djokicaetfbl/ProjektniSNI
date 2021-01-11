
function loadData(){
	getAllUsers();
	populateTable();
}

document.addEventListener("DOMContentLoaded", () => { getAllUsers();  });


function getAllUsers() {
	var request = new XMLHttpRequest();
    	request.onreadystatechange = function (){
            if ((request.readyState == 4) && (request.status == 200)) {
                var allUsersForPosts = JSON.parse(request.responseText);
                localStorage.setItem("allUsersForPosts", JSON.stringify(allUsersForPosts));
                return allUsersForPosts;
            }
        }
        request.open("GET", "api/user", true);
        request.send();
}


function populateTable(){
	var allUsers = JSON.parse(localStorage.getItem("allUsersForPosts"));
	
	console.log("ALL USERS: "+JSON.stringify(allUsers));
	
	//var userDataTable = document.getElementById("usersDatatable");
	
	//userDataTable.innerHTML = "";
	
	const userDatatableConst = document.querySelector("#usersDatatable > tbody");
	
	while(userDatatableConst.firstChild) {
		userDatatableConst.removeChild(userDatatableConst.firstChild);  
	}
	
	allUsers.forEach((row) => {
		
		var tr = document.createElement("tr");
		
		console.log("ROW"+row);
		
		Array.from(row).forEach( cell => {
			var td = document.createElement("td");
			td.textContent = cell;
			tr.appendChild(td);
			console.log("DA");
		});
		
		/*row.forEach((cell) => {
			var td = document.createElement("td");
			td.textContent = cell;
			tr.appendChild(td);
		});*/
		
		userDatatableConst.appendChild(tr);
		
	});
	

}