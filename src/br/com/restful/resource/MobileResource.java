package br.com.restful.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.restful.controller.RestfulController;
import br.com.restful.model.Driver;
import br.com.restful.model.Passenger;


@Path("/mobile")
public class MobileResource {

	RestfulController controller = new RestfulController();

	//http://localhost:8080/Restful/mobile/postDriver?driver=david&licenceNumber=213&radius=1000&waitTime=123&description=123123&longitude=54253.00&latitude=500359.00&maxPassenger=5
	@GET
	@Path("/postDriver")
	public String postDriver(@QueryParam("driver") String driver,
			@QueryParam("licenceNumber") String licenceNumber,
			@QueryParam("radius") double radius,
			@QueryParam("waitTime") int waitTime,
			@QueryParam("description") String description,
			@QueryParam("longitude") double longitude,
			@QueryParam("latitude") double latitude,
			@QueryParam("maxPassenger") int maxPassenger) {
		return controller.postDriver(driver, licenceNumber, radius, waitTime,
				description, longitude, latitude, maxPassenger);
	}

	//http://localhost:8080/Restful/mobile/getConfirmedPassengers?driver=david
	@GET
	@Path("/getConfirmedPassengers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Passenger>  postDriver(@QueryParam("driver") String driver) {
		List<Passenger> list = controller.getConfirmedPassengers(driver);
		return list;
	}

	//http://localhost:8080/Restful/mobile/confirmedPassengers?driver=david&name=test&description=123123&phone=123123&longitude=123.123&latitude=123.123
	@GET
	@Path("/confirmedPassengers")
	public String confirmedPassenger(@QueryParam("driver") String driver,
			@QueryParam("name") String name,
			@QueryParam("description") String description,
			@QueryParam("phone") String phone,
			@QueryParam("longitude") double longitude,
			@QueryParam("latitude") double latitude) {
		return controller.confirmedPassenger(driver, name, phone, description,
				longitude, latitude);
	}
	
	//http://localhost:8080/Restful/mobile/getAvailableDriver?distance=1000&latitude=583838&longitude=0030412
	@GET
	@Path("/getAvailableDriver")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Driver>  postDriver(@QueryParam("distance") Double distance,
			@QueryParam("longitude") double longitude,
			@QueryParam("latitude") double latitude) {
		List<Driver> list = controller.getAvailableDriver(distance, latitude, longitude);
		return list;
	}
	
}
