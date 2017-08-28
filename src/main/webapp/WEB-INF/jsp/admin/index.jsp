<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/echarts.js"></script>
</head>
<body>
	<div id="main" style="width: 400px;height: 400px;"></div>
	<script type="text/javascript">
	var myChart = echarts.init(document.getElementById("main"));
	 //查询  
    function loadDrugs() {  
    	myChart.clear();  
     //myChart.showLoading({text: '正在努力的读取数据中...'});  
        $.get('${pageContext.request.contextPath}/ajax/postClick', function (data) {  
         			
        		console.log(data);
         		myChart.setOption(data, true);  
         		myChart.hideLoading();  
           
        });  
    }  
    //载入图表  
    loadDrugs();  
	
	</script>
</body>
</html>