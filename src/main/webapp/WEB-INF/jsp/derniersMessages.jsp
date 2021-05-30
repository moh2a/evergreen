<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="card border-light  " style="width: 100%; ">
    <h6 class=" titres">Derniers messages du forum</h6>
    <ul class="list-group list-group-flush" id="liste">
    </ul>
    <p class="card-text"><small class="text-muted"><a href="forum">Accéder au forum</a></small></p>
</div>
<script>
    $(document).ready(function(){
        $.ajax({
            url : 'last-messages', // La ressource ciblée
            type :'GET',
            success: function (data) {
                reponse=data;
                data.forEach(element => {
                    let fullDate = new Date(element.updatedAt);
                    let jour = fullDate.getDate() + "";
                    let mois = (fullDate.getMonth() + 1) + "";
                    let annee = fullDate.getFullYear() + "";
                    let heure = fullDate.getHours() + "";
                    let minutes = fullDate.getMinutes() + "";
                    let seconde = fullDate.getSeconds() + "";


                    let displayDate = jour + "/" + mois + "/" + annee + " " + heure + ":" + minutes + ":" + seconde;
                    $("#liste").append("<li class='list-group-item'>"+element.message+"<p class='card-text'><small class='text-muted'>"+ displayDate+" </small></p></li>");
                });
                return true;
            }
        });
    });

</script>