<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<span class="titres">Derniers messages du forum</span>
<ul>
    <c:forEach var="message" items="${messages}">
        <li>
            ${message.message}
            <p class="card-text">
                <small class="text-muted">
                    <fmt:formatDate value="${message.getUpdatedAt()}" pattern="dd/MM/yyyy HH:mm" />
                </small>
            </p>
        </li>
    </c:forEach>
</ul>

<p class="card-text"><small class="text-muted"><a href="forum">Accéder au forum</a></small></p>