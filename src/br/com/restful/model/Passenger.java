package br.com.restful.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Passenger")
public class Passenger {
	private String name;
	private String phone;
	private String description;
	private Position pos;
	
	public Passenger(){
		
	}
	
	public Passenger(String name, String phone, String description,
			double longitude, double latitude) {
		this.name = name;
		this.phone = phone;
		this.description = description;
		this.pos = new Position(longitude, latitude);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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
	
}
