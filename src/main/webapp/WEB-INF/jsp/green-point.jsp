<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>
<div class="container-fluid">
    <div class="row justify-content-md-center">
        <div class="col-xl-2 col-lg-2 col-xs-12 px-1 ">
            <%@include file="navigation.jsp" %>
        </div>
        <div class="col-xl-7 col-lg-8 col-xs-12 px-1">
            <div class="boite-simple">
                <h1>Green Point</h1>

                <div class="row justify-content-md-center">
                    <div class="card" style="width:90%">
                            <c:if test="${greenPoint.statut eq 'Actif'}">
                                <img class="card-img-top" style="object-fit: cover;max-height:400px"
                                     src="/images/photos_avant/${greenPoint.idGreenPoint}/${greenPoint.photo_avant}"
                                     alt="Card image">
                            </c:if>
                            <c:if test="${greenPoint.statut eq 'Nettoyé'}">
                                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                                    <ol class="carousel-indicators">
                                        <li data-target="#carouselExampleIndicators" style="height: 20px;" data-slide-to="0"
                                            class="active"></li>
                                        <li data-target="#carouselExampleIndicators" style="height: 20px;" data-slide-to="1"></li>
                                    </ol>
                                    <div class="carousel-inner" style="max-height: 400px;">
                                        <div class="carousel-item active">
                                            <img alt="Avant" class="d-block w-100"
                                                 src="/images/photos_avant/${greenPoint.idGreenPoint}/${greenPoint.photo_avant}" style="object-fit: cover;width:100%; max-height: 400px;">
                                        </div><!--style="object-fit: cover;width:100%"-->
                                        <div class="carousel-item">
                                            <img alt="Après" class="d-block w-100"
                                                 src="/images/photos_apres/${greenPoint.idGreenPoint}/${greenPoint.photo_apres}" style="object-fit: cover;width:100%;  max-height: 400px;">
                                        </div>
                                    </div>
                                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button"
                                       data-slide="prev">
                                        <span class="carousel-control-prev-icon" style="height: 40px;width: 40px;color: #fff;" aria-hidden="true"></span>
                                        <span class="sr-only">Précédent</span>
                                    </a>
                                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button"
                                       data-slide="next">
                                        <span class="carousel-control-next-icon" style="height: 40px;width: 40px;color: #fff;" aria-hidden="true"></span>
                                        <span class="sr-only">Suivant</span>
                                    </a>
                                </div>


                            </c:if>
                        <div class="card-body">
                            <h4 class="card-title">Présentation du GreenPoint</h4>
                            <p class="card-text">Description : ${greenPoint.description}</p>
                            <p class="card-text">Statut : ${greenPoint.statut}</p>
                            <p class="card-text">Créateur : ${utilisateur.firstName} ${utilisateur.lastName}</p>
                            <div class="btn-group">
                                <c:if test="${greenPoint.statut eq 'Actif'}">
                                    <a href="#" class="btn btn-primary nav-item">Participer</a>
                                </c:if>
                                <c:if test="${greenPoint.statut eq 'Réservé'}">
                                    <a href="#" class="btn btn-secondary nav-item">Annuler la participation</a>
                                    <a href="#" class="btn btn-success nav-item">Valider le nettoyage</a>
                                </c:if>
                                <c:if test="${userRole eq 'Administrateur'}">
                                    <a href="green-point/delete?ref=${greenPoint.idGreenPoint}"
                                       class="btn btn-warning nav-item">Supprimer ce GreenPoint</a>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div class="col-xl-2 col-lg-2 col-md-12 col-sm-12 px-1">
            <div class="sticky-top container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-4 col-sm-4 boite-simple px-1">
                        <span>Evènements à venir</span>
                    </div>
                    <div class="col-lg-12 col-md-4 col-sm-4 px-1">
                        <%@include  file="best-users.jsp" %>
                    </div>
                    <div class=" col-lg-12 col-md-4 col-sm-4 px-1">
                        <%@include file="derniersMessages.jsp" %>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<%@include file="footer.jsp" %>