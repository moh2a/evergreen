<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="container-fluid">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-6">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text bouton-evergreen"><i class="fa fa-map-marker"></i></span>
                    </div>
                    <input type="text" id="adresse" class="form-control" placeholder="Adresse du green point">
                    <div class="input-group-append">
                        <button onclick="getCoordonnees()" class="input-group-text bouton-evergreen">Rechercher</button>
                    </div>
                </div>
            </div>
            <c:if test="${param.mode eq 'liste'}">
                <div class="col-lg-6">
                    <div>
                        <a class="btn bouton-evergreen" style="width: 100%" href="add-greenpoint">Créer un Greenpoint</a>
                    </div>
                </div>
            </c:if>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row">
            <c:set var="mode" scope="session" value="${param.mode}"/>
            <c:if test="${param.mode eq 'liste'}">
                <div class="col-md-6">
                    <div id="mapL" #mapL></div>
                </div>
                <div class="col-md-6 listGP">
                    <div class="row">

                        <c:forEach var="greenPoint" items="${requestScope.greenPoints}">
                            <div style="height: 100px;" class="d-flex">
                                    <div class="col-xl-1 align-self-center">
                                        <span class=" icone-localisation " style="color: #43F7B8;">
                                            <i class="fa fa-map-marker fa-2x"></i>
                                        </span>
                                    </div>
                                    <div class="col-xl-6 align-self-center">
                                        <span>
                                            <div class="line-clamp">
                                                <p class="titres">GreenPoint n°${greenPoint.idGreenPoint} - 2 points</p>
                                                <p class="truncate">${greenPoint.description}</p>
                                            </div>
                                        </span>
                                    </div>
                                    <div class="col-xl-4 align-self-center">
                                        <button class="bouton-evergreen participer">Participer</button>
                                    </div>
                            </div>
                        </c:forEach>

                    </div>
                </div>

            </c:if>

            <c:if test="${mode eq 'form'}">
                <div id="mapL" #mapL></div>
            </c:if>
        </div>
    </div>
</div>


<script src="https://unpkg.com/@googlemaps/markerclustererplus/dist/index.min.js"></script>


<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>
<script type="text/javascript" src="Leaflet.markercluster-1.4.1/dist/leaflet.markercluster.js"></script>
<script type="text/javascript">
    var map = L.map('mapL').setView([48.80952, 7.776818], 13).on('click', onClick);
    var markerGP = new L.Marker([48.80952, 7.776818]).addTo(map);
    var positionCoordonnees;

    function markerAtMyPosition() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(
                (position) => {
                    const pos = {
                        lat: position.coords.latitude,
                        lng: position.coords.longitude,
                    };
                    $("#lat").val(Math.round(pos.lat * 10000) / 10000);
                    $("#lng").val(Math.round(pos.lng * 10000) / 10000);
                    map.panTo(pos);

                },
                () => {
                    handleLocationError(true, infoWindow, map.getCenter());
                }
            );
        } else {
            // Browser doesn't support Geolocation
            handleLocationError(false, infoWindow, map.getCenter());
        }
    }

    function onClick(event) {
        var coordonnees = event.latlng;
        $("#lat").val(Math.round(coordonnees.lat * 10000) / 10000);
        $("#lng").val(Math.round(coordonnees.lng * 10000) / 10000);
        markerGP.setLatLng(coordonnees).update();
    }

    var markerRecherche;
    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '<a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a>',
        maxZoom: 18
    }).addTo(map);
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(
            (position) => {
                var pos = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude,
                };
                positionCoordonnees = pos;
                map.panTo(pos);
                var icon = L.Icon.extend({
                    options: {
                        iconSize: [20, 20],
                        iconAnchor: [10, 10],
                        popupAnchor: [0, 0]
                    }
                });
                var positionIcone = new icon({
                    iconUrl: 'assets/position.png'
                });
                var marker = L.marker([pos.lat, pos.lng], {icon: positionIcone}).addTo(map).bindPopup("<b>Vous êtes ici !</b>");
                markerGP.setLatLng([pos.lat, pos.lng]).update();

            },
            () => {
                handleLocationError(true, infoWindow, map.getCenter());
            }
        );
    } else {
        // Browser doesn't support Geolocation
        handleLocationError(false, infoWindow, map.getCenter());
    }
    var LeafIcon = L.Icon.extend({
        options: {
            iconSize: [38, 95],
            shadowSize: [50, 64],
            iconAnchor: [22, 94],
            shadowAnchor: [4, 62],
            popupAnchor: [-3, -76]
        }
    });
    var greenIcon = new LeafIcon({
        iconUrl: 'http://leafletjs.com/examples/custom-icons/leaf-green.png',
        shadowUrl: 'http://leafletjs.com/examples/custom-icons/leaf-shadow.png'
    });
    var markersCluster = new L.MarkerClusterGroup();

    <c:forEach var="greenPoint" items="${requestScope.greenPoints}">
    var latLng = new L.LatLng(parseFloat("${greenPoint.latitude}"), parseFloat("${greenPoint.longitude}"));
    var marker = new L.Marker(latLng, {icon: greenIcon}, {id: "${greenPoint.idGreenPoint}"}, {title: "GreenPoint n°" + "${greenPoint.idGreenPoint}"}).bindPopup("<h1>GreenPoint n°" + "${greenPoint.idGreenPoint}" + "</h1><a href=\"green-point?ref=${greenPoint.idGreenPoint}\">" + "En savoir plus" + "</a>");
    markersCluster.addLayer(marker);
    //locations.push({location:{lat:parseFloat("${greenPoint.latitude}"),lng:parseFloat("${greenPoint.longitude}")},id:"${greenPoint.idGreenPoint}", description:"${greenPoint.description}"});
    </c:forEach>

    map.addLayer(markersCluster);

    function getCoordonnees() {
        $.ajax({
            url: 'http://api.positionstack.com/v1/forward',
            data: {
                access_key: '0db4fbd0bc797d10db15c1d0d34d6493',
                query: $('#adresse').val(),
                limit: 1
            }
        }).done(function (data) {

            objet = data.data[0];

            $("#lat").val(Math.round(objet.latitude * 10000) / 10000);
            $("#lng").val(Math.round(objet.longitude * 10000) / 10000);
            var latLng = new L.LatLng(objet.latitude, objet.longitude);
            markerGP.setLatLng(latLng).update();
            map.panTo(latLng);
            return data;
        });
    }
</script>
