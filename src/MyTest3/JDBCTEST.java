package MyTest3;

import java.sql.*;
public class JDBCTEST {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        String driver="com.mysql.cj.jdbc.Driver";
        //这里我的数据库是cxxt
        String url="jdbc:mysql://localhost:3306/myemployees";
        String user="root";
        String password="admin";
        try {
            Class.forName(driver);
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees","root","admin");
            statement=connection.createStatement();
            String sql="select * from departments";
            ResultSet resultSet = statement.executeQuery(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
