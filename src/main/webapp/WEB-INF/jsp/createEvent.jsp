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
		    
		<body id="contact-body">
        <c:if test="${confirmation}">
            <script async>
                window.alert("${confirmationMessage}");
            </script>
        </c:if>
        <c:if test="${errorId}">
            <script async>
                window.alert("${errorMessage}");
            </script>
        </c:if>

        <div id="contact-row-1">
            <div>
                <a href="events"><p class="back"><img src="assets/icon/arrow-left.svg" alt="back-icon" width="16px" /> Retour</p></a>
            </div>
        </div>

        <div id="contact-row-2">
            <div>
            	<span class="titre-partie">
                <h2> Nouvel Évènement </h2>
                </span>
                
                <form class="create-event" action="saveEvent" method="POST">
                    <input type="text" name="nom" id="nom-event" placeholder="Nom" required>
                    <textarea name="description" id="description-event" placeholder="Description" required></textarea>
                    <div id="date-loc">
                    <input type="date" name="date" id="date-event" required>
                    <input type="text" name="localisation" id="localisation-event" placeholder="Localisation" required>
					</div>
                    <input type="submit" value="Ajouter l'événement" id="submit-button" class="subutton"/>

                </form>
            </div>
        </div>
        </body>
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