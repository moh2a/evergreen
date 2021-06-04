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
                <h1 class="titres">Forum</h1>
                <nav class="navbar">
                    <button type="button" onclick="toggleFormulaire()" class="btn bouton-evergreen">Nouveau sujet</button>
                </nav>
                <form style="display: none;" id="sujetForm" class="needs-validation" novalidate method="POST" action="sujet">
                    <div class="form-group">
                        <label for="titre">Titre</label>
                        <input name="titre" type="text" class="form-control" id="titre" placeholder="Entrer un titre" maxlength="100" required>
                    </div>
                    <div class="form-group">
                        <label for="sujet">Sujet</label>
                        <textarea name="sujet" type="text" class="form-control" id="sujet" placeholder="sujet ... " maxlength="500" required></textarea>
                    </div>
                    <input type="hidden" name="idUser" value="${userId}" required>
                    <button type="submit" class="btn btn-success">Valider</button>
                </form>
                <h2>Liste des sujets : </h2>
                <c:forEach var="sujet" items="${sujets}">
                <div class="card text-white bg-dark">
                    <div class="card-body">
                        <h4 class="card-title">${sujet.titre}</h4>
                        <p class="reponseUser">Par : ${sujet.user.firstName} ${sujet.user.lastName}</p>
                        <a class="btn bouton-evergreen" href="sujet?ref=${sujet.idSujet}" class="card-link">Voir</a>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>

        <%@include file="widgets.jsp" %>
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