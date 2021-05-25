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
                <h1>Green Point</h1>

                <div class="row justify-content-md-center">
                    <div class="card" style="width:90%">
                        <c:if test="${greenPoint.statut eq 'actif'}">
                        <img class="card-img-top" style="object-fit: cover;max-height:400px"
                             src="/images/photos_avant/${greenPoint.idGreenPoint}/${greenPoint.photo_avant}"
                             alt="Card image">
                        </c:if>
                        <c:if test="${greenPoint.statut eq 'nettoyé'}">
                            <div class="img-comp-container card-img-top">
                                <div class="img-comp-img">
                                    <img src="/images/photos_apres/${greenPoint.idGreenPoint}/${greenPoint.photo_apres}" style="object-fit: cover;height:400px">
                                </div>
                                <div class="img-comp-img img-comp-overlay">
                                    <img src="/images/photos_avant/${greenPoint.idGreenPoint}/${greenPoint.photo_avant}" style="object-fit: cover;height:400px">
                                </div>
                            </div>
                        </c:if>
                        <div class="card-body">
                            <h4 class="card-title">Présentation du GreenPoint</h4>
                            <p class="card-text">${greenPoint.description}</p>
                            <div class="btn-group">
                                <a href="#" class="btn btn-primary nav-item">Nettoyer ce GreenPoint</a>
                                <a href="green-point/delete?ref=${greenPoint.idGreenPoint}"
                                   class="btn btn-warning nav-item">Supprimer ce GreenPoint</a>
                            </div>
                        </div>
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
                        <%@include file="derniersMessages.jsp" %>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<script>
    initComparisons();
    function initComparisons() {
        var x, i;
        /*find all elements with an "overlay" class:*/
        x = document.getElementsByClassName("img-comp-overlay");
        for (i = 0; i < x.length; i++) {
            /*once for each "overlay" element:
            pass the "overlay" element as a parameter when executing the compareImages function:*/
            compareImages(x[i]);
        }
        function compareImages(img) {
            var slider, img, clicked = 0, w, h;
            /*get the width and height of the img element*/
            w = img.offsetWidth;
            h = img.offsetHeight;
            /*set the width of the img element to 50%:*/
            img.style.width = (w / 2) + "px";
            /*create slider:*/
            slider = document.createElement("DIV");
            slider.setAttribute("class", "img-comp-slider");
            /*insert slider*/
            img.parentElement.insertBefore(slider, img);
            /*position the slider in the middle:*/
            slider.style.top = (h / 2) - (slider.offsetHeight / 2) + "px";
            slider.style.left = (w / 2) - (slider.offsetWidth / 2) + "px";
            /*execute a function when the mouse button is pressed:*/
            slider.addEventListener("mousedown", slideReady);
            /*and another function when the mouse button is released:*/
            window.addEventListener("mouseup", slideFinish);
            /*or touched (for touch screens:*/
            slider.addEventListener("touchstart", slideReady);
            /*and released (for touch screens:*/
            window.addEventListener("touchend", slideFinish);
            function slideReady(e) {
                /*prevent any other actions that may occur when moving over the image:*/
                e.preventDefault();
                /*the slider is now clicked and ready to move:*/
                clicked = 1;
                /*execute a function when the slider is moved:*/
                window.addEventListener("mousemove", slideMove);
                window.addEventListener("touchmove", slideMove);
            }
            function slideFinish() {
                /*the slider is no longer clicked:*/
                clicked = 0;
            }
            function slideMove(e) {
                var pos;
                /*if the slider is no longer clicked, exit this function:*/
                if (clicked == 0) return false;
                /*get the cursor's x position:*/
                pos = getCursorPos(e)
                /*prevent the slider from being positioned outside the image:*/
                if (pos < 0) pos = 0;
                if (pos > w) pos = w;
                /*execute a function that will resize the overlay image according to the cursor:*/
                slide(pos);
            }
            function getCursorPos(e) {
                var a, x = 0;
                e = e || window.event;
                /*get the x positions of the image:*/
                a = img.getBoundingClientRect();
                /*calculate the cursor's x coordinate, relative to the image:*/
                x = e.pageX - a.left;
                /*consider any page scrolling:*/
                x = x - window.pageXOffset;
                return x;
            }
            function slide(x) {
                /*resize the image:*/
                img.style.width = x + "px";
                /*position the slider:*/
                slider.style.left = img.offsetWidth - (slider.offsetWidth / 2) + "px";
            }
        }
    }
</script>
<%@include file="footer.jsp" %>