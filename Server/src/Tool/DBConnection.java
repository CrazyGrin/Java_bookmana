package Tool;

import java.sql.*;

/**
 * Created by yunhan on 2017/5/16.
 */

public class DBConnection {

    private String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private String dbAddress = "jdbc:mysql://localhost:3306/java";

    private String userName = "admin";
    private String passWord = "admin";

    private Connection connection = null;
    private Statement statement = null;

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("connect...");
            connection = DriverManager.getConnection(dbAddress, userName, passWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean excuteSqlWithoutResult(String sql) {
        try {
            statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);

            statement.close();
            connection.close();
            if (rows != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public String excuteSqlWithResult(String sql) {
        String responseData = "";
        try {
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            //输出结果集
            while (rs.next()) {
                //通过字段检索
                String book_id = rs.getString("book_id");
                String book_num = rs.getString("book_num");
                String book_name = rs.getString("book_name");
                String book_author = rs.getString("book_author");
                String book_price = rs.getString("book_price");

                responseData = responseData + book_id + ";" + book_num + ";" + book_name + ";" + book_author + ";" + book_price + ";";
                //输出数据
                System.out.println("------------------------");
                System.out.println("书ID: " + book_id);
                System.out.println("书号: " + book_num);
                System.out.println("书名: " + book_name);
                System.out.println("作者: " + book_author);
                System.out.println("价格: " + book_price);
            }
            System.out.println(responseData);
            // 完成后关闭
            rs.close();
            statement.close();
            connection.close();
            return responseData;
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
        return responseData;
    }


}