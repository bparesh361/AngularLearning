<html>
<head>
<link href="../css/style.css" rel="stylesheet" />
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
  
<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
  
<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>

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
    
    $("#bedit").click(function(){
   			var data = table.rows('.selected').data();
   			data = "\""+data[0]+"\"";   			   			
   			var batchName = data.split(",")[2];   			  			
   			$("#batchName").val(batchName);
   			var startDate = data.split(",")[3];
   			startDate = startDate.substring(0,startDate.length-1);  			
   			$("#startDate").val(startDate);
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
   			var location = "${rc.contextPath}/batch/showbtasg.do?batchid="+id;
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
		Batch - Faculty Assignment	
		<div id="createform">
		<form action="${rc.contextPath}/batch/assignbatch.do" method="post">
			<div id="highlight">
			<table id="highlight">
			<input type="text" name="id" id="id" hidden="true" value="${batchvo.id}"/>
				<tr>
					<td>Batch Name :</td>
					<td>${batchvo.batchName}</td>
				</tr>
				<tr id="highlight">
					<td>Start Date :</td>
					<td>${batchvo.batchName}</td>
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
			</div>		
		</form>
	</div>
	<div id="actions">
		
	</div>	
			Assigned Faculties : <br/>
			<div id="errormsg">
			<#if batchvo.faculties??>
				<#assign count = batchvo.getFaculties()?size>
				<#assign x=0>			
					<#list batchvo.faculties as afaculty>
						<#assign x=x+1>
							${x} : ${afaculty.firstName} ${afaculty.lastName}
							<#if (count>x)><br/></#if>						
					</#list>
			</#if>
			</div>
	
	</div>
		<table id="table_id">
			<thead>
				<tr>
					<th>#</th>
					<th>id</th>
					<th>Name</th>					
					<th>Assign</th>
				</tr>
			</thead>
			<tbody>
			<#if facultylist??>
				<#list facultylist as faculty>
				<tr>
					<td></td>
					<td>${faculty.id}</td>
					<td>${faculty.firstName} ${faculty.lastName}</td>					
					<td>
					<#if (faculty.batch==1)>	
					<a href="btasg.do?batchid=${batchvo.id}&allocate=true&facultyid=${faculty.id}">Allocate<a>
					<#else>
					<a href="btasg.do?batchid=${batchvo.id}&allocate=false&facultyid=${faculty.id}">De-Allocate<a>
					</#if>					
					</td>
				</tr>				
				</#list>
				</#if>
			</tbody>
		</table>
</body>
</html>