<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>template.jsp</title>
<%@ include file="/WEB-INF/views/common.jspf" %>
<style type="text/css">
	p {
		transition : transform 1s;
	}
	
</style>
<script type="text/javascript">
	// XML
	// JSON (Javascript Object Notation)
// 	var member = {
// 			email : "xxx@webapp.com",
// 			password : "1234",
// 			name : "홍길동",
// 			gender : "female",
// 			hobby : ["programming", "reading"],
// 			comment : "열공하세요",
// 			reception : true
// 	};

$(document).ready(function() {
	$('button').on("click", function() {
		
		// Ajax(Async javascript and xml)
		$.getJSON("member.json", function(member) {
			console.log(member);
			var message = "email = "    + member.email + "<br>" +
						  "name = "     + member.name +  "<br>" +
						  "password = " + member.password + "<br>" +
						  "gender = "   + member.gender + "<br>" +
						  "hobby = "    + member.hobby + "<br>" +
						  "reception = " + member.reception;
	// 		$('p').text(message);
	// 		$('p').html(message);
	// 		$('p').append(message);
			$('p').prepend(message);
			
			$.each(member.hobby, function(index, value) {
				console.log("hobby[" + index +"] = " + member.hobby[index]);
				console.log("hobby[" + index +"] = " + value);
			});
			
			for (var i=0; i<member.hobby.length; i++) {
				console.log("hobby[" + i +"] = " + member.hobby[i]);
			}
			
		});

	});
	
	$('p').on("click", function() {
		$(this).css("transform", "translate(50px, 50px)");
	});
	
	
});	
	
</script>

</head>
<body>
<h1>template</h1>
<button>member print1</button>
<button>member print2</button>
<p>
	print1
</p>
<p>
	print2
</p>

</body>
</html>