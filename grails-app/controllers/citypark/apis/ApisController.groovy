package citypark.apis
import com.citypark.util.CityParkUtility;

import grails.converters.JSON
import groovyx.net.http.HTTPBuilder
import groovy.json.JsonSlurper

class ApisController {
	def getParks(){
		def ua_lat = 45.5907165
		def ua_lon = -122.5914212
		def http = new HTTPBuilder('http://api.civicapps.org')
 
		def data = http.get( path : '/parks' )
		def ret = []
		for(cityPark in data['results']){
			if(cityPark['amenities']!=null && cityPark['amenities'].contains("basketball court")){
				def lat = cityPark['loc'].lat
				def lon = cityPark['loc'].lon
				if(CityParkUtility.distance(lat,lon,ua_lat,ua_lon,(char)'M')<=10.0)
					ret.push([lat:lat, lon:lon])
			}
		}
		render ret as JSON
	}
}
