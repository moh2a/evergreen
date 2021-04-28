var map;
	var prev_infowindow =false; 
	let markerPosition;
	let iconPosition; 
	let marker;
	function initMap() {
	  map = new google.maps.Map(document.getElementById("map"), {
	    center: { lat: 48.858034, lng: 2.345868 },
	    zoom: 12,
	  });
	  this.marker = new google.maps.Marker({
  	    position: { lat: 0, lng: 0 },
  	    map: map,
  	    label:'GP',
	  });
	  map.addListener('click',(x) => {
		  map.setCenter(x.latLng);
		  $("#lat").val(Math.round(x.latLng.lat() * 10000) / 10000);
		  $("#lng").val(Math.round(x.latLng.lng() * 10000) / 10000);
		  console.log('lll',x.latLng.lat());
		  if(map.getZoom()<15){
			  map.setZoom(14); 
		  }
		  this.marker.setPosition(x.latLng);
		  });
	  this.initPosition();
	  const centerControlDiv = document.createElement("div");
	  CenterControl(centerControlDiv, map);
	  map.controls[google.maps.ControlPosition.RIGHT_BOTTOM].push(centerControlDiv);
	  
	}
	function checkphoto(e){
		var validFileExtensions = [".jpg", ".jpeg", ".bmp", ".gif", ".png"];
		console.log("qqc",$('#imageAvant').val());
		return false;
		
	}
	function markerAtMyPosition(){
		if (navigator.geolocation) {
		      navigator.geolocation.getCurrentPosition(
		        (position) => {
		          const pos = {
		            lat: position.coords.latitude,
		            lng: position.coords.longitude,
		          };
				  $("#lat").val(Math.round(pos.lat * 10000) / 10000);
				  $("#lng").val(Math.round(pos.lng * 10000) / 10000);
		          this.marker.setPosition(pos);
		          map.setCenter(pos);
		          
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
	function initPosition(){
		iconPosition= {
			    url: 'assets/position.svg', // url
			    scaledSize: new google.maps.Size(25, 25), // scaled size
			    origin: new google.maps.Point(0,0), // origin
		};
		  if (navigator.geolocation) {
		      navigator.geolocation.getCurrentPosition(
		        (position) => {
		          const pos = {
		            lat: position.coords.latitude,
		            lng: position.coords.longitude,
		          };
		          console.log('maposition', position);
		          map.setCenter(pos);
		          this.markerPosition = new google.maps.Marker({
		        	    position: pos,
		        	    map: map,
		        	    icon:iconPosition
		          });
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

	
	function geolocalisation(){
			iconPosition= {
			    url: 'assets/position.svg', // url
			    scaledSize: new google.maps.Size(25, 25), // scaled size
			    origin: new google.maps.Point(0,0), // origin
		};
	    if (navigator.geolocation) {
	        navigator.geolocation.getCurrentPosition(
	          (position) => {
	            const pos = {
	              lat: position.coords.latitude,
	              lng: position.coords.longitude,
	            };
	            map.panTo(pos);
	            map.setZoom(15);
	            this.markerPosition.setPosition=pos;
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
	function CenterControl(controlDiv, map) {
	    // Set CSS for the control border.
	    const controlUI = document.createElement("div");
	    const icon = document.createElement("i");
	    icon.innerHTML = "gps_fixed";
	    icon.className="material-icons";
	    controlUI.style.backgroundColor = "#fff";
	    controlUI.style.border = "2px solid #fff";
	    controlUI.style.borderRadius = "3px";
	    controlUI.style.boxShadow = "0 2px 6px rgba(0,0,0,.3)";
	    controlUI.style.cursor = "pointer";
	    controlUI.style.marginRight = "9px";
	    controlUI.style.width = "38px";
	    //controlUI.style.marginBottom = "22px";
	    controlUI.style.textAlign = "center";
	    controlUI.title = "Click to recenter the map";
	    controlUI.appendChild(icon);
	    controlDiv.appendChild(controlUI);
	    // Set CSS for the control interior.
	    const controlText = document.createElement("div");
	    controlText.style.color = "rgb(25,25,25)";
	    controlText.style.fontFamily = "Roboto,Arial,sans-serif";
	    controlText.style.fontSize = "16px";
	    controlText.style.lineHeight = "38px";
	    controlText.style.paddingLeft = "5px";
	    controlText.style.paddingRight = "5px";
	    //controlText.innerHTML = "Center Map";
	    controlUI.appendChild(controlText);
	    // Setup the click event listeners: simply set the map to Chicago.
	    controlUI.addEventListener("click", () => {
	      //map.setCenter(chicago);
	      this.geolocalisation();
	    });
	  }