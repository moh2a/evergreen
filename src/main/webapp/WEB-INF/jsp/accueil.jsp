<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="boite-simple">
    <h1>Accueil</h1>
    <h2>Trouver des GreenPoints à proximité</h2>
    <div class="mapConteneur">
        <jsp:include page="listGreenPoint.jsp">
            <jsp:param name="greenPoints" value="{$greenPoints}" />
            <jsp:param name="mode" value="liste" />
        </jsp:include>
    </div>
    <h2>Derniers articles du blog</h2>
    <div>
        <a class="btn btn-primary" href="add-greenpoint">Créer un Greenpoint</a>
    </div>
</div>