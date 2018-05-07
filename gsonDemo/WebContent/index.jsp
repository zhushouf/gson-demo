<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>

<script type="text/javascript">
//使用jquery进行ajax查询数据，并显示到下拉列表中
function queryUsers(){
	var url = "http://localhost:8080/gsonDemo/DemoServlet?type=list";
	
	$.get(url,showUsers);
	
	
	function showUsers(data){
		if(data.result){
			//var users = data.data;
			$.each(data.data,function(index,e){
				$("#userList").append("<option value='"+e.userId+"'>"+e.userName+"</option>");	
			});
		}
	}
}



</script>

</head>
<body>


<input type="button" onclick="queryUsers();" value="点击我进行加载数据"/>


   <select id="userList">
   	<option>用户信息</option>
   </select>

</body>
</html>