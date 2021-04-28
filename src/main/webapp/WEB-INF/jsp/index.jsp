<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp" />
<div class="container-fluid">
	<div class="row justify-content-md-center">
		<div class="col-xl-2 col-lg-2 col-xs-12 px-1 ">
			<%@include  file="../html/navigation.html" %>
		</div>
		<div class="col-xl-7 col-lg-8 col-xs-12 px-1">
			<div class="boite-simple">
				<h1>Accueil</h1>
				<h2>Trouver des GreenPoints � proximit�</h2>
				<div class="mapConteneur">
					<jsp:include page="listGreenPoint.jsp" >
						<jsp:param name="greenPoints" value="{$greenPoints}" />
					</jsp:include>
				</div>
				<h2>Derniers articles du blog</h2>
				<div>
					<a class="btn btn-primary" href="listGreenPoint.jsp">Voir les Greenpoints</a>
					<a class="btn btn-primary" href="GreenPointController?action=listGreenPoint">Voir les Greenpoints</a>
					<a class="btn btn-primary" href="newGreenPoint.html">Cr�er un Greenpoint</a>	
				</div>
			</div>
		</div>
		
		<div class="col-xl-2 col-lg-2 col-md-12 col-sm-12 px-1">
			<div class="sticky-top container-fluid">
				<div class="row">
					<div class="col-lg-12 col-md-4 col-sm-4 boite-simple px-1">
						<span>Ev�nements � venir</span>
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
<%@include  file="../html/footer.html" %>