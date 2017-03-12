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

@Path("/distanceservice")
public class RESTServiceTwo {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String convertCtoF() {

		return "<distanceservice>" + "distancecalc" + "</distanceservice>";
	}

	@Path("{param1}/{param2}/{param3}/{param4}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String distancecalc(@PathParam("param1") Double a, @PathParam("param2") Double b,
			@PathParam("param3") Double c, @PathParam("param4") Double d) {

		Distance dist = new Distance();
		dist.setDistance(distanceKM(a, b, c, d));
		System.out.println(dist.getDistance());

		return "{ " + dist.getDistance() + " }";
	}

	public static double distanceKM(double lat1, double lon1, double lat2, double lon2) {
		double p = 0.017453292519943295; // Math.PI / 180

		double a = 0.5 - Math.cos((lat2 - lat1) * p) / 2
				+ Math.cos(lat1 * p) * Math.cos(lat2 * p) * (1 - Math.cos((lon2 - lon1) * p)) / 2;

		return 12742 * Math.asin(Math.sqrt(a));
	}

	public static double deg2rad(double deg) {
		return (deg * (Math.PI / 180.0));
	}

}