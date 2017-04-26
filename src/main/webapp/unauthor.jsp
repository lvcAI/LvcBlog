<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 重定向到index.html，让springmvc接收，这里.html是伪静态
	springmvc接收所有.do和.html结尾的请求 -->

<div>
	<p>您没有操作或访问该资源的权限！请联系管理员!</p>
	<a href="${request.contextPath }/LvcBlog">返回首页！</a>
</div>