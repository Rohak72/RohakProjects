import javax.xml.transform.Result;
import java.sql.*;


public class Helper {
    private Connection connect = null;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private String username = "demouser";
    private String password = "csr24life";

    public Connection getConnection() throws ClassNotFoundException {
        if (connect == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                // Setup the connection with the DB
                connect = DriverManager
                        .getConnection("jdbc:mysql://localhost/demo?"
                                + "user=" + username + "&password=" + password);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connect;
    }

    public void getResult(String query, int ID) throws SQLException {
        preparedStatement = connect.prepareStatement(query + " WHERE id = " + ID);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            long cash_amt = resultSet.getLong("atm_cash");
            String user_name = resultSet.getString("user_name");
            int num_withdrawals = resultSet.getInt("num_withdrawals");
            int num_deposits = resultSet.getInt("num_deposits");
        }
    }

    public void writeMetaData() throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    public void addInformation(String name, long cash, int ID) throws ClassNotFoundException, SQLException {
        getConnection();
        resultSet.moveToInsertRow();
        resultSet.updateInt("atm_id", ID);
        resultSet.updateLong("atm_cash", cash);
        resultSet.updateString("user_name", name);

    }
}
