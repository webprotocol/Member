<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>template.jsp</title>
<%@ include file="/WEB-INF/views/common.jspf" %>
<style type="text/css">
	
</style>
</head>
<body>
<h1>template</h1>
<input type="text"/>
<p></p>
<script type="text/javascript">
	$('input').keyup(function() {
		$('p').html($('input').val());
	});
</script>


</body>
</html>