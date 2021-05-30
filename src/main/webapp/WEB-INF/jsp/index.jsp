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
			<%@include  file="accueil.jsp" %>
		</div>
		
		<div class="col-xl-2 col-lg-2 col-md-12 col-sm-12 px-1">
			<div class="sticky-top container-fluid">
				<div class="row">
					<div class="col-lg-12 col-md-4 col-sm-4 boite-simple px-1">
						<span class="titres">Evènements à venir</span>
					</div>
					<div class="col-lg-12 col-md-4 col-sm-4 boite-simple px-1">
						<%@include  file="best-users.jsp" %>
					</div>
					<div class=" col-lg-12 col-md-4 col-sm-4 boite-simple px-1">
						<%@include  file="derniersMessages.jsp" %>
					</div>
				</div>
				
			</div>	
		</div>
	</div>
</div>
<%@include  file="footer.jsp" %>