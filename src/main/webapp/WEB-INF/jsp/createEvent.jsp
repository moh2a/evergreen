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
		    
		<form style="display: none;" id="sujetForm" class="needs-validation" novalidate method="POST" action="sujet">
             <div class="form-group">
                 <label for="titre">Titre</label>
                 <input name="titre" type="text" class="form-control" id="titre" placeholder="Entrer un titre" maxlength="100" required>
             </div>
             <div class="form-group">
                 <label for="sujet">Sujet</label>
                 <textarea name="sujet" type="text" class="form-control" id="sujet" placeholder="sujet ... " maxlength="500" required></textarea>
             </div>
             <button type="submit" class="btn btn-success">Valider</button>
         </form>
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