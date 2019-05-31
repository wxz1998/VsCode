<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>Calculation2</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<body>
	<div style="border: 2px;">
		<form action="servlet/Calculation2Servlet" method="post">
			输入一个数：<input type="text" name="num1" /><br /> 选择运算符：<select
				name="flag">
				<option value=1>+</option>
				<option value=2>-</option>
				<option value=3>*</option>
				<option value=4>/</option>
			</select><br> 输另一个数：<input type="text" name="num2" /><br /> <input
				type="submit" value="提交" /><br />
		</form>
		<%
			Integer result = (Integer) request.getAttribute("result");
		%>
		结果为：<input type="text" name="result" value="<%=result%>" /><br />
	</div>
</body>
</html>