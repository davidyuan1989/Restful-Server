package br.com.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.restful.model.Driver;
import br.com.restful.model.Passenger;
import br.com.restful.factory.ConnectionFactory;

public class RestfulDAO {
	public List<Driver> findAllDriver() {
		List<Driver> list = new ArrayList<Driver>();
		Connection c = null;
		String sql = "SELECT * FROM driver ORDER BY driver";
		try {
			c = ConnectionFactory.getConnection();
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				list.add(processDriverRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.close(c);
		}
		return list;
	}

	public List<Passenger> findPassengerByDriver(String driver) {
		List<Passenger> list = new ArrayList<Passenger>();
		Connection c = null;
		String sql = "SELECT * FROM passenger WHERE driver = ? ";
		try {
			c = ConnectionFactory.getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, driver);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(processPassengerRow(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.close(c);
		}
		return list;
	}

	public Driver createDriver(Driver driver) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionFactory.getConnection();
			ps = c.prepareStatement("INSERT INTO driver (driver, licenceNumber, radius, waitTime, description, longitude, latitude, maxPassengers) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, driver.getDriver());
			ps.setString(2, driver.getLicenceNumber());
			ps.setDouble(3, driver.getRadius());
			ps.setInt(4, driver.getWaitTime());
			ps.setString(5, driver.getDescription());
			ps.setDouble(6, driver.getLongitude());
			ps.setDouble(7, driver.getLatitude());
			ps.setInt(8, driver.getMaxPassenger());
			ps.executeUpdate();
			// ResultSet rs = ps.getGeneratedKeys();
			// rs.next();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.close(c);
		}
		return driver;
	}
	
	public Passenger createPassenger(String driver, Passenger passenger) {
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionFactory.getConnection();
			ps = c.prepareStatement("INSERT INTO passenger (driver, name, phone, description, longitude, latitude) VALUES (?, ?, ?, ?, ?, ?)");
			ps.setString(1, driver);
			ps.setString(2, passenger.getName());
			ps.setString(3, passenger.getPhone());
			ps.setString(4, passenger.getDescription());
			ps.setDouble(5, passenger.getLongitude());
			ps.setDouble(6, passenger.getLatitude());
			ps.executeUpdate();
			// ResultSet rs = ps.getGeneratedKeys();
			// rs.next();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.close(c);
		}
		return passenger;
	}

	public boolean remove(int id) {
		Connection c = null;
		try {
			c = ConnectionFactory.getConnection();
			PreparedStatement ps = c
					.prepareStatement("DELETE FROM driver WHERE id=?");
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			return count == 1;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.close(c);
		}
	}

	protected Driver processDriverRow(ResultSet rs) throws SQLException {
		Driver driver = new Driver(rs.getString("driver"),
				rs.getString("licenceNumber"), rs.getDouble("radius"),
				rs.getInt("waitTime"), rs.getString("description"),
				rs.getDouble("longitude"), rs.getDouble("latitude"),
				rs.getInt("maxPassengers"));
		return driver;
	}
	
	protected Passenger processPassengerRow(ResultSet rs) throws SQLException {
		Passenger passenger = new Passenger(rs.getString("name"),
				rs.getString("phone"), rs.getString("description"),
				rs.getDouble("longitude"), rs.getDouble("latitude"));
		return passenger;
	}
}
