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
    <br>
    <hr>
    <div style="text-align: center; margin: 20px;padding: 10px;border-radius: 10px; border: solid #3ff992">
        <p>Ici vous pourrez participer activement à la protection de la nature. Retrouvez les différents green points à nettoyer sur la carte et gagnez des points en les nettoyant.</p>
        <p>Des récompenses seront attribuées aux meilleurs d'entre vous. Le classement est mis à jour activement</p>
        <p>Pour toutes informations complémentaires, n'hésitez pas à consulter le forum et créer un sujet s'il n'existe pas déjà.</p>
        <p>Des évènements seront organisés au fil du temps pour pouvoir nous rencontrer et participer à des sujets écologiques</p>
    </div>
</div>