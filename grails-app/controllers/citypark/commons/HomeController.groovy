package citypark.commons
import com.citypark.util.CityParkUtility;

import groovyx.net.http.HTTPBuilder
import groovy.json.JsonSlurper

class HomeController {
	def index(){
		render(view: 'index',  model: [])
	}
}
