<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<span>Derniers messages du forum</span>
<ul>
    <c:forEach var="message" items="${messages}">
        <li>
            <p>${message.message}</p>
            <p class="card-text"><small class="text-muted">${message.getUpdatedAt()}</small></p>
        </li>
    </c:forEach>
</ul>

<p class="card-text"><small class="text-muted"><a href="forum">Accéder au forum</a></small></p>