<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="boite-simple">
    <h1 class="titres">Accueil</h1>
    <h2 class="titres">Trouver des GreenPoints à proximité</h2>
    <div class="mapConteneur box">
        <jsp:include page="listGreenPoint.jsp">
            <jsp:param name="greenPoints" value="{$greenPoints}" />
            <jsp:param name="mode" value="liste" />
        </jsp:include>
    </div>
    <h2 class="titres">Derniers articles du blog</h2>
</div>