package eren.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/celciustofahrenheit")
public class RESTServiceOne {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public static String convertCtoF() {

		return "<distanceservice>" + "celciustofahrenheit" + "</distanceservice>";
	}

	@Path("{param1}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public static String celciustofahrenheit(@PathParam("param1") Double a) {

		return "{ " + ((a *(1.8)) + 32) + " }";
		
	
	}


}