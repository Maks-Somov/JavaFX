package sample.datadase;

import java.sql.*;

/**
 * Maks
 * 18.04.2020.
 */
public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void signUpUser(String firstname, String lastname, String userName, String password, String location, String gender){
        String insert = "INSERT INTO" + Const.USER_TABLE + "(" + Const.USERS_FIRSNAME + "," + Const.USERS_LASTNAME + "," +
                Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + "," + Const.USERS_LOCATION + "," + Const.USERS_GENDER + ")" +
                "VALUES(?,?,?,?,?,?)";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setString(1, firstname);
            prSt.setString(2, lastname);
            prSt.setString(3, userName);
            prSt.setString(4, password);
            prSt.setString(5, location);
            prSt.setString(6, gender);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
