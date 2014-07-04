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
   			//alert(location);
   			window.location=location;
   		});
   		
   		$("#bassignstudent").click(function(){
   			var data = table.rows('.selected').data();
   			data = "\""+data[0]+"\""; 
   			var id = data.split(",")[1];   			
   			var location = "${rc.contextPath}/batch/showbtasgstudent.do?batchid="+id;
   			alert(location);
   			window.location=location;
   		});
   		$("#bschedule").click(function(){
   			var data = table.rows('.selected').data();
   			data = "\""+data[0]+"\""; 
   			var id = data.split(",")[1];   			
   			var location = "${rc.contextPath}/schedule/show.do?batchid="+id;
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
		Batch		
		<div id="createform">
		<form action="${rc.contextPath}/batch/create.do" method="post">
			<table align="center">
			<input type="text" name="id" id="id" hidden="true"/>
				<tr>
					<td>Batch Name :</td>
					<td><input type="text" name="batchName" id="batchName" />
					</td>
				</tr>
				<tr>
					<td>Start Date :</td>
					<td><input type="text" name="startDate" id="startDate" />
					</td>
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
	<input type="button" id="bassign" value="Assign Faculty"/>
	<input type="button" id="bassignstudent" value="Student Allocation"/>
	<input type="button" id="bschedule" value="Batch Schedule"/>
	</div>
		<table id="table_id">
			<thead>
				<tr>
					<th>#</th>
					<th>Id</th>
					<th>Batch Name</th>
					<th>Batch Creation Date</th>
				</tr>
			</thead>
			<tbody>
			<#if batchlist??>
				<#list batchlist as batch>
				<tr>
					<td></td>
					<td>${batch.id}</td>
					<td>${batch.batchName}</td>
					<td>${batch.startDate}</td>
				</tr>				
				</#list>
				</#if>
			</tbody>
		</table>
	</div>
</body>
</html>