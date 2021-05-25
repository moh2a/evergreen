<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<span class="titres">Derniers messages du forum</span>
<ul id="liste">
</ul>

<p class="card-text"><small class="text-muted"><a href="forum">Accéder au forum</a></small></p>
<script>
    $(document).ready(function(){
        $.ajax({
            url : 'last-messages', // La ressource ciblée
            type :'GET',
            success: function (data) {
                reponse=data;
                data.forEach(element => {
                    $("#liste").append("<li>"+element.message+"<p class='card-text'><small class='text-muted'><fmt:formatDate value='${element.getUpdatedAt()}' pattern='dd/MM/yyyy HH:mm' /> </small></p></li>");
                });
                return true;
            }
        });
    });

</script>