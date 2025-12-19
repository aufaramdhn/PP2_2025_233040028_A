package latihan.pertemuan6.tugas;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDB {
    private static Connection mysqlconfig;

    public static  Connection configDB() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/db_latihan6";
            String user = "root";
            String pass = "";

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection(url, user, pass);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal :" + e.getMessage());
        }
        return mysqlconfig;
    }
}
