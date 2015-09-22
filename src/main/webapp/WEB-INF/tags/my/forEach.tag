<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="var"   type="java.lang.String"  required="true" rtexprvalue="false"%>
<%@ attribute name="begin" type="java.lang.Integer" required="true" rtexprvalue="true"%>
<%@ attribute name="end"   type="java.lang.Integer" required="true" rtexprvalue="true"%>
<%@ variable name-from-attribute="var"
			 alias="avar"
			 variable-class="java.lang.Integer"
			 scope="NESTED"
%>

<%
	for (int i=begin; i<=end; i++) {
		jspContext.setAttribute("avar", i);		
%>
	<jsp:doBody/>
<%
	}
%>