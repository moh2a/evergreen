<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!--<div style="margin-top: 20px;" id="listeUtilisateurs">
</div>-->
<div class="card " style="width: 100%; border-color: #d39e00; background-color: #d39e00;">
    <h6 class=" titres ">Meilleurs utilisateurs</h6>
    <ul class="list-group list-group-flush" id="listeUtilisateurs">
    </ul>
</div>
<script>
    $(document).ready(function(){
        $.ajax({
            url : 'best-users', // La ressource ciblée
            type :'GET',
            success: function (data) {
                reponse=data;
                let classement = "1er";
                let i = 1;
                data.forEach(element => {
                    //$("#listeUtilisateurs").append("<p class='gras '>"+element.firstName+"</p><p class='card-text'><small class='text-muted'>"+"<span class='gras reponseUser'>"+classement+"</span> : "+element.score+" points"+" </small></p>");
                    $("#listeUtilisateurs").append("<li class='gras list-group-item'>"+element.firstName+"<p class='card-text'><small class='text-muted'>"+"<span class='gras reponseUser'>"+classement+"</span> : "+element.score+" points"+" </small></p></li>");
                    i++;
                    classement= i +"ème";
                });

                return true;
            }
        });
    });

</script>