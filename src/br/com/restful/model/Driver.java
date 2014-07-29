package br.com.restful.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Driver")
public class Driver {
	
	private String driver;
	private String licenceNumber;
	private double radius;
	private int waitTime;
	private String description;
	private Position pos;
	private int maxPassenger;
	
	public Driver(){
		
	}
	
	public Driver(String driver, String licenceNumber,
			double radius, int waitTime, String description, double longitude,
			double latitude, int maxPassenger){
		this.driver = driver;
		this.licenceNumber = licenceNumber;
		this.radius = radius;
		this.waitTime = waitTime;
		this.description = description;
		this.pos = new Position(longitude, latitude);
		this.maxPassenger = maxPassenger;
	}
	
	/**
	 * @return the licenceNumber
	 */
	public String getLicenceNumber() {
		return licenceNumber;
	}
	/**
	 * @param licenceNumber the licenceNumber to set
	 */
	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}
	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}
	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	/**
	 * @return the waitTime
	 */
	public int getWaitTime() {
		return waitTime;
	}
	/**
	 * @param waitTime the waitTime to set
	 */
	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the pos
	 */
	public Position getPos() {
		return pos;
	}
	/**
	 * @param pos the pos to set
	 */
	public void setPos(int longitude, int latitude) {
		this.pos.setLongitude(longitude);
		this.pos.setLatitude(latitude);
	}
	/**
	 * @return the driver
	 */
	public String getDriver() {
		return driver;
	}
	/**
	 * @param driver the driver to set
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}
	/**
	 * @return the maxPassenger
	 */
	public int getMaxPassenger() {
		return maxPassenger;
	}
	/**
	 * @param maxPassenger the maxPassenger to set
	 */
	public void setMaxPassenger(int maxPassenger) {
		this.maxPassenger = maxPassenger;
	}
	
}
