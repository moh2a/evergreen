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
			<c:if test="${confirmation}">
	            <script async>
	                window.alert("${confirmationMessage}");
	            </script>
        	</c:if>
        	
		    <h1 class="titres">Évènements</h1>
			    
			    <c:if test="${isAdministrator}">
	                <button class="subutton">
	                	<a class="textbutton" title="Cliquez pour créer un évènement" href="create-event"> Nouvel Évènement </a>
	                </button>
	            </c:if>  
	                
		    	<span class="titre-partie">
		    		<h2> Évènements à venir</h2>
		    	</span>
		    	 
		    	<c:forEach var="event" items="${eventsAfter}">  
		    	<div class="event">
                    <div class="textevent">
                        <h3>${event.eventName}</h3>
                        <h4>${event.description}</h4>
                    </div>
                    
                 	<div class="localisation">
		            	<ul class="fa-ul">
		            <li><span class="fa-li"><i class="fa fa-map-pin"></i></span>
			    	<h4> ${event.localisation}</h4></li>
			    	<li><span class="fa-li"><i class="fa fa-calendar" aria-hidden="true"></i></span>
			    	<h4> ${event.date}</h4></li>
			    		</ul>
			    	</div>
			    	<c:set var="contains" value="false" />
					<c:forEach var="eventId" items="${eventsId}">
					  <c:if test="${eventId eq event.id}">
					    <c:set var="contains" value="true" />
					  </c:if>
					</c:forEach>
					
					<c:choose>
					<c:when test="${contains}">
					<button name="Départiciper" class="subutton">
						<a href="delete-participation?eventId=${event.id}" class="textbutton" title="Cliquez pour vous désinscrire"> Me désinscrire </a>
			    	</button>
			    	</c:when>
			    	
			    	<c:otherwise>
			    	<button name="Participer" class="subutton">
			    		<a href="participate?eventId=${event.id}" class="textbutton" title="Cliquez pour participer à cet événement"> Participer </a> 
			    	</button>
			    	</c:otherwise>
			    	</c:choose>
			    	<c:if test="${isAdministrator}">
			    		<a href="delete-event?eventId=${event.id}" class="delete-text" title="Cliquez pour supprimer l'évènement"> Supprimer </a>
		    		</c:if>
		    		
		    		
		    	</div>
		    	
		    	</c:forEach>
		    	<c:if test="${noEventAfter}">
		    		<p id="textMessage">${messageNoAfter}</p>
		    	</c:if>
		    
		    	<span class="titre-partie">
		    	<h2>Évènements passés</h2>
		    	</span>    
		    		
		    	<c:forEach var="event" items="${eventsBefore}">  
		    	<div class="event">
                    <div class="textevent">
                        <h3>${event.eventName}</h3>
                        <h4>${event.description}</h4>
                    </div>
                    
                 	<div class="localisation">
		            	<ul class="fa-ul">
		            <li><span class="fa-li"><i class="fa fa-map-pin"></i></span>
			    	<h4> ${event.localisation}</h4></li>
			    	<li><span class="fa-li"><i class="fa fa-calendar" aria-hidden="true"></i></span>
			    	<h4> ${event.date}</h4></li>
			    		</ul>
			    	</div>
			  
		    	</div>
		    	
		    	</c:forEach>
		    	
		    	<c:if test="${noEventBefore}">
		    		<p id="textMessage">${messageNoBefore}</p>
		    	</c:if>
		    	
			</div>	
		</div>
		
		<%@include file="widgets.jsp" %>
		
	</div>
</div>
<%@include  file="footer.jsp" %>