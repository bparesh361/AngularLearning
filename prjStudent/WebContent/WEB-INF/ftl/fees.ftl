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
   			var url = "${rc.contextPath}/batch/getstudent.do?batchid="+batchId;   			   			
   			 $.getJSON(url,
    			function (data) {
    				for(var i=0;i<data.length;i++){
    					$("#studentId").append($('<option>').text(data[i].firstName + ' ' + data[i].lastName).attr('value',data[i].id));
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
		Fees		
		<div id="createform">
		<form action="${rc.contextPath}/fees/create.do" method="post">
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
					<td>Select Student : </td>
					<td>
						<select id="studentId" name="studentId">
							<option value="NONE"> --- Select --- </option>
						</select>
					</td>
				</tr>
				<tr align="right">
					<td>Amount : </td>
					<td>
						<input type="text" name="amount" id="amount"/>
					</td>
				</tr>
				<tr align="right">
					<td>Date : </td>
					<td>
						<input type="text" name="feesDate" id="feesDate"/>
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
	
	</div>
		<table id="table_id">
			<thead>
				<tr>
					<th>#</th>
					<th>Id</th>
					<th>Student Name</th>
					<th>Batch Name</th>
					<th>Amount</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
			<#if feeslist??>
				<#list feeslist as fees>
				<tr>
					<td></td>
					<td>${fees.id}</td>
					<td>${fees.studentFirstName} ${fees.studentLastName}</td>
					<td>${fees.batchName}</td>
					<td>${fees.amount}</td>
					<td>${fees.feesDate}</td>
				</tr>				
				</#list>
				</#if>
			</tbody>
		</table>
	</div>
</body>
</html>