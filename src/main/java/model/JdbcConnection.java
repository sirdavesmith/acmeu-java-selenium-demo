package model;

import java.sql.*;

public class JdbcConnection {
    private String dbServerUrl;
    private String username;
    private String password;

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


    /**
     * Constructor of acmeu_popup_banners.JdbcConnection
     * Creates acmeu_popup_banners.JdbcConnection object and uses the ConfigManager to pull out username, password, and database information
     * @throws Exception
     */
    public JdbcConnection() throws  Exception {
        dbServerUrl = "jdbc:oracle:thin:@//oaklane2-scan:1521/lane2.acmeu.edu";
        username = "acmeuacmeu";
        password = "me_guess2";
    }

    /**
     * Public Function connectToDb
     * Opens up a connection using the dbServerUrl, username, and Password pulled from qa.properties
     * @throws Exception
     */
    public void connectToDb() throws Exception {
        // Step 1: Load the JDBC driver.             //Not necessary?
        //Class.forName("ojdbc6:11.2.0.3.0.jar");    //Not necessary?
        // Step 2: Establish the connection to the database.
        connection = DriverManager.getConnection(dbServerUrl, username, password);
    }

    /**
     * @param dbServerUrl
     * @param username
     * @param password
     * Opens up a connection using the dbServerUrl, username, and Password provided
     * @throws Exception
     */
    public void connectToDb(String dbServerUrl, String username, String password) throws Exception {
        // Step 1: Load the JDBC driver.
        Class.forName("com.oracle.jdbc.Driver");
        // Step 2: Establish the connection to the database.
        try {
            connection = DriverManager.getConnection(dbServerUrl, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param sqlQuery
     * Runs the query you pass it and stores the results in resultSet
     * @throws Exception
     */
    public void runQuery(String sqlQuery) throws Exception {
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery(sqlQuery);
        while (resultSet.next()) {
            String username = resultSet.getString("USERNAME");
            System.out.println(username);
        }
    }

    //Will use
    public void closeConnection() throws Exception{
        resultSet.close();
        statement.close();
        connection.close();
    }

    public static void oldConnection() {
        String host = null;
        String uName = null;
        String uPass = null;
        host = "jdbc:oracle:thin:@//oaklane2-scan:1521/lane2.acmeu.edu";
        uName = "acmeubanner";
        uPass = "me_guess2";
        try {
            Connection con = DriverManager.getConnection(host, uName, uPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method only works with ResultSets that have one row (it resets the ResultSet after finding data)
     * @param columnLabel Name of the column you would like to pull a String from
     * @return Returns a String if it can find the columnLabel, returns null if it cannot
     * @throws Exception
     */
    public String getStringFromColumnLabel(String columnLabel) throws Exception {
        while (resultSet.next()) {
            try {
                if (resultSet.findColumn(columnLabel) != -1)  {
                    String result = resultSet.getString(columnLabel);
                    resultSet.previous();
                    return result;
                }
            }
            catch (SQLException e) {
                return null;
            }
        }
        return null;
    }

    /**
     * Public Function connectToDb
     *
     * Accepts: One Variables
     * @param columnLabel  Name of the column you would like to pull an int from
     *
     * This method only works with ResultSets that have one row (it resets the ResultSet after finding data)
     *
     * @return Returns an int if it can find the columnLabel, returns -1 if it cannot
     * @throws Exception
     */
    public int getIntFromColumnLabel(String columnLabel) throws Exception {
        while (resultSet.next()) {
            try {
                if (resultSet.findColumn(columnLabel) != -1) {
                    int result = resultSet.getInt(columnLabel);
                    resultSet.previous();
                    return result;
                }
            }
            catch (SQLException e) {
                return -1;
            }
        }
        return -1;
    }
}
