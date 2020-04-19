package sample.datadase;

import org.omg.CORBA.CODESET_INCOMPATIBLE;
import sample.User;
import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


/**
 * Maks
 * 18.04.2020.
 */
public class DatabaseHandler extends Configs {
    Connection dbConnection;
//    private static final String connectionString = "jdbc:mysql://localhost:3306/javafx?useSSL=false";
//    private static final String insert1 = "INSERT INTO users (firstname, lastname, username, password, location, gender) VALUES (?, ?, ?, ?, ?, ?)";

    public Connection getDbConnection() throws ClassNotFoundException {
        String connectionString = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
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
        }
    }

        public ResultSet getUser(User user){
            ResultSet resSet = null;

            String select = "SELECT * FROM "+Const.USER_TABLE + " WHERE " + Const.USERS_USERNAME + "=? AND " + Const.USERS_PASSWORD + "=?";

            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(select);

                prSt.setString(1, user.getUserName());
                prSt.setString(2, user.getPassword());

                resSet = prSt.executeQuery();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            return resSet;
    }

}
