<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>display.jsp</title>
<%@ include file="/WEB-INF/views/common.jspf" %>
<style type="text/css">
	span, div {
		border: 1px solid red;
		height: 100px;
		width: 100px;
/* 		margin: 50px 20px; */
	}
	
</style>
</head>
<body>
<h1>display : none | inline | block | inline-block</h1>
<h2>width height</h2>
<span>inline1</span>
<!-- <span>inline-block</span> -->
<span style="display: inline-block; vertical-align: bottom;">inline-block</span>
<span>inline3</span>
<div>block1</div>
<div>block2</div>
<!-- <div style="display: none">block2</div> -->
<div>block3</div>

</body>
</html>