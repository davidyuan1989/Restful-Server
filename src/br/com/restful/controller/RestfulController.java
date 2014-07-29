package br.com.restful.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.restful.model.Driver;
import br.com.restful.model.Passenger;
import br.com.restful.dao.RestfulDAO;

public class RestfulController {

	RestfulDAO dao = new RestfulDAO();

	public String postDriver(String driver, String licenceNumber,
			double radius, int waitTime, String description, double longitude,
			double latitude, int maxPassenger) {
		Driver newDriver = new Driver(driver, licenceNumber, radius, waitTime,
				description, longitude, latitude, maxPassenger);
		newDriver = dao.createDriver(newDriver);
		return newDriver.getDriver();
	}

	public List<Passenger> getConfirmedPassengers(String driverName) {
		List<Passenger> list = dao.findPassengerByDriver(driverName);
		return list;
	}

	public String confirmedPassenger(String driverName, String name,
			String phone, String description, double longitude, double latitude) {
		Passenger newPassenger = new Passenger(name, phone, description,
				longitude, latitude);
		dao.createPassenger(driverName, newPassenger);
		return newPassenger.getName();
	}

	public List<Driver> getAvailableDriver(Double distance, double latitude,
			double longitude) {
		// Position pos = new Position(longitude, latitude);
		List<Driver> res = new ArrayList<Driver>();
		List<Driver> all = dao.findAllDriver();
		for (Driver driver : all) {
			double dis = calculateDistance(latitude, longitude, driver.getPos()
					.getLatitude(), driver.getPos().getLongitude());
			if(dis <= distance && dis <= driver.getRadius()){
				res.add(driver);
			}
		}
		return res;
	}

	public static double calculateDistance(double lat1, double lng1,
			double lat2, double lng2) {

		double earthRadius = 6371; //kilometers
	    double dLat = Math.toRadians(lat2-lat1);
	    double dLng = Math.toRadians(lng2-lng1);
	    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
	               Math.sin(dLng/2) * Math.sin(dLng/2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    float dist = (float) (earthRadius * c);

	    return dist;

	}
}
