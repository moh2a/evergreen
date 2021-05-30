<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"/>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container-fluid">
    <div class="row justify-content-md-center">
        <div class="col-xl-2 col-lg-2 col-xs-12 px-1 ">
            <%@include file="navigation.jsp" %>
        </div>
        <div class="col-xl-7 col-lg-8 col-xs-12 px-1">
            <div class="boite-simple">
                <div class="card border-success">
                    <div class="card-body">
                        <h4 class="card-title titres">${sujet.titre}</h4>
                        <p class="card-text">${sujet.sujet}</p>
                        <p class="card-text reponseUser"><small class="reponseUser">${sujet.user.firstName} ${sujet.user.lastName}</small></p>
                        <p class="card-text"><small class="text-muted">${sujet.getCreatedAt()}</small></p>
                        <div class="btn-group">
                            <c:if test="${ userRole eq 'Administrateur' || userId == sujet.user.id}">
                                <a href="sujet/delete?ref=${sujet.idSujet}"
                                   class="btn btn-warning nav-item">Supprimer ce sujet</a>
                            </c:if>
                        </div>
                        <h4>Réponses : </h4>
                        <c:forEach var="reponse" items="${sujet.getMessages()}">
                            <div class="card border-success">
                                <div class="card-body">
                                    <div class="container-fluid">
                                        <div class="row">
                                            <div class="col-sm-2">
                                                <p class="reponseUser">${reponse.getUser().getFirstName()} ${reponse.getUser().getLastName()}</p>
                                            </div>
                                            <div class="col-sm-8">
                                                <p class="card-text">${reponse.getMessage()}</p>
                                                <p class="card-text">
                                                    <small class="text-muted">
                                                        <fmt:formatDate value="${reponse.getUpdatedAt()}" pattern="dd/MM/yyyy HH:mm" />
                                                    </small>
                                                </p>
                                            </div>
                                            <div class="col-sm-2">
                                                <div class="btn-group">
                                                    <c:if test="${ userRole eq 'Administrateur' || userId == reponse.getIdUser()}">
                                                        <a href="message/delete?ref=${reponse.getIdMessage()}"
                                                           class="btn btn-warning nav-item">Supprimer</a>
                                                    </c:if>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <button id="showButton" type="button" onclick="showFormulaire()" class="btn bouton-evergreen">Répondre</button>
                <button id="hideButton" style="display: none;" type="button" onclick="hideFormulaire()" class="btn btn-secondary">Annuler</button>
                <form style="display: none;" id="reponseForm" class="needs-validation" novalidate method="POST" action="message?ref=${sujet.idSujet}">
                    <div class="form-group">
                        <label for="message">Message</label>
                        <input name="message" type="text" class="form-control" id="message" placeholder="Entrer un message" maxlength="255" required>
                    </div>
                    <input type="hidden" name="idUser" value="${userId}" required>
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
<script>
    (function() {
        'use strict';
        window.addEventListener('load', function() {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function(form) {
                form.addEventListener('submit', function(event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
    function showFormulaire(){
        var x = document.getElementById("reponseForm");
        var y = document.getElementById("showButton");
        var z = document.getElementById("hideButton");
        x.style.display = "block";
        z.style.display = "block";
        y.style.display = "none";
    }
    function hideFormulaire(){
        var x = document.getElementById("reponseForm");
        var y = document.getElementById("showButton");
        var z = document.getElementById("hideButton");
        x.style.display = "none";
        z.style.display = "none";
        y.style.display = "block";

    }
    function toggleFormulaire(){
        var x = document.getElementById("sujetForm");
        if (x.style.display === "none") {
            x.style.display = "block";
        } else {
            x.style.display = "none";
        }
    }
</script>
<%@include file="footer.jsp" %>