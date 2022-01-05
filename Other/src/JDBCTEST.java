import java.sql.*;

public class JDBCTEST {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        String driver="com.mysql.jdbc.Driver";
        //这里我的数据库是cxxt
        String url="jdbc:mysql://localhost:3306/myemployees";
        String user="root";
        String password="admin";
        try {
            Class.forName(driver);
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees","root","admin");
            statement=connection.createStatement();
            String sql1="select * from departments";
            String sql2="insert into departments values ('300','dcc',100,1000)";
            ResultSet resultSet1 = statement.executeQuery(sql1);
            while (resultSet1.next()){
                String id = resultSet1.getString(2);
                System.out.println("id为"+id);
            }


            int resultSet2=statement.executeUpdate(sql2);
            System.out.println("受影响的行数为"+resultSet2);
            //测试preparedstatement
            String sqlpre="select * from departments where department_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlpre);
            preparedStatement.setString(1,"10");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString(2);
                System.out.println("id为"+id);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //关闭连接
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }


        }
    }
}
