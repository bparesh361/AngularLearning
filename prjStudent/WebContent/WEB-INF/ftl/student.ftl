<html>
<head>

  
<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
  
<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
<!-- auto completer -->
 <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
 
    
    <script type="text/javascript"
        src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.23/jquery-ui.min.js"></script>
 
 <!-- DataTables CSS -->
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
 
 <!--- custom CSS -->
 <link href="../css/style.css" rel="stylesheet" />
 
 
<script type="text/javascript">



	$("document").ready(function(){
		var table = $('#table_id').DataTable(
		{
        "columnDefs": [ {
            "searchable": false,
            "orderable": false,
            "targets": 0
        } ],
        "order": [[ 1, 'asc' ]]
    	}
		
		);	
		
		table.on( 'order.dt search.dt', function () {
        table.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        } );
    	} ).draw();
			
		$('#table_id tbody').on( 'click', 'tr', function () {		
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');    			 
            $(this).addClass('selected');
        }     	
    });
    
   	 $( "#collegeName" ).autocomplete({
        source: '${rc.contextPath}/college/getall.do',
         minLength: 3
       
    });
    
     $("#bedit").click(function(){
   			var data = table.rows('.selected').data();
   			data = "\""+data[0]+"\"";   			   			
   			var firstname = data.split(",")[2];   			  			
   			$("#firstName").val(firstname);
   			var lastname = data.split(",")[3];
   			lastname = lastname.substring(0,lastname.length-1);
   			$("#lastName").val(lastname);
   			var email = data.split(",")[4];
   			email = email.substring(0,email.length-1);  			
   			$("#email").val(email);
   			var active = data.split(",")[5];
   			active= active.substring(0,active.length-1);
   			if(active=='In-Active') {
   			$("#isInActive").attr('checked',true);
   			$("#isActive").attr('checked',false);
   			} else {
   			$("#isActive").attr('checked',true);
   			$("#isInActive").attr('checked',false);
   			}
   			   			
   			var id = data.split(",")[1];
   			$("#id").val(id);
   			$("#submit").val("update");   			
   		});
   
   		$("#reset").click(function(){
   			$("#submit").val("create");
   		});
   		
   		$("#bassign").click(function(){
   			var data = table.rows('.selected').data();
   			data = "\""+data[0]+"\""; 
   			var id = data.split(",")[1];   			
   			var location = "${rc.contextPath}/student/assign.do?batchid="+id;
   			alert(location);
   			window.location=location;
   		});
   	
  
	});
</script>
</head>
<body>	
	<#include "menu.ftl">
	<div id="formcontainer">
	<div id="title">
		Student		
		<div id="createform">
		<form action="${rc.contextPath}/student/create.do" method="post">
			<table align="center">
				<input type="text" name="id" id="id" hidden="true"/>
				<tr>
					<td>First Name :</td>
					<td><input type="text" name="firstName" id="firstName" />
					</td>
				</tr>
				<tr>
					<td>Last Name :</td>
					<td><input type="text" name="lastName" id="lastName" />
					</td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><input type="text" name="email" id="email" />
					</td>
				</tr>
				<tr>
					<td>College :</td>
					<td><input type="text" name="collegeName" id="collegeName" />				
					</td>
				</tr>
				<tr>
					<td><input type="radio" id="isActive" name="active" value="true" >Active</input></td>
					<td><input type="radio" id="isInActive" name="active" value="false" >In-Active</input></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td id="margin5"><input type="submit" value="Create"
						id="submit" />&nbsp;&nbsp;<input type="reset" value="Reset"
						id="reset" />
					</td>
				</tr>
				<tr>
					<td colspan="2"><div id="errormsg"></div>
					</td>
				</tr>
				<tr>
					<td colspan="2"><#if msg??>${msg}</#if></div>
					</td>
				</tr>
			</table>			
		</form>
	</div>
	<input type="button" id="bedit" value="Edit"/>
	</div>
		<table id="table_id">
			<thead>
				<tr>
					<th>#</th>
					<th>id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Active</th>
				</tr>
			</thead>
			<tbody>
			<#if studentlist??>
				<#list studentlist as student>
				<tr>
					<td></td>
					<td>${student.id}</td>
					<td>${student.firstName}</td>
					<td>${student.lastName}</td>
					<td>${student.email}</td>
					<td>${student.active}</td>
				</tr>				
				</#list>
				</#if>
			</tbody>
		</table>
	</div>
</body>
</html>