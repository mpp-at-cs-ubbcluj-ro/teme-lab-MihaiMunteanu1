package ro.mpp2024;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CarsDBRepository implements CarRepository {

    private JdbcUtils dbUtils;


    private static final Logger logger = LogManager.getLogger();

    public CarsDBRepository(Properties props) {
        logger.info("Initializing CarsDBRepository with properties: {} ", props);
        dbUtils = new JdbcUtils(props);
    }

    @Override
    public List<Car> findByManufacturer(String manufacturerN) {
        logger.traceEntry("Manufacturer: {}", manufacturerN);
        Connection con = dbUtils.getConnection();
        List<Car> cars = new ArrayList<>();
        try(PreparedStatement preStmt = con.prepareStatement("SELECT * FROM Masini WHERE manufacturer = ?")){
            preStmt.setString(1, manufacturerN);
            try(ResultSet rs = preStmt.executeQuery()){
                while(rs.next()){
                    int id = rs.getInt("id");
                    String manufacturer = rs.getString("manufacturer");
                    String model = rs.getString("model");
                    int year = rs.getInt("year");
                    Car car = new Car(manufacturer, model, year);
                    car.setId(id);
                    cars.add(car);
                }
            }
        }
        catch (SQLException e) {
            logger.error(e);
            System.err.println(e.getMessage());
        }
        logger.traceExit();
        return cars;
    }

    @Override
    public List<Car> findBetweenYears(int min, int max) {
        logger.traceEntry("min: {} max: {}", min, max);
        Connection con = dbUtils.getConnection();
        List<Car> cars = new ArrayList<>();
        try(PreparedStatement preStmt = con.prepareStatement("SELECT * FROM Masini WHERE year > ? and year < ?")){
            preStmt.setInt(1, min);
            preStmt.setInt(2, max);
            try(ResultSet rs = preStmt.executeQuery()){
                while(rs.next()){
                    int id = rs.getInt("id");
                    String manufacturer = rs.getString("manufacturer");
                    String model = rs.getString("model");
                    int year = rs.getInt("year");
                    Car car = new Car(manufacturer, model, year);
                    car.setId(id);
                    cars.add(car);
                }
            }

        }
        catch (SQLException e) {
            logger.error(e);
            System.err.println(e.getMessage());
        }
        logger.traceExit();
        return cars;
    }

    @Override
    public void add(Car elem) {
        logger.traceEntry("saving task {} ", elem);
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("insert into Masini (manufacturer,model,year) values (?,?,?)")) {
            preStmt.setString(1, elem.getManufacturer());
            preStmt.setString(2, elem.getModel());
            preStmt.setInt(3, elem.getYear());
            int result = preStmt.executeUpdate();
            logger.trace("Saved {} instances", result);
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB" + e);
        }
        logger.traceExit("saving task {} ", elem);
    }

    @Override
    public void update(Integer integer, Car elem) {
        logger.traceEntry("update task {} ", elem);
        Connection con = dbUtils.getConnection();
        try (PreparedStatement preStmt = con.prepareStatement("update Masini set manufacturer = ?, model = ?, year = ? where id = ?")) {
            preStmt.setString(1, elem.getManufacturer());
            preStmt.setString(2, elem.getModel());
            preStmt.setInt(3, elem.getYear());
            preStmt.setInt(4, integer);

            preStmt.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB" + e);
        }
        logger.traceExit("update task {} ", elem);
    }

    @Override
    public Iterable<Car> findAll() {
        logger.traceEntry("findAll");
        Connection con = dbUtils.getConnection();
        List<Car> cars = new ArrayList<>();
        try (PreparedStatement preStmt = con.prepareStatement("select * from Masini")) {
            try (ResultSet result = preStmt.executeQuery()) {
                while (result.next()) {
                    int id = result.getInt("id");
                    String manufacturer = result.getString("manufacturer");
                    String model = result.getString("model");
                    int year = result.getInt("year");
                    Car car = new Car(manufacturer, model, year);
                    car.setId(id);
                    cars.add(car);
                }
            }
        }
        catch (SQLException e) {
                logger.error(e);
                System.err.println("Error DB " + e);
        }
        logger.traceExit(cars);
        return cars;
    }
}