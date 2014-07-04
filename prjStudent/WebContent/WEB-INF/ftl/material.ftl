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
   		
   		$("#batchId").change(function(){
   			$("#studentId option").remove();
   			$("#studentId").append($('<option>').text('--- Select ---').attr('value','NONE'));
   			var batchId= $("#batchId").val();   			
   			var url = "${rc.contextPath}/batch/getschedules.do?batchid="+batchId;   						   			
   			 $.getJSON(url,
    			function (data) {    				
    				for(var i=0;i<data.length;i++){
    					$("#scheduleId").append($('<option>').text(data[i].date).attr('value',data[i].id));
    				}
    			});
   			});    	
	});
</script>
</head>
<body>	
	<#include "menu.ftl">
	<div id="formcontainer">
	<div id="title">
		Materials		
		<div id="createform">
		<form action="${rc.contextPath}/materials/create.do" method="post" enctype="multipart/form-data">
			<table align="center">
			<input type="text" name="id" id="id" hidden="true"/>
				<tr align="right">
					<td>Select Batch :</td>
					<td>
					<select id="batchId" name="batchId">
						<option value="NONE"> --- Select --- </option>
						<#if batchlist??>
							<#list batchlist as batch>
									<option value="${batch.id}">${batch.batchName}</option>
							</#list>
						</#if>
					</select>
					</td>
				</tr>				
				<tr align="right">
					<td>Select Schedule Date : </td>
					<td>
						<select id="scheduleId" name="scheduleId">
							<option value="NONE"> --- Select --- </option>
						</select>
					</td>
				</tr>				
				<tr>				
					<td><input name="files[0]" type="file" /></td>
					<td><input name="files[1]" type="file" /></td>				
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
	
	</div>
		<table id="table_id">
			<thead>
				<tr>
					<th>#</th>					
					<th>Batch Name</th>					
					<th>Batch Date</th>
					<th>Download</th>
					<th>Download</th>
				</tr>
			</thead>
			<tbody>
			<#if materiallist??>
				<#list materiallist as material>
				<tr>
					<td></td>					
					<td>${material.batchName}</td>
					<td>${material.batchDate}</td>
					<#if material.noFileUpload==2>			
							<td><a href="download.do?materialid=${material.id}&f=1">Download</a></td>
							<td><a href="download.do?materialid=${material.id}&f=2">Download</a></td>							
					</#if>
					<#if material.noFileUpload==1>			
							<td><a href="download.do?materialid=${material.id}&f=1">Download</a></td>
							<td><a href="#">-</a></td>														
					</#if>				
					<#if material.noFileUpload==0>			
							<td><a href="#">-</a></td>
							<td><a href="#">-</a></td>														
					</#if>					
				</tr>				
				</#list>
				</#if>
			</tbody>
		</table>
	</div>
</body>
</html>