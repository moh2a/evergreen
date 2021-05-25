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

		    <h1 class="titres">Évènements</h1>
		    	<span class="titre-partie">
		    	<h2>Évènements à venir</h2>
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
			  
			    	<button name="Participer" value="" class="subutton">
			    	<a class="textbutton" title="Cliquez pour participer à cet événement"> Participer </a> 
			    	</button>
		    	</div>
		    	
		    	</c:forEach>
		    
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
		    
			</div>	
		</div>
		
		<div class="col-xl-2 col-lg-2 col-md-12 col-sm-12 px-1">
			<div class="sticky-top container-fluid">
				<div class="row">
					<div class="col-lg-12 col-md-4 col-sm-4 boite-simple px-1">
						<span>Evènements à venir</span>
					</div>
					<div class="col-lg-12 col-md-4 col-sm-4 boite-simple px-1">
						<span>Meilleurs utilisateurs</span>
					</div>
					<div class=" col-lg-12 col-md-4 col-sm-4 boite-simple px-1">
						<span>Derniers messages du forum</span>
					</div>
				</div>
				
			</div>	
		</div>
	</div>
</div>
<%@include  file="footer.jsp" %>