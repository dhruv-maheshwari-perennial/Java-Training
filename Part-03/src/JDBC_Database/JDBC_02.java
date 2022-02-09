package JDBC_Database;

import java.sql.*;

// Using constants
public class JDBC_02 {
    public static final String DB_NAME = "test.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Java DB\\sqlite-jdbc\\db\\";

    public static final String TABLE_NAME = "contacts";

    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE = "phone";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Java DB\\sqlite-jdbc\\db\\test.db");
            Statement stmt = conn.createStatement();

            stmt.execute("DROP TABLE IF EXISTS " + TABLE_NAME);

            stmt.execute("CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                            " (" + COLUMN_NAME + " VARCHAR(100), " +
                                   COLUMN_EMAIL + " VARCHAR(100), " +
                                   COLUMN_PHONE + " INTEGER" + ")");

            stmt.execute("INSERT INTO " + TABLE_NAME +
                              " (" + COLUMN_NAME + ", " +
                                     COLUMN_EMAIL + ", " +
                                     COLUMN_PHONE + ") " +
                                    "VALUES('Tim', 'tim@gmail.com', 123456)");

            stmt.execute("INSERT INTO " + TABLE_NAME +
                    " (" + COLUMN_NAME + ", " +
                    COLUMN_EMAIL + ", " +
                    COLUMN_PHONE + ") " +
                    "VALUES('Red', 'red@gmail.com', 1235356)");

            stmt.execute("INSERT INTO " + TABLE_NAME +
                    " (" + COLUMN_NAME + ", " +
                    COLUMN_EMAIL + ", " +
                    COLUMN_PHONE + ") " +
                    "VALUES('Green', 'green@gmail.com', 155456)");

            stmt.execute("INSERT INTO " + TABLE_NAME +
                    " (" + COLUMN_NAME + ", " +
                    COLUMN_EMAIL + ", " +
                    COLUMN_PHONE + ") " +
                    "VALUES('Blue', 'blue@gmail.com', 151316)");

            stmt.execute("UPDATE " + TABLE_NAME + " SET " +
                              COLUMN_PHONE + " = 555555" + " WHERE " +
                              COLUMN_NAME + " = 'red'");

            stmt.execute("DELETE FROM " + TABLE_NAME + " WHERE " +
                    COLUMN_NAME + " = 'green'");

            ResultSet rs = stmt.executeQuery("SELECT * FROM " + TABLE_NAME);
            while (rs.next()) {
                System.out.println(rs.getString(COLUMN_NAME) + " " + rs.getString(COLUMN_EMAIL) + " " + rs.getInt(COLUMN_PHONE));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
