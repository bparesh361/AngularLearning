<html>
<head>
<link href="../css/style.css" rel="stylesheet" />
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css">
  
<!-- jQuery -->
<script type="text/javascript" charset="utf8" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
  
<!-- DataTables -->
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>

<!-- auto completer -->
 <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
 
    
 <script type="text/javascript"
        src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.23/jquery-ui.min.js"></script>

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
   			
   			 $("#searchquestion").autocomplete({   			 	
        		 source: function (request, response) {
           		$.ajax({
               		url: '${rc.contextPath}/discussion/searchquestion.do',
               		type: 'GET',
               		dataType: 'json',
               		data: request,
               		success: function (data) {
                   		response($.map(data, function (value, key) {                   			
                       		 return {
                            	label: value,
                            	value: value                            	
                        };
                   }));
               }
           });
        },
        minLength: 2       
    	});    	
	});
</script>
</head>
<body>	
	<#include "menu.ftl">
	<div id="formcontainer">
	<div id="title">
		<h3> Search Question </h3>
			<form action="${rc.contextPath}/discussion/squewithreply.do" method="post">
				<input type="text" id="searchquestion" size="50" name ="searchquestion"/>
				<input type="submit" value="Details">
			</form>
		<h3>Create Discussions</h3>		
			<div id="createform">
		<form action="${rc.contextPath}/discussion/create.do" method="post">
			<table align="center">
				<input type="text" name="id" id="id" hidden="true"/>
					<tr align="right">
						<td>Enter Question</td>
						<td>
							<textarea name="question"></textarea>
						</td>
				</tr>				
				<tr>
					<td>&nbsp;</td>
					<td id="margin5"><input type="submit" value="submit"
						id="submit" />&nbsp;&nbsp;<input type="reset" value="Reset"
						id="reset" />
					</td>
				</tr>				
				<tr>
					<td colspan="2"><#if msg??>${msg}</#if></div>
					</td>
				</tr>
				</form>
				<#if unansweredquestions??>
				<tr>
					<td colspan="2"><h3 >Un-Answered Questions.</h3></td>
				</tr>
				<div id="uqsection">
				<tr align="left">
					<td colspan="2">
						<#list unansweredquestions as uquestion>
								Question : ${uquestion.question}
								<div id="reply" >
									<form action="reply.do">
										<input type="text" value="${uquestion.id}" name="id" hidden="true"/>
										<textarea name="reply"></textarea>
										<input type="submit" value="submit">								
									</form>
								</div> 
							
						</#list>
					</td>
				</tr>		
				</div>		
				</#if>
			</table>			
		
	</div>	
</body>
</html>