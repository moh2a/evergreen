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
                <h1>${article.titre}</h1>
                <div class="card" style="width:400px">
                    <img class="card-img-top" style="height:100%;"
                         src="/images/articles/${article.idArticle}/${article.image}"
                         alt="Card image">
                    <div class="card-body">
                        <h4 class="card-title">*description</h4>
                        <p class="card-text">${article.description}</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-xl-2 col-lg-2 col-md-12 col-sm-12 px-1">
            <div class="sticky-top container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-4 col-sm-4 boite-simple px-1">
                        <span>Evènements à venir</span>
                    </div>
                    <div class="col-lg-12 col-md-4 col-sm-4 boite-simple px-1">
                        <span>Meilleurs utilisateurs</span>
                    </div>
                    <div class=" col-lg-12 col-md-4 col-sm-4 boite-simple px-1">
                        <span>Derniers messages du forum</span>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>