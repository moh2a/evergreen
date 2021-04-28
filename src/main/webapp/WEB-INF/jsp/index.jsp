<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp" />
<div class="container-fluid">
	<div class="row justify-content-md-center">
		<div class="col-xl-2 col-lg-2 col-xs-12 px-1">
		<div class="boite-simple">
				<div class="logo">
					<img src="assets/LOGO-SITE.png" alt="logo" width="100" height="100">
				</div>
				<div>
					<ul class="fa-ul">
						<li><span class="fa-li"><i class="fa fa-home"></i></span><a href="#">Accueil</a></li>
						<li><span class="fa-li"><i class="fa fa-user"></i></span><a href="#">Profil</a></li>
						<li><span class="fa-li"><i class="fa fa-calendar"></i></span><a href="#">Evènements</a></li>
					</ul>
				</div>
				
			</div>
		</div>
		<div class="col-xl-7 col-lg-8 col-xs-12 px-1">
			<div class="boite-simple">
				<h1>Accueil</h1>
				<h2>Trouver des GreenPoints à proximité</h2>
				<div class="mapConteneur">
					<jsp:include page="listGreenPoint.jsp" >
						<jsp:param name="greenPoints" value="{$greenPoints}" />
					</jsp:include>
				</div>
				<h2>Derniers articles du blog</h2>
					<div>
						<a class="btn btn-primary" href="/evergreen/listGreenPoint.jsp">Voir les Greenpoints</a>
						<a class="btn btn-primary" href="/evergreen/GreenPointController?action=listGreenPoint">Voir les Greenpoints</a>
						<a class="btn btn-primary" href="/evergreen/newGreenPoint.html">Créer un Greenpoint</a>	
					</div>
				</div>
		</div>
		
		<div class="col-xl-2 col-lg-2 col-md-2 col-sm-12 px-1">
					<div class="boite-simple px-1">
						<span>Evènements à venir</span>
					</div>
					<div class="boite-simple px-1">
						<span>Meilleurs utilisateurs</span>
					</div>
					<div class="boite-simple px-1">
						<span>Derniers messages du forum</span>
					</div>
				</div>
		</div>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp" />