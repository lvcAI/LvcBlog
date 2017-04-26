<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
	<title>iLvc登陆</title>
<style type="text/css">
.login-dlg {
    position: absolute;
    left: 36%;
    top: 35%;
    width: 30%;
}
input{
	box-sizing: border-box;
	background-color:transparent;
	border: none;
	border-bottom: solid 1px #FFF;
	width: 100%;
	height: 40px;
	font-size: 18px;
	padding:3px 5px;
	color: #FFF;
	margin: 15px 0;
}
input:focus{
	outline: none;
}
.btn{
background-color:#5EB95E;
border: 1px solid green; 
}
</style>
<script type="text/javascript">

	function formcheck(){
		
	}
	
</script>
</head>
<body style="background-image:url(${pageContext.request.contextPath}/resources/img/xk.jpg); ">
	<div class="login-dlg">
		<form action="${pageContext.request.contextPath}/admin/login"  method="POST" onsubmit="return formcheck()" class="login-form">
		
			<input type="text" name="userName"  id="userName" placeholder="username"><br/>
			<input type="password" name="password"  id="password" placeholder="password"><br/>
			
			<input type="submit"  value="Login" id="btn-submit" class="btn btn-success"/>
			 <span color="red">${errorMsg }</span>
		</form>
	</div>

	<script type="text/javascript">
	  //防止页面后退
    history.pushState(null, null, document.URL);
    window.addEventListener('popstate', function () {
        history.pushState(null, null, document.URL);});
　　</script>
</body>
</html>