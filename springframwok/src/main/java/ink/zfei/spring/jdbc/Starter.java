package ink.zfei.spring.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Starter {

    static List<Connection> list = new ArrayList<>();

    //桥接模式
    public static void main(String[] args) throws SQLException {


//        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = null;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        try {
            if (list.size() > 0) {
                conn = list.get(0);
            } else {
                conn = DriverManager.getConnection("jdbc:mysql://118.190.155.151:3306/demo", "root", "123456");
            }
//        Statement stmt = conn.createStatement();

            conn.setAutoCommit(false);    //  ==mysql.begin

            String sql = "select * from device where id =  ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 1);

            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                System.out.println("name =" + resultSet.getString(2));
                System.out.println("status =" + resultSet.getInt(3));
            }

            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            resultSet.close();
            stmt.close();
            list.add(conn);
//            conn.close();
        }

    }
}
