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
        	"bProcessing":true,
        	"bServerSide": true,
        	"bLenthChange" : false,
   			"iDisplayLength" : 10,
        	"sAjaxSource": "getall.do",            	
        	"aoColumns": [
        	 {
        		"sTitle" : "Student NAME",
        		"mData" : "studentName"
       		},
       		   {
        		"sTitle" : "Faculty NAME",
        		"mData" : "facultyName"
       		},
       		 {
        		"sTitle" : "Date",
        		"mData" : "aDate"
       		}        	
        	],
        	"fnServerData" : function(sSource, aoData, fnCallback) {
    			$.ajax({
     			"dataType" : 'json',
     			"type" : "GET",
     			"url" : sSource,
     			"data" : aoData,
     			"success" : fnCallback
    			});
   			},
   			"sPaginationType" : "full_numbers"
    	}); // datatable
		
		
    
    $("#typestudent").click(function(){    	
    	$("#studentrow").show();
    	$("#facultyrow").hide();
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
    $("#typefaculty").click(function(){   
    	$("#studentrow").hide();
    	$("#facultyrow").show();    	
    	$("#facultyId option").remove();
   		$("#facultyId").append($('<option>').text('--- Select ---').attr('value','NONE'));
   		var batchId= $("#batchId").val();   			
   		var url = "${rc.contextPath}/batch/getfaculty.do?batchid="+batchId;   		  			   			
   		 $.getJSON(url,
    		function (data) {
    				for(var i=0;i<data.length;i++){
    					$("#facultyId").append($('<option>').text(data[i].firstName + ' ' + data[i].lastName).attr('value',data[i].id));
    			}
    	});
    });
   	
   	$("#studentrow").hide();
   	$("#facultyrow").hide();
   	
	});
</script>
</head>
<body>	
	<#include "menu.ftl">
	<div id="formcontainer">
	<div id="title">
		Attendence		
		<div id="createform">
		<form action="${rc.contextPath}/attendence/create.do" method="post">
			<table align="center">
			<input type="text" name="id" id="id" hidden="true"/>
				<tr>					
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
				<tr>
					<td><input type="radio" id="typestudent" name="type" value="student" >Student</input></td>
					<td><input type="radio" id="typefaculty" name="type" value="faculty" >Faculty</input></td>
				</tr>					
				<tr align="right" id="studentrow">
					<td>Select Student : </td>
					<td>
						<select id="studentId" name="studentId">
							<option value="NONE"> --- Select --- </option>
						</select>
					</td>
				</tr>								
				<tr align="right" id="facultyrow">
					<td>Select Faculty : </td>
					<td>
						<select id="facultyId" name="facultyId">
							<option value="NONE"> --- Select --- </option>
						</select>
					</td>
				</tr>	
				<tr align="right" id="facultyrow">
					<td>Select Date : </td>
					<td>
						<input type="text" id="adate" name="aDate"/>
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
					<th>studentName</th>
					<th>facultyName</th>
					<th>aDate</th>						
				</tr>
			</thead>
			
		</table>
	</div>
</body>
</html>