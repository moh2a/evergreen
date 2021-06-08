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
			<div class="boite-simple">
    <h1 class="titres">Profil</h1>
    
    <div class="info-profil">
     <img class= image-profil src="/assets/avatar1.jpg" />
     <div class="nom" >${firstName} &#32; ${lastName}</div>
     <div>${birthDate}</div>
     
	<c:forEach var="greenPoint" items="${greenPoints}">
     <p>Green Points : ${greenPoint.getIdGreenPoint()} ${greenPoint.getStatut()}</p>
	</c:forEach>
     
     
     <nav class="p1" >
              <button type="button" onclick="#" class="btn bouton-evergreen">Editer le profil</button>
     </nav>
     </div>
    </div>
		</div>
	
		<%@include file="widgets.jsp" %>
		
	</div>
</div>
<%@include  file="footer.jsp" %>