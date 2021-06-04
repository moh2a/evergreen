<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp" />
<div class="container-fluid">
	<div class="row justify-content-md-center">
		<div class="col-xl-2 col-lg-2 col-xs-12 px-1 ">
			<%@include  file="navigation.jsp" %>
		</div>
		<div class="col-xl-7 col-lg-8 col-xs-12 px-1">
			<%@include  file="formulaireGP.jsp" %>
		</div>
		
		<%@include file="widgets.jsp" %>
		
	</div>
</div>
<!--<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/map.js"></script>-->
<%@include  file="footer.jsp" %>
