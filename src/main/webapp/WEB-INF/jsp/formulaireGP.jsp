<div class="boite-simple">
    <h1></h1>
    Création d'un Green Point</h1>
    <div class="card">
        <div class="card-header">Formulaire</div>
        <div class="card-body">
            <form id="myform" method="POST" action="add-greenpoint" enctype="multipart/form-data" onsubmit="return checkphoto(this)">
                <div class="form-group">
                    <label for="Coordonnees">Coordonnées : cliquez sur la carte pour ajouter un marqueur</label>
                    <jsp:include page="listGreenPoint.jsp">
			            <jsp:param name="greenPoints" value="{$greenPoints}" />
            			<jsp:param name="mode" value="form" />
			        </jsp:include>
                    <div>
                        <button class="btn btn-primary" onClick="markerAtMyPosition()">Votre position</button>
                    </div>
                    <label for="latitude">Latitude : </label>
                    <input #lat id="lat" name="latitude" type="number" step="0.0001" class="form-control" id="latitude" required>
                    <label for="longitude">Longitude : </label>
                    <input #lng id="lng" name="longitude" type="number" step="0.0001" class="form-control" id="longitude" required>
                    <div class="valid-feedback">Valide.</div>
                    <div class="invalid-feedback">Veuillez renseigner un lieux s'il-vous-plait.</div>
                </div>
                <div class="form-group">
                    <label for="description">Description : </label>
                    <textarea type="text" name="description" class="form-control" placeholder="Description..." id="description" required></textarea>
                </div>
                <div class="form-group">
                    <label for="imageAvant">Image : </label>
                    <input id="imageAvant" name="photo_avant" type="file" class="form-control-file border" accept="image/png, image/jpeg" required>
                </div>
                <button type="submit" class="btn btn-success">Valider</button>
            </form>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCngiFaNOdhbpMTg2Bvj6q16K-RiaTbPjM&callback=initMap&libraries=&v=weekly" async></script>
--><script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
