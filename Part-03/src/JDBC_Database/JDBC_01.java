package JDBC_Database;

import java.sql.*;

public class JDBC_01 {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Java DB\\sqlite-jdbc\\db\\test.db");
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS contacts" +
                            "(name VARCHAR(100), email VARCHAR(100), phone INTEGER)");
//            stmt.execute("INSERT INTO contacts (name, email, phone)" +
//                            "VALUES ('Tim', 'tim@test.com', 123456)");
//            stmt.execute("INSERT INTO contacts (name, email, phone)" +
//                    "VALUES ('Joe', 'joe@test.com', 131315)");
//            stmt.execute("INSERT INTO contacts (name, email, phone)" +
//                    "VALUES ('Blue', 'blue@test.com', 145556)");
//            stmt.execute("INSERT INTO contacts (name, email, phone)" +
//                    "VALUES ('Sim', 'sim@test.com', 684643)");

//            stmt.execute("UPDATE contacts SET phone = 252545 WHERE name = 'Joe'");
//            stmt.execute("DELETE FROM contacts WHERE name = 'Joe'");

//            stmt.execute("SELECT * FROM contacts");
//            ResultSet rs = stmt.getResultSet();

            ResultSet rs = stmt.executeQuery("SELECT * FROM contacts");
            while (rs.next()) {
                System.out.println(rs.getString("name") + " "
                                    + rs.getString("email") + " "
                                    + rs.getInt("phone"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
