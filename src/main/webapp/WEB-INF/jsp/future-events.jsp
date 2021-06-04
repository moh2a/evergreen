<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="card   " style="width: 100%; background-color: #3ff992; border-color: #3ff992">
    <h6 class=" titres">Evènements à venir</h6>
    <ul class="list-group list-group-flush" id="listeEvents">
    </ul>
    <p class="card-text"><small class="text-muted"><a href="events">Accéder aux évènements</a></small></p>
</div>
<script>
    $(document).ready(function(){
        $.ajax({
            url : 'events-a-venir', // La ressource ciblée
            type :'GET',
            success: function (data) {
                reponse=data;
                data.forEach(element => {
                    let fullDate = new Date(element.date);
                    let jour = fullDate.getDate() + "";
                    let mois = (fullDate.getMonth() + 1) + "";
                    let annee = fullDate.getFullYear() + "";
                    let heure = fullDate.getHours() + "";
                    let minutes = fullDate.getMinutes() + "";
                    let seconde = fullDate.getSeconds() + "";
                   
                    let displayDate = jour + "/" + mois + "/" + annee + " " + heure + ":" + minutes + ":" + seconde;
                    
                    $("#listeEvents").append("<li class='list-group-item'>"+ element.eventName +"<p class='card-text'><small class='text-muted'>"+ displayDate+" </small></p></li>");              
               	});
                return true;
            }
        });
    });

</script>