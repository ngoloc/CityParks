var map;
function initialize() {
  var mapOptions = {
    zoom: 8,
    center: new google.maps.LatLng(45.5907165,-122.5914212)
  };
  map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);
      
  var image = 'images/beachflag.png';
  var newLatLng = new google.maps.LatLng(45.5907165,-122.5914212);
  var beachMarker = new google.maps.Marker({
      position: newLatLng,
      map: map,
      icon: image
  });
  
  //send ajax to update parks
  $.post("/apis/getParks", function(data){
  	  for(key in data){
  	  	var park = data[key];
  		var newLatLng = new google.maps.LatLng(park.lat, park.lon);
  		var marker = new google.maps.Marker({
		        position: newLatLng,
		        map: map,
		        title: 'Hello World!'
		});
	  }
  });
}
$( document ).ready(function() {
	google.maps.event.addDomListener(window, 'load', initialize);
});

