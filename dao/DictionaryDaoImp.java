package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.config.Config;
import edu.javacourse.studentorder.domain.Street;
import edu.javacourse.studentorder.exception.DaoException;

import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class DictionaryDaoImp implements DictionaryDao {

    public static final  String GET_STREET = "SELECT street_code, street_name\n" +
            "FROM jc_street\n" +
            "WHERE UPPER(street_name) LIKE UPPER(?)";

    private Connection getConnection() throws SQLException, IOException {
        Connection con =  DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD));
        return con;
    }

    @Override
    public List<Street> findStreet(String pattern) throws DaoException {
         List<Street> result = new LinkedList<>();

        try(Connection con = getConnection();
            PreparedStatement stent = con.prepareStatement(GET_STREET)
        ) {
            stent.setString(1, "%"+ pattern + "%");
                ResultSet rs = stent.executeQuery();
                while (rs.next()) {
                    Street str = new Street(rs.getLong("street_code"), rs.getString("street_name"));
                    result.add(str);
                }
        } catch (SQLException | IOException ex){
            throw new DaoException(ex);
        }
        return result;
    }



}
