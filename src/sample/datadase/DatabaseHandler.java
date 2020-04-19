package sample.datadase;

import sample.User;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Maks
 * 18.04.2020.
 */
public class DatabaseHandler extends Configs {
    Connection dbConnection;
    private static final String connectionString = "jdbc:mysql://localhost:3306/javafx?useSSL=false";
//    private static final String insert1 = "INSERT INTO users (firstname, lastname, username, password, location, gender) VALUES (?, ?, ?, ?, ?, ?)";

    public Connection getDbConnection() throws ClassNotFoundException,  IllegalAccessException {

//            Class.forName("com.mysql.jdbc.Driver");

        try {
            dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dbConnection;
    }

    public void signUpUser(User user){
        String insert = "INSERT INTO " + Const.USER_TABLE +
                "(" + Const.USERS_FIRSNAME + "," + Const.USERS_LASTNAME + "," +
                Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + "," + Const.USERS_LOCATION + ","
                + Const.USERS_GENDER + ")"
                + "VALUES(?,?,?,?,?,?)";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setString(1, user.getFirstName());
            prSt.setString(2, user.getLastName());
            prSt.setString(3, user.getUserName());
            prSt.setString(4, user.getPassword());
            prSt.setString(5, user.getLocation());
            prSt.setString(6, user.getGender());

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
